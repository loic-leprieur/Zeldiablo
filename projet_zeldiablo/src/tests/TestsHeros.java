package tests;

import static org.junit.Assert.*;
import monJeu.DessinMonJeu;
import monJeu.Heros;
import monJeu.MonJeu;
import moteurJeu.Commande;

import org.junit.*;

public class TestsHeros {
	

	/**
	 * Test de la position initiale de l'aventurier 
	 * 
	 */
	@Test
	public void TestPositionInitiale(){
		
		//Preparation des donnees
		Heros zelda = new Heros();
		zelda.setX(4);
		zelda.setY(4);
		
		//Methode testee
		boolean res = (zelda.getX()==4 && zelda.getY()==4);
		
		//Validation des resultats
		assertEquals("Doit se trouver en position 4.4",true, res);
		
	}
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers la gauche
	 */
	@Test
	public void TestDeplacementGauche(){
		
		//Preparation des donnees
		Heros zelda = new Heros();
		Commande c = new Commande();
		c.gauche = true;
		zelda.setX(4);
		zelda.setY(4);
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.getX()==3 && zelda.getY()==4);
		
		//Validation ds resultats
		assertEquals("Aventurier doit se trouve en position 3.4",true,res);
	}
	
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers la droite
	 */
	@Test
	public void TestDeplacementDroite(){
		
		//Preparation des donnees
		MonJeu.TAILLE_PLATEAU = 10;
		Heros zelda = new Heros();
		Commande c = new Commande();
		c.droite = true;
		zelda.setX(4);
		zelda.setY(4);
		
		//Methode testee
		zelda.deplacer(c);
		int testX = zelda.getX();
		boolean res = ((zelda.getX()==5) && (zelda.getY()==4));
		
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 5.4",true,res);
	}
	
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers le haut
	 */
	@Test
	public void TestDeplacementHaut(){
		
		//Preparation des donnees
		Heros zelda = new Heros();
		Commande c = new Commande();
		c.haut = true;
		zelda.setX(4);
		zelda.setY(4);
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.getX()==4 && zelda.getY()==3);
		
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 4.3",true,res);
	}
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers le bas
	 */
	@Test
	public void TestDeplacementBas(){
		
		//Preparation des donnees
		MonJeu.TAILLE_PLATEAU = 10;
		Heros zelda = new Heros();
		Commande c = new Commande();
		c.bas = true;
		zelda.setX(4);
		zelda.setY(4);
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.getX()==4 && zelda.getY()==5);
		
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 0.1",true,res);
	}
	
	




}
