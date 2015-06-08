package tests;

import static org.junit.Assert.*;
import monJeu.Personnage;
import moteurJeu.Commande;

import org.junit.*;

public class TestsAventurier {

	/**
	 * Test de la position initiale de l'aventurier 
	 * 
	 */
	@Test
	public void TestPositionInitiale(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		
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
		Personnage zelda = new Personnage();
		int precX=zelda.x;
		int precY=zelda.y;
		//Methode testee
		Commande c = new Commande();
		c.haut=true;
		c.gauche=true;
		zelda.deplacer(c);
		boolean res = (zelda.x>=precX && zelda.y<=precY);
		//Validation ds resultats
		assertEquals("Aventurier est a gauche en haut",true,res);
	}
	
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers la droite
	 */
	@Test
	public void TestDeplacementDroite(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		
		//Methode testee
		zelda.seDeplacer(2,0);
		boolean res = (zelda.getPosX()==7 && zelda.getPosY()==5);
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 7.5",true,res);
	}
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers le haut
	 */
	@Test
	public void TestDeplacementHaut(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		
		//Methode testee
		zelda.seDeplacer(0,-2);
		boolean res = (zelda.getPosX()==5 && zelda.getPosY()==3);
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 5.3",true,res);
	}
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers le bas
	 */
	@Test
	public void TestDeplacementBas(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		
		//Methode testee
		zelda.seDeplacer(0,2);
		boolean res = (zelda.getPosX()==5 && zelda.getPosY()==7);
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 5.7",true,res);
	}
	
	




}
