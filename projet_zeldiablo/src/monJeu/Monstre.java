package monJeu;

import moteurJeu.Commande;

public class Monstre extends Personnage {

	
	public Monstre(){
		
		this.x = 3;
		this.y = 3;
	
		
	}
	
	
	

	@Override
	public String toString() {
		
		return ("Monstre:x=" + x + ",y=" + y);
	}
	

		

}
