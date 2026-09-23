package Jeu;

import Cartes.Carte;

public class Sabot {
	private Carte[] cartes;
	private int nbcartes;

	public Sabot(Carte[] cartes, int nbcartes) {
		this.cartes = cartes;
		this.nbcartes = nbcartes;
	}
	
	public Boolean estVide() {
		return nbcartes==0;
	}
	public void ajouteCartes(Carte carte) {
		if (nbcartes<cartes.length) {
			throw new IllegalStateException("le sabot est plein , impossible d'aujouter une carte");
			
		}
		cartes[nbcartes]=carte;
		nbcartes++;
		
	}

}
