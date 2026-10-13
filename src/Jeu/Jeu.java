package Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Cartes.Carte;
import Cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;

	public Jeu() {
		// a. tableau de cartes -> liste (Collections.addAll), puis melange
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, jeuDeCartes.donnerCartes());
		listeCartes = GestionCartes.melanger(listeCartes);

		// b. liste -> tableau (toArray), puis creation du sabot
		sabot = new Sabot(listeCartes.toArray(new Carte[0]));
	}

	public Sabot getSabot() {
		return sabot;
	}

}