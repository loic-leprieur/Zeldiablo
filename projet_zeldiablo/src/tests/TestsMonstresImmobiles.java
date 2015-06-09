package tests;

import static org.junit.Assert.*;
import monJeu.Case;
import monJeu.Heros;
import monJeu.MonJeu;
import monJeu.Monstre;
import moteurJeu.Commande;

import org.junit.Test;

import sun.management.counter.perf.PerfInstrumentation;
/**
 * 
 * @author Loïc
 *
 */
public class TestsMonstresImmobiles {
	
	/**
	 * On cree des monstres sur une case (1,1)
	 * dans un labyrinthe par defaut
	 */
	@Test
	public void testMonstresCrees() {
		//donnees
		MonJeu jeu=new MonJeu(31);
		Monstre mob=(Monstre) jeu.getPj(1);
		Case[][] cases=jeu.getCases();	
		boolean occupee = false;
		
		//Methode testee
		if(cases[mob.getX()][mob.getY()].estFranchissable()) { 
			occupee = cases[mob.getX()][mob.getY()].estOccupee();
		}
		
		//valide le test
		assertEquals("Le monstre a ete cree sur la case vide",true, occupee);
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testMonstresNonCreesSurCasesNonVides() {
		//donnees
		MonJeu jeu=new MonJeu(31);
		Monstre mob1 = (Monstre) jeu.getPj(1);
		Monstre mob2 = (Monstre) jeu.getPj(2);
		Heros h = (Heros) jeu.getPj(0);
		Case[][] cases=jeu.getCases();
				
		//Methode testee
		boolean pasMemePlaceMonstre = ((mob1.getX() != mob2.getX()) || (mob1.getY() != mob2.getY()));
		boolean pasMemePlaceHeros = ((mob1.getX() != h.getX()) || (mob1.getY() != mob2.getY()));
		boolean pasSurMemeCase = (pasMemePlaceMonstre && pasMemePlaceHeros);
						
		//valide le test
		assertEquals("Le monstre a ete cree sur la case vide",true, pasSurMemeCase);
	}
	
	//donnees
	/**MonJeu jeu=new MonJeu(jeu.TAILLE_PLATEAU);
	Monstre mob=(Monstre) jeu.getPj();
	Commande cmd=new Commande();
	Boolean aBouge=false;
		
	//methode testee
	int lastX, lastY;
	lastX=mob.x;
	lastY=mob.y;
	jeu.evoluer(cmd);
			
	if(lastX!=mob.x && lastY!=mob.y){
		aBouge=true;
	}
	//valide le test
	assertEquals(true, aBouge);	
	**/
	

}
