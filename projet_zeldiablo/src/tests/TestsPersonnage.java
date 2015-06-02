package tests;

import static org.junit.Assert.*;

import org.junit.*;

import monJeu.Personnage;
import moteurJeu.Commande;


public class TestsPersonnage {

	/**
	 * Test de la position initiale de l'Personnage 
	 * 
	 */
	@Test
	public void TestPositionInitiale(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		
		//Methode testee
		boolean res = (zelda.x==7 && zelda.y==7);
		
		//Validation des resultats
		assertEquals("Doit se trouver en position 5.5",true, res);
		
	}
	
	/**
	 * Test de la position de l'Personnage pour un deplacement vers la gauche
	 */
	@Test
	public void TestDeplacementGauche(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		Commande c = new Commande();
		c.gauche = true;
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.x==6 && zelda.y==7);
		//Validation ds resultats
		assertEquals("Personnage doit se trouve en position 3.5",true,res);
	}
	
	
	/**
	 * Test de la position de l'Personnage pour un deplacement vers la droite
	 */
	@Test
	public void TestDeplacementDroite(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		Commande c = new Commande();
		c.droite = true;
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.x==8 && zelda.y==7);
		//Validation des resultats
		assertEquals("Personnage doit se trouve en position 7.5",true,res);
	}
	
	/**
	 * Test de la position de l'Personnage pour un deplacement vers le haut
	 */
	@Test
	public void TestDeplacementHaut(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		Commande c = new Commande();
		c.haut = true;
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.x==7 && zelda.y==6);
		//Validation des resultats
		assertEquals("Personnage doit se trouve en position 5.3",true,res);
	}
	
	/**
	 * Test de la position de l'Personnage pour un deplacement vers le bas
	 */
	@Test
	public void TestDeplacementBas(){
		//Preparation des donnees
		Personnage zelda = new Personnage();
		Commande c = new Commande();
		c.bas = true;
		
		//Methode testee
		zelda.deplacer(c);
		boolean res = (zelda.x==7 && zelda.y==8);
		//Validation des resultats
		assertEquals("Personnage doit se trouve en position 5.7",true,res);
	}
	
	




}
