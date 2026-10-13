package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Random;

public class GestionCartes {

	private static final Random RANDOM = new Random();

	private GestionCartes() {
	}

	// a. extraire, version 1 : directement sur la liste
	public static <T> T extraire(List<T> liste) {
		int index = RANDOM.nextInt(liste.size());
		return liste.remove(index);
	}

	// a. extraire, version 2 : avec un ListIterator
	public static <T> T extraireIterator(List<T> liste) {
		int index = RANDOM.nextInt(liste.size());
		ListIterator<T> it = liste.listIterator();
		T element = null;
		for (int i = 0; i <= index; i++) {
			element = it.next();
		}
		it.remove();
		return element;
	}

	// b. melanger : la liste passee en argument est videe
	public static <T> List<T> melanger(List<T> liste) {
		List<T> resultat = new ArrayList<>();
		while (!liste.isEmpty()) {
			resultat.add(extraire(liste));
		}
		return resultat;
	}

	// c. verifierMelange
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if (liste1.size() != liste2.size()) {
			return false;
		}
		for (T element : liste1) {
			if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
				return false;
			}
		}
		return true;
	}

	// d. rassembler, version 1
	public static <T> List<T> rassembler(List<T> liste) {
		List<T> resultat = new ArrayList<>();
		for (T element : liste) {
			if (!resultat.contains(element)) {
				resultat.addAll(Collections.nCopies(Collections.frequency(liste, element), element));
			}
		}
		return resultat;
	}

	// d. rassembler, version 2 (celle utilisee dans le test du sujet)
	public static <T> List<T> rassemberV2(List<T> liste) {
		List<T> copie = new ArrayList<>(liste);
		List<T> resultat = new ArrayList<>();
		while (!copie.isEmpty()) {
			T reference = copie.get(0);
			Iterator<T> it = copie.iterator();
			while (it.hasNext()) {
				T courant = it.next();
				if (Objects.equals(courant, reference)) {
					resultat.add(courant);
					it.remove();
				}
			}
		}
		return resultat;
	}

	// e. verifierRassemblement avec 2 ListIterator
	public static <T> boolean verifierRassemblement(List<T> liste) {
		ListIterator<T> it = liste.listIterator();
		if (!it.hasNext()) {
			return true;
		}
		T ancien = it.next();
		while (it.hasNext()) {
			T courant = it.next();
			if (!Objects.equals(courant, ancien)) {
				// changement de valeur : on cherche l'ancienne valeur dans le reste
				ListIterator<T> it2 = liste.listIterator(it.nextIndex());
				while (it2.hasNext()) {
					if (Objects.equals(it2.next(), ancien)) {
						return false;
					}
				}
				ancien = courant;
			}
		}
		return true;
	}

}