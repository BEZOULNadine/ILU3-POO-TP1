package testJeuDeCartes;

import Cartes.Attaque;
import Cartes.Borne;
import Cartes.Parade;
import Cartes.Type;

public class TestMethodeEquals {
	public static void main(String[] args) {
		// a. deux bornes 25km
		Borne borne1 = new Borne(25);
		Borne borne2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? " + borne1.equals(borne2));

		// b. deux feux rouges (Attaque FEU)
		Attaque feuRouge1 = new Attaque(Type.FEU);
		Attaque feuRouge2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouge sont identiques ? " + feuRouge1.equals(feuRouge2));

		// c. un feu rouge (Attaque FEU) et un feu vert (Parade FEU)
		Parade feuVert = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + feuRouge1.equals(feuVert));
	}

}
