package tests;

import static org.junit.Assert.*;
import monJeu.MonJeu;
import monJeu.Personnage;
import monJeu.Case;

import org.junit.Test;


/**
 * Classe de tests pour la fonctionnalite 1.1
 * (Creation d'un labyrinthe par defaut)
 */
public class TestsAffichage {

	@Test
	/**
	 * Methode de test permettant de tester si la position
	 * du personnage est bien initialisee
	 */
	public void test_Personnage_PlacementLabyrinthe() {
		
		//Preparation des donnees
		//Methode testee
		MonJeu mj = new MonJeu(11);
		Personnage p = mj.getPj();
		
		//Validation des resultats
		assertEquals("La position en abscisse du personnage devrait etre 5.", 5, p.x);
		assertEquals("La position en ordonnee du personnage devrait etre 5.", 5, p.y);
		
	}
	
	
	@Test
	/**
	 * Methode de test permettant de tester que 
	 * le labyrinthe est entoure de murs
	 */
	public void test_MonJeu_Murs() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(11);
		Case[][] cases = new Case[11][11];
		
		//Methode testee
		cases = mj.getCases();
		
		//Validation des resultats
		for(int i=0; i < cases.length; i++) {
			
			for(int j=0; j < cases.length; j++) {
				
				if((i == 0) || (i == cases.length-1) || (j == 0) || (j == cases[i].length-1)) {
					assertEquals("La case (" + i + "," + j + ") devrait etre un mur.", "type:mur", cases[i][j].toString());
				}
	
			}
			
		}
		
	}
	
	
	@Test
	/**
	 * Methode de test permettant de tester le nombre de cases 
	 * en largeur et en hauteur (taille 10*10)
	 */
	public void test_MonJeu_Taille() {
		
		//Preparation des donnees
		//Methode testee
		MonJeu mj = new MonJeu(11);
		
		//Validation des resultats
		assertEquals("La largeur du labyrinthe devrait etre 10.", 10, mj.getCases().length-1);
		
	}

}
