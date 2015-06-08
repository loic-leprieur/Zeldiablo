package tests;

import static org.junit.Assert.*;
import monJeu.MonJeu;
import monJeu.Personnage;
import moteurJeu.Commande;

import org.junit.Test;

public class TestsCollisions {
	
	/**
	 * si personnage se deplace en abscisse
	 * et que la case d'arrivée est franchissable 
	 */
	@Test
	public void testDeplacerVersCaseFranchissable() {
		//donnees
		MonJeu jeu=new MonJeu();
		Personnage heros=jeu.getPj();
		Case[][] tab_cases=jeu.tab_cases; //[x]ligne [y]colonne
		
		//methode testee
		Commande allerAdroite = new Commande();
		allerAdroite.droite=true;
		jeu.evoluer(allerAdroite);
		Case caseArrivee=tab_cases[heros.x][heros.y];
		
		//validation du test
		assertEquals("Le personnage s'est deplace sur une case franchissable ",true, heros.x==caseArrivee.x);
	}

}
