package tests;

import static org.junit.Assert.*;
import monJeu.*;
import moteurJeu.*;

import org.junit.*;

public class TestAmulette {

	@Test
	public void testCoordonneesInitialeAmulette(){
		//preparation des donnees
		MonJeu mj = new MonJeu(31);
		
		//methode testee
		Case[][] tab_cas = mj.getCases();
		
		//validation des donnees
		assertEquals("Doit retourner la coordonnee x initiale 29 de l'amulette",true, tab_cas[29][29] instanceof Amulette);
	
	}

	
	@Test
	public void testAmulettePriseHeros(){
		//preparation des donnees
		MonJeu mj = new MonJeu(31);
		Heros h = (Heros) mj.getPj(0);
		Commande cmd = new Commande();
		
		
		h.setX(29);
		h.setY(29);		
		mj.evoluer(cmd);
		
		
		h.setX(15);
		h.setY(15);		
		mj.evoluer(cmd);
		
		//methode testee
		boolean test = h.isPossedeAmu();
		
		
		//validation des tests
		assertEquals("Doit retourner vrai si le heros a saisi l'amulette",true,test);
	
	}
	

	
	
}
