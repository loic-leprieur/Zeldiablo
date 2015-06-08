package tests;

import static org.junit.Assert.*;
import monJeu.Case;
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
		MonJeu jeu=new MonJeu(MonJeu.TAILLE_PLATEAU);
		Monstre mob=(Monstre) jeu.getPj();
		Boolean aEteCree=false;
		
		//methode testee
				
		if(mob.x==1 && mob.y==1){
			aEteCree=true;
		}
		
		//valide le test
		assertEquals("Le monstre a ete cree sur la case vide",true, aEteCree);
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonstresCreesSurCasesVides() {
		//donnees
		MonJeu jeu=new MonJeu(MonJeu.TAILLE_PLATEAU);
		Monstre mob=(Monstre) jeu.getPj();
		Boolean aEteCree=false;
		Case[][] cases=jeu.getCases();	
		Case caseLibre=new Case(true);
		
		int j=0;
		int i=0;
		
		//methode testee
		while(i<cases.length){
			if(cases[i][j].estFranchissable()){
				caseLibre=cases[i][j];
				i++;
			}
			j++;
		}
		
		if(mob.x==i && mob.y==j){
			aEteCree=true;
		}
				
		//valide le test
		assertEquals("Le monstre a ete cree sur la case vide",true, aEteCree);
	}
	
	/**
	 * 
	 */
	@Test
	public void testMonstresNonCreesSurCasesNonVides() {
		//donnees
		MonJeu jeu=new MonJeu(MonJeu.TAILLE_PLATEAU);
		Monstre mob=(Monstre) jeu.getPj();
		Boolean aEteCree=false;
		Case[][] cases=jeu.getCases();	
		Case caseOccupe=new Case(true);
				
		int j=0;
		int i=0;
				
		//methode testee
		while(i<cases.length){
			if(!cases[i][j].estFranchissable()){
				caseOccupe=cases[i][j];
				i++;
			}
			j++;
		}
				
		if(mob.x==i && mob.y==j){
			aEteCree=true;
		}
						
		//valide le test
		assertEquals("Le monstre n'a pas ete cree sur la case non vide",false, aEteCree);
				
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
