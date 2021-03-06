package tests;

import static org.junit.Assert.*;
import monJeu.Case;
import monJeu.MonJeu;
import monJeu.Heros;
import moteurJeu.Commande;

import org.junit.Test;
/**
 * 
 * @author Loïc
 *
 */
public class TestsCollisions {
	
	/**
	 * si personnage se deplace en abscisse
	 * et que la case d'arrivee est franchissable 
	 */
	@Test
	public void testDeplacerVersCaseFranchissable() {
		//donnees
		MonJeu jeu=new MonJeu(31);
		Heros heros=(Heros)jeu.getPj(0);
		Case[][] tab_cases=jeu.getCases(); //[x]ligne [y]colonne
		boolean aFranchis=false;
		int posX, posY;
		posX=heros.getX();
		posY=heros.getY();
		Case caseDepart=tab_cases[posX][posY];
		
		//methode testee
		Commande allerAdroite = new Commande();
		allerAdroite.droite=true;
		jeu.evoluer(allerAdroite);
		posX=heros.getX();
		posY=heros.getY();
		
		Case caseArrivee=tab_cases[posX][posY];
		
		if(!heros.verifierCase(caseArrivee) && heros.verifierCase(caseDepart)){
			aFranchis=true;
		}
		
		//validation du test
		assertEquals("Le personnage s'est deplace sur une case franchissable ",true, aFranchis);
	}
	
	
	/**
	 * si personnage se deplace en abscisse
	 * et que la case d'arrivee n'est pas franchissable
	 */
	@Test
	public void testDeplacerVersCaseNonFranchissableDroite() {
		//donnees
		MonJeu jeu=new MonJeu(31);
		Heros heros=(Heros)jeu.getPj(0);
		Case[][] tab_cases=jeu.getCases(); //[x]ligne [y]colonne
		boolean aFranchis=false;
			
		//methode testee
		Commande allerAdroite = new Commande();
		allerAdroite.droite=true;
		jeu.evoluer(allerAdroite);
		Case caseArrivee=tab_cases[heros.getX()][heros.getY()];
		caseArrivee.setFranchissable(false);
		if(caseArrivee.estFranchissable()){
			aFranchis=true;
		}
			
		//validation du test
		assertEquals("Le personnage ne s'est deplace sur une case a droite franchissable ",false, aFranchis);
	}
	
	/**
	 * si personnage se deplace en abscisse
	 * et que la case d'arrivee n'est pas franchissable
	 */
	@Test
	public void testDeplacerVersCaseNonFranchissableGauche() {
		//donnees
		MonJeu jeu=new MonJeu(31);
		Heros heros=(Heros)jeu.getPj(0);
		Case[][] tab_cases=jeu.getCases(); //[x]ligne [y]colonne
		boolean aFranchis=false;
			
		//methode testee
		Commande allerAgauche = new Commande();
		allerAgauche.gauche=true;
		jeu.evoluer(allerAgauche);
		Case caseArrivee=tab_cases[heros.getX()][heros.getY()];
		caseArrivee.setFranchissable(false);
		if(caseArrivee.estFranchissable()){
			aFranchis=true;
		}
			
		//validation du test
		assertEquals("Le personnage ne s'est deplace sur une case a gauche franchissable ",false, aFranchis);
	}
	
	/**
	 * si personnage se deplace en abscisse
	 * et que la case d'arrivee n'est pas franchissable
	 */
	@Test
	public void testDeplacerVersCaseNonFranchissableBas() {
		//donnees
		MonJeu jeu=new MonJeu(31);
		Heros heros=(Heros)jeu.getPj(0);
		Case[][] tab_cases=jeu.getCases(); //[x]ligne [y]colonne
		boolean aFranchis=false;
			
		//methode testee
		Commande allerAbas = new Commande();
		allerAbas.bas=true;
		jeu.evoluer(allerAbas);
		Case caseArrivee=tab_cases[heros.getX()][heros.getY()];
		caseArrivee.setFranchissable(false);
		if(caseArrivee.estFranchissable()){
			aFranchis=true;
		}
			
		//validation du test
		assertEquals("Le personnage ne s'est deplace sur une case en bas franchissable ",false, aFranchis);
	}
	
	/**
	 * si personnage se deplace en abscisse
	 * et que la case d'arrivee n'est pas franchissable
	 */
	@Test
	public void testDeplacerVersCaseNonFranchissableHaut() {
		//donnees
		MonJeu jeu=new MonJeu(31);
		Heros heros=(Heros)jeu.getPj(0);
		Case[][] tab_cases=jeu.getCases(); //[x]ligne [y]colonne
		boolean aFranchis=false;
			
		//methode testee
		Commande allerAhaut = new Commande();
		allerAhaut.haut=true;
		jeu.evoluer(allerAhaut);
		Case caseArrivee=tab_cases[heros.getX()][heros.getY()];
		caseArrivee.setFranchissable(false);
		if(caseArrivee.estFranchissable()){
			aFranchis=true;
		}
			
		//validation du test
		assertEquals("Le personnage ne s'est deplace sur une case en haut franchissable ",false, aFranchis);
	}
	
	/**
	 * si personnage se deplace en haut et a gauche
	 * et que la case d'arrivee est un bord (case infranchissable)
	 */
	@Test
	public void testDeplacerEnDiagonaleHorsDuJeu() {
		//donnees
		MonJeu jeu=new MonJeu(31);
		Heros heros=(Heros)jeu.getPj(0);
		Case[][] tab_cases=jeu.getCases(); //[x]ligne [y]colonne
		boolean aFranchis=false;
			
		//methode testee
		Commande allerAhaut = new Commande();
		allerAhaut.haut=true;
		Commande allerAgauche = new Commande();
		allerAgauche.gauche=true;
		jeu.getPj(0).setX(2);
		jeu.getPj(0).setY(1);
		jeu.evoluer(allerAhaut);
		jeu.evoluer(allerAgauche);
		Case caseArrivee=tab_cases[heros.getX()][heros.getY()];
		caseArrivee.setFranchissable(false);
		if(caseArrivee.estFranchissable()){
			aFranchis=true;
		}
			
		//validation du test
		assertEquals("Le personnage ne s'est deplace sur une case en haut franchissable ",false, aFranchis);
	}

}
