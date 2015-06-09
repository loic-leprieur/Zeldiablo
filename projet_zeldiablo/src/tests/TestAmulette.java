package tests;

import static org.junit.Assert.*;
import monJeu.*;
import moteurJeu.*;

import org.junit.*;

public class TestAmulette {

	@Test
	public void testCoordonnéesInitialeAmulette(){
		//preparation des donnees
		MonJeu mj = new MonJeu(31);
		Amulette amu = (Amulette) mj.getObjet(0);
		
		//methode testee
		int x= amu.getX();
		int y= amu.getY();
		//validation des donnees
		assertEquals("Doit retourner la coordonnée x initiale 29 de l'amulette",29,x);
		assertEquals("Doit retourner la coordonnée y initiale 29 de l'amulette",29,y);
	}
	
	@Test
	public void testHerosNullAmuletteInitiale(){
		//preparation des donnees
		MonJeu mj = new MonJeu(31);
		Amulette amu = (Amulette) mj.getObjet(0);
		
		//methode testee
		Heros link = amu.getHeros();
		//validation des donnees
		assertEquals("Doit retourner la valeur null",null,link);
	}
	
	@Test
	public void testAmulettePriseHeros(){
		//preparation des donnees
		MonJeu mj = new MonJeu(31);
		Amulette amu = (Amulette) mj.getObjet(0);
		Commande coDroite = new Commande();
		coDroite.droite=true;
		Commande coBas = new Commande();
		coBas.bas=true;
		int posX = mj.getPj(0).getX();
		int posY = mj.getPj(0).getY();
		//methode testee
		while(posX != 29){
			mj.evoluer(coDroite);
			posX= mj.getPj(0).getX();
		}
		while(posY != 29){
			mj.evoluer(coBas);
			posY = mj.getPj(0).getY();
		}
		
		Heros link = amu.getHeros();
		boolean test=(link == mj.getPj(0));
			
		//validation des donnees
		assertEquals("Doit retourner vrai si le heros a saisi l'amulette",true,test);
	
	}
	
	@Test
	public void testDeplacementHeros(){
		//preparation des donnees
		MonJeu mj = new MonJeu(31);
		Amulette amu = (Amulette) mj.getObjet(0);
		Commande coHaut = new Commande();
		coHaut.haut=true;
		Heros link =(Heros) mj.getPj(0);
		//methode testee
		amu.setHeros(link);
		amu.setX(link.getX());
		amu.setY(link.getY());
		mj.evoluer(coHaut);
		boolean test = (link.getX()==amu.getHeros().getX() && link.getY()==amu.getHeros().getY());
		//validation des donnees
		
		assertEquals("Les coordonnées de l'amulette doivent être les même que celle de son porteur",true,test);
	}
	
	
}
