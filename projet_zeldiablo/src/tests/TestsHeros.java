package tests;

import static org.junit.Assert.*;
import monJeu.Heros;
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
		
		//Methode testee
		boolean res = (zelda.x==5 && zelda.y==5);
		
		//Validation des resultats
		assertEquals("Doit se trouver en position 5.5",true, res);
		
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
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.x==4 && zelda.y==5);
		
		//Validation ds resultats
		assertEquals("Aventurier doit se trouve en position 4.5",true,res);
	}
	
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers la droite
	 */
	@Test
	public void TestDeplacementDroite(){
		
		//Preparation des donnees
		Heros zelda = new Heros();
		Commande c = new Commande();
		c.droite = true;
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.x==6 && zelda.y==5);
		
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 6.5",true,res);
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
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.x==5 && zelda.y==4);
		
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 5.4",true,res);
	}
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers le bas
	 */
	@Test
	public void TestDeplacementBas(){
		
		//Preparation des donnees
		Heros zelda = new Heros();
		Commande c = new Commande();
		c.bas = true;
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.x==5 && zelda.y==6);
		
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 5.6",true,res);
	}
	
	




}
