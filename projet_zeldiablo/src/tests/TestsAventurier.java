package tests;

import static org.junit.Assert.*;

import src.*;
import org.junit.*;

public class TestsAventurier {

	/**
	 * Test de la position initiale de l'aventurier 
	 * 
	 */
	@Test
	public void TestPositionInitiale(){
		//mise en place
		Aventurier zelda = new Aventurier();
		
		//test
		boolean res = (zelda.getPosX()==5 && zelda.getPosY()==5);
		
		//vérifications
		assertEquals("Doit se trouver en position 5.5",true, res);
		
	}
	
	/**
	 * Test de la position de l'aventurier pour un déplacement vers la gauche
	 */
	@Test
	public void TestDeplacementGauche(){
		//Mise en place 
		Aventurier zelda = new Aventurier();
		
		//Test
		zelda.seDeplacer(-2,0);
		boolean res = (zelda.getPosX()==3 && zelda.getPosY()==5);
		//Vérification
		assertEquals("Aventurier doit se trouve en position 3.5",true,res);
	}
	
	
	/**
	 * Test de la position de l'aventurier pour un déplacement vers la droite
	 */
	@Test
	public void TestDeplacementDroite(){
		//Mise en place 
		Aventurier zelda = new Aventurier();
		
		//Test
		zelda.seDeplacer(2,0);
		boolean res = (zelda.getPosX()==7 && zelda.getPosY()==5);
		//Vérification
		assertEquals("Aventurier doit se trouve en position 7.5",true,res);
	}
	
	/**
	 * Test de la position de l'aventurier pour un déplacement vers le haut
	 */
	@Test
	public void TestDeplacementHaut(){
		//Mise en place 
		Aventurier zelda = new Aventurier();
		
		//Test
		zelda.seDeplacer(0,-2);
		boolean res = (zelda.getPosX()==5 && zelda.getPosY()==3);
		//Vérification
		assertEquals("Aventurier doit se trouve en position 5.3",true,res);
	}
	
	/**
	 * Test de la position de l'aventurier pour un déplacement vers le bas
	 */
	@Test
	public void TestDeplacementBas(){
		//Mise en place 
		Aventurier zelda = new Aventurier();
		
		//Test
		zelda.seDeplacer(0,2);
		boolean res = (zelda.getPosX()==5 && zelda.getPosY()==7);
		//Vérification
		assertEquals("Aventurier doit se trouve en position 5.7",true,res);
	}
	
	




}
