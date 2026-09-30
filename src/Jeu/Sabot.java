package Jeu;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;

import Cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbcartes;
	private int nbOperations = 0;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbcartes = cartes.length;
	}

	public boolean estVide() {
		return nbcartes == 0;
	}

	public void ajouteCartes(Carte carte) {
		if (nbcartes < cartes.length) {
			throw new IllegalStateException("le sabot est plein , impossible d'aujouter une carte");

		}
		cartes[nbcartes] = carte;
		nbcartes++;
		nbOperations++;

	}

	@Override
	public Iterator<Carte> iterator() {
		return new IterateurSabot();
	}

	public Carte piocher() {
		Iterator<Carte> it = iterator();
		Carte carte = it.next();
		it.remove();
		return carte;
	}

	private class IterateurSabot implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationsReference = nbOperations;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbcartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Carte carte = cartes[indiceIterateur];
			indiceIterateur++;
			nextEffectue = true;
			return carte;
		}

		@Override
		public void remove() {
			verificationConcurrence();
			if (!nextEffectue) {
				throw new IllegalStateException("remove() appelé sans next() préalable");
			}
			for (int i = indiceIterateur - 1; i < nbcartes - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			cartes[nbcartes - 1] = null;
			nbcartes--;
			indiceIterateur--;
			nextEffectue = false;
			nbOperations++;
			nbOperationsReference++;
		}

		private void verificationConcurrence() {
			if (nbOperations != nbOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
	}

}
