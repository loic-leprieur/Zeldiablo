package monJeu;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Heros extends Personnage{
	
	/**
	 * constructeur vide
	 */
	public Heros() {
		
		if(LIMIT_X%2 == 0) {
			this.x = LIMIT_X / 2;
		} else {
			this.x = (LIMIT_X / 2) + 1;
		}
		
		
		if(LIMIT_Y%2 == 0) {
			this.y = LIMIT_Y / 2;
		} else {
			this.y = (LIMIT_Y / 2) + 1;
		}
		
	}



	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

}
