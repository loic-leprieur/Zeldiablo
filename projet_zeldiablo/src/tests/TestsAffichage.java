package tests;

import static org.junit.Assert.*;
import monJeu.MonJeu;
import monJeu.Personnage;

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
		MonJeu mj = new MonJeu();
		Personnage p = mj.getPj();
		
		//Validation des resultats
		assertEquals("La position en abscisse du personnage devrait etre 4.", 4, p.x);
		assertEquals("La position en ordonnee du personnage devrait etre 4.", 4, p.y);
		
	}
	

}
