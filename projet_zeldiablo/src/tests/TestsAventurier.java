package tests;

import static org.junit.Assert.*;

import org.junit.*;

import application.Aventurier;

import application.Aventurier;

public class TestsAventurier {

	/**
	 * Test de la position initiale de l'aventurier 
	 * 
	 */
	@Test
	public void TestPositionInitiale(){
		//Preparation des donnees
		Aventurier zelda = new Aventurier();
		
		//Methode testee
		boolean res = (zelda.getPosX()==5 && zelda.getPosY()==5);
		
		//Validation des resultats
		assertEquals("Doit se trouver en position 5.5",true, res);
		
	}
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers la gauche
	 */
	@Test
	public void TestDeplacementGauche(){
		//Preparation des donnees
		Aventurier zelda = new Aventurier();
		
		//Methode testee
		zelda.seDeplacer(-2,0);
		boolean res = (zelda.getPosX()==3 && zelda.getPosY()==5);
		//Validation ds resultats
		assertEquals("Aventurier doit se trouve en position 3.5",true,res);
	}
	
	
	/**
	 * Test de la position de l'aventurier pour un deplacement vers la droite
	 */
	@Test
	public void TestDeplacementDroite(){
		//Preparation des donnees
		Aventurier zelda = new Aventurier();
		
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
		Aventurier zelda = new Aventurier();
		
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
		Aventurier zelda = new Aventurier();
		
		//Methode testee
		zelda.seDeplacer(0,2);
		boolean res = (zelda.getPosX()==5 && zelda.getPosY()==7);
		//Validation des resultats
		assertEquals("Aventurier doit se trouve en position 5.7",true,res);
	}
	
	




}
