package tests;

import static org.junit.Assert.*;
import monJeu.Case;
import monJeu.MonJeu;
import monJeu.Monstre;
import monJeu.Personnage;
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
		MonJeu mj = new MonJeu(31);
		Monstre m = (Monstre) mj.getPj(1);
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
		MonJeu mj = new MonJeu(31);
		Monstre m = (Monstre) mj.getPj(1);
		Commande c = new Commande();
		
		//VERIFIER LE TEST LORSQUE LE MONSTRE POURRA FRAPPER PAR EXEMPLE
		
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
	
	
	@Test
	/**
	 * Methode de test permettant de tester qu'un fantome se deplace aleatoirement 
	 * tout en restant dans la zone du labyrinthe
	 */
	public void test_Monstre_Fantome_ZoneLabyrinthe() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(31);
		Monstre m = (Monstre) mj.getPj(1);
		Commande c = new Commande();
		c.haut = true;
		boolean dansLabyrinthe = true;
		
		for(int i=0; i < 500; i++) {
			
			//Methode testee
			mj.evoluer(c);
			
			if((m.x < 0) || (m.x > MonJeu.TAILLE_PLATEAU-1) || (m.y < 0) || (m.y > MonJeu.TAILLE_PLATEAU-1)) {
				dansLabyrinthe = false;
			}
			
			//Validation des resultats
			assertTrue("Le fantome devrait toujours se trouver dans la zone du labyrinthe (murs compris).", dansLabyrinthe);
			
		}
		
	}
	
	
	@Test
	/**
	 * Methode de test permettant de tester qu'un orc se deplace aleatoirement 
	 * tout en restant dans la zone du labyrinthe
	 */
	public void test_Monstre_Orc_BloqueObstacles() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(31);
		Monstre m = (Monstre) mj.getPj(2);
		Commande c = new Commande();
		c.haut = true;
		boolean dansLabyrinthe = true;
		boolean surMur = false;
		Case[][] tab_cases = mj.getCases();
		
		for(int i=0; i < 500; i++) {
			
			//Methode testee
			mj.evoluer(c);
			
			for(int j=0; j < tab_cases.length; j++) {
				
				for (int k=0; k < tab_cases[j].length; k++) {
					
					if(!tab_cases[m.x][m.y].estFranchissable()) {
						surMur = true;
					}
					
				}
				
			}
			
			if((m.x < 0) || (m.x > MonJeu.TAILLE_PLATEAU-1) || (m.y < 0) || (m.y > MonJeu.TAILLE_PLATEAU-1) || (surMur)) {
				dansLabyrinthe = false;
			}
			
			//Validation des resultats
			assertTrue("L'orc devrait toujours se trouver dans la zone du labyrinthe.", dansLabyrinthe);
			
		}
		
	}
	
	
	@Test
	/**
	 * Methode de test permettant de tester qu'un heros et un monstre
	 * ne peuvent pas se trouver sur une meme case dans le labyrinthe
	 */
	public void test_Monstre_PasMemePositionQueHeros() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(31);
		Monstre m = (Monstre) mj.getPj(1);
		Personnage p = mj.getPj(0);
		boolean memePosition = false;
		
		for(int i=0; i < 500; i++) {
			
			int alea = (int)Math.random()*4;
			
			Commande c = new Commande();
			
			switch(alea) {
			
			case 0:
				c.haut = true;
				break;
				
			case 1:
				c.bas = true;
				break;
				
			case 2:
				c.droite = true;
				break;
				
			case 3:
				c.gauche = true;
				break;
				
			}
			
			//Methode testee
			mj.evoluer(c);
			
			if((m.x == p.x) && (m.y == p.y)) {
				memePosition = true;
			}
			
			//Validation des resultats
			assertTrue("Le monstre et le heros ne devraient pas se trouver sur la meme case.", !memePosition);
			
		}
		
	}
	
	
	@Test
	/**
	 * Methode de test permettant de tester qu'un monstre et un autre monstre
	 * ne peuvent pas se trouver sur une meme case dans le labyrinthe
	 */
	public void test_Monstre_PasMemePositionQueAutreMonstre() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(31);
		Monstre m1 = (Monstre) mj.getPj(1);
		Monstre m2 = (Monstre) mj.getPj(2);
		Commande c = new Commande();
		c.haut = true;
		boolean memePosition = false;
		
		for(int i=0; i < 500; i++) {
			
			//Methode testee
			mj.evoluer(c);
			
			if((m1.x == m2.x) && (m1.y == m2.y)) {
				memePosition = true;
			}
			
			//Validation des resultats
			assertTrue("Le monstre et l'autre monstre ne devraient pas se trouver sur la meme case.", !memePosition);
			
		}
		
	}
	
	
	@Test
	/**
	 * Methode de test permettant de tester que tous les monstres
	 * se deplacent a chaque evolution
	 */
	public void test_Monstres_DeplacementsTousEvolution() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(31);
		Monstre m1 = (Monstre) mj.getPj(1);
		Monstre m2 = (Monstre) mj.getPj(2);
		Commande c = new Commande();
		c.haut = true;
		
		int posXInitM1 = m1.x;
		int posYInitM1 = m1.y;
		
		int posXInitM2 = m2.x;
		int posYInitM2 = m2.y;
		
		boolean deplacementM1 = false;
		boolean deplacementM2 = false;
		
		//Methode testee
		mj.evoluer(c);
		
		deplacementM1 = ((m1.x != posXInitM1) || (m1.y != posYInitM1));
		deplacementM2 = ((m2.x != posXInitM2) || (m2.y != posYInitM2));
		
		//Validation des resultats
		assertTrue("Le monstre 1 devrait avoir change de position", deplacementM1);
		assertTrue("Le monstre 2 devrait avoir change de position", deplacementM2);
		
	}
	
}
