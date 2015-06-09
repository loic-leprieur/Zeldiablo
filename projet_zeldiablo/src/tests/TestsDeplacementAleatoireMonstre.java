package tests;

import static org.junit.Assert.*;
import monJeu.Case;
import monJeu.Fantome;
import monJeu.MonJeu;
import monJeu.Monstre;
import monJeu.Personnage;
import monJeu.Orc;
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
		Orc t = (Orc) mj.getPj(1);
		Commande c = new Commande();
		c.haut = true;
		int posXInit = t.getX();
		int posYInit = t.getY();
		boolean deplacement = false;
		
		//Methode testee
		mj.evoluer(c);
		deplacement = ((t.getX() != posXInit) || (t.getY() != posYInit));
		
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
		Orc t = (Orc) mj.getPj(1);
		Commande c = new Commande();
		
		//VERIFIER LE TEST LORSQUE LE MONSTRE POURRA FRAPPER PAR EXEMPLE
		
		/*c.frapper = true;*/
		int posXInit = t.getX();
		int posYInit = t.getY();
		boolean deplacement = false;
		
		//Methode testee
		mj.evoluer(c);
		deplacement = ((t.getX() != posXInit) || (t.getY() != posYInit));
		
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
		Fantome f = (Fantome) mj.getPj(2);
		Commande c = new Commande();
		c.haut = true;
		boolean dansLabyrinthe = true;
		
		for(int i=0; i < 500; i++) {
			
			//Methode testee
			mj.evoluer(c);
			
			if((f.getX() < 0) || (f.getX() > MonJeu.TAILLE_PLATEAU-1) || (f.getY() < 0) || (f.getY() > MonJeu.TAILLE_PLATEAU-1)) {
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
	public void test_Monstre_Troll_BloqueObstacles() {
		
		//Preparation des donnees
		MonJeu mj = new MonJeu(31);
		Orc t = (Orc)mj.getPj(1);
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
					
					if(!tab_cases[t.getX()][t.getY()].estFranchissable()) {
						surMur = true;
					}
					
				}
				
			}
			
			if((t.getX() < 0) || (t.getX() > MonJeu.TAILLE_PLATEAU-1) || (t.getY() < 0) || (t.getY() > MonJeu.TAILLE_PLATEAU-1) || (surMur)) {
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
		Orc t = (Orc) mj.getPj(1);
		Personnage p = mj.getPj(0);
		boolean memePosition = false;
		
		for(int i=0; i < 500; i++) {
			
			int alea = (int)(Math.random()*4);
			
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
			
			if((t.getX() == p.getX()) && (t.getY() == p.getY())) {
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
		Orc t1 = (Orc) mj.getPj(1);
		Fantome t2 = (Fantome) mj.getPj(2);
		Commande c = new Commande();
		c.haut = true;
		boolean memePosition = false;
		
		for(int i=0; i < 500; i++) {
			
			//Methode testee
			mj.evoluer(c);
			
			if((t1.getX() == t2.getX()) && (t1.getY() == t2.getY())) {
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
		Orc t1 = (Orc) mj.getPj(1);
		Fantome t2 = (Fantome) mj.getPj(2);
		Commande c = new Commande();
		c.haut = true;
		
		int posXInitM1 = t1.getX();
		int posYInitM1 = t1.getX();
		
		int posXInitM2 = t2.getY();
		int posYInitM2 = t2.getY();
		
		boolean deplacementM1 = false;
		boolean deplacementM2 = false;
		
		//Methode testee
		mj.evoluer(c);
		
		deplacementM1 = ((t1.getX() != posXInitM1) || (t1.getY() != posYInitM1));
		deplacementM2 = ((t2.getX() != posXInitM2) || (t2.getY() != posYInitM2));
		
		//Validation des resultats
		assertTrue("Le monstre 1 devrait avoir change de position", deplacementM1);
		assertTrue("Le monstre 2 devrait avoir change de position", deplacementM2);
		
	}
	
}
