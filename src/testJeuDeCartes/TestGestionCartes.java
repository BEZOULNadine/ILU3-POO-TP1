package testJeuDeCartes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Cartes.Carte;
import Cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {

	// Methode statique generique : melange une COPIE, donc la liste initiale n'est
	// pas detruite
	private static <T> void testerMelange(List<T> initiale) {
		List<T> melangee = GestionCartes.melanger(new ArrayList<>(initiale));
		System.out.println(initiale + " -> " + melangee);
		System.out.println("liste melangee sans erreur ? " + GestionCartes.verifierMelange(initiale, melangee));
	}

	private static <T> void testerRassemblement(List<T> liste) {
		System.out.println(liste + " rassemblee ? " + GestionCartes.verifierRassemblement(liste));
		List<T> v1 = GestionCartes.rassembler(liste);
		List<T> v2 = GestionCartes.rassemberV2(liste);
		System.out.println("  V1 : " + v1 + " -> " + GestionCartes.verifierRassemblement(v1));
		System.out.println("  V2 : " + v2 + " -> " + GestionCartes.verifierRassemblement(v2));
	}

	public static void main(String[] args) {
		// extraire (2 versions)
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		List<Integer> l2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("extraire : " + GestionCartes.extraire(l1) + " reste " + l1);
		System.out.println("extraireIterator : " + GestionCartes.extraireIterator(l2) + " reste " + l2);

		// melange
		testerMelange(Arrays.asList(1, 1, 2, 1, 3));

		// rassemblement sur les listes du sujet
		testerRassemblement(new ArrayList<Integer>());
		testerRassemblement(Arrays.asList(1, 1, 2, 1, 3));
		testerRassemblement(Arrays.asList(1, 4, 3, 2));
		testerRassemblement(Arrays.asList(1, 1, 2, 3, 1));

		// test du sujet avec le jeu de cartes
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println(
				"liste melangee sans erreur ? " + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassemberV2(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblee sans erreur ? " + GestionCartes.verifierRassemblement(listeCartes));
	}

}