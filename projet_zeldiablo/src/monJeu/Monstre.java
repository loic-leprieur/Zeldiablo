package monJeu;

import moteurJeu.Commande;

public class Monstre extends Personnage {

	
	public Monstre(){
		
		this.x = 1;
		this.y = 1;
	
		
	}
	
	
	

	@Override
	public String toString() {
		
		return ("Monstre:x=" + x + ",y=" + y);
	}
	

		

}
