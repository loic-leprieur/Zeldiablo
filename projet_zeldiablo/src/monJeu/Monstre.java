package monJeu;

import moteurJeu.Commande;

public class Monstre extends Personnage {

	
	public void Monstre(){
		
		this.x = 1;
		this.y = 1;
		
		
	}
	
	
	

	@Override
	public String toString() {
		
		return ("Monstre:x=" + x + ",y=" + y);
	}
	
	
	public int choixAleatoire(){
		
		return (int) (Math.random()*3);
		
	}
		

}
