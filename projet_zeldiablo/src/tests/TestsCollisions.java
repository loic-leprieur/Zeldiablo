package tests;

import static org.junit.Assert.*;
import monJeu.Case;
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
		Case[][] tab_cases=jeu.getCases(); //[x]ligne [y]colonne
		boolean aFranchis=false;
		
		//methode testee
		Commande allerAdroite = new Commande();
		allerAdroite.droite=true;
		jeu.evoluer(allerAdroite);
		Case caseArrivee=tab_cases[heros.x][heros.y];
		caseArrivee.setFranchissable(true);
		if(caseArrivee.estFranchissable()){
			aFranchis=true;
		}
		
		//validation du test
		assertEquals("Le personnage s'est deplace sur une case franchissable ",true, aFranchis);
	}

}
