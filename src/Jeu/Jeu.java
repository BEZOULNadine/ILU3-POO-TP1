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

		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, jeuDeCartes.donnerCartes());
		listeCartes = GestionCartes.melanger(listeCartes);

		sabot = new Sabot(listeCartes.toArray(new Carte[0]));
	}

	public Sabot getSabot() {
		return sabot;
	}

}