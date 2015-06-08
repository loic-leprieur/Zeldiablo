package tests;

import static org.junit.Assert.*;
import monJeu.MonJeu;
import monJeu.Monstre;
import moteurJeu.Commande;

import org.junit.Test;


/**
 * Classe de test testant les deplacements aleatoires d'un monstre
 */
public class TestsDeplacementAleatoireMonstre {

	
	@Test
	/**
	 * Methode de test permettant de tester qu'un monstre 
	 * se deplace aleatoirement lorsque le heros se deplace
	 */
	public void test_Monstre_DeplacementJoueur() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(11);
		Monstre m = mj.getPj(1);
		Commande c = new Commande();
		c.haut = true;
		int posXInit = m.x;
		int posYInit = m.y;
		boolean deplacement = false;
		
		//Methode testee
		mj.evoluer(c);
		deplacement = ((m.x != posXInit) || (m.y != posYInit));
		
		//Validation des resultats
		assertTrue("Le monstre devrait avoir change de position", deplacement);
		
	}

	
	@Test
	/**
	 * Methode de test permettant de tester qu'un monstre se deplace aleatoirement 
	 * lorsqu'une action, autre que le deplacement du joueur, est executee
	 */
	public void test_Monstre_NonDeplacementJoueur() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(11);
		Monstre m = mj.getPj(1);
		Commande c = new Commande();
		/*c.frapper = true;*/
		int posXInit = m.x;
		int posYInit = m.y;
		boolean deplacement = false;
		
		//Methode testee
		mj.evoluer(c);
		deplacement = ((m.x != posXInit) || (m.y != posYInit));
		
		//Validation des resultats
		assertTrue("Le monstre devrait avoir change de position", deplacement);
		
	}
	
}
