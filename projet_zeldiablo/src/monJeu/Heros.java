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
		
		
		if((MonJeu.TAILLE_PLATEAU - 1)%2 == 0) {
			this.x = (MonJeu.TAILLE_PLATEAU - 1) / 2;
			this.y = (MonJeu.TAILLE_PLATEAU - 1) / 2;
		} else {
			this.x = ((MonJeu.TAILLE_PLATEAU - 1 )/ 2) + 1;
			this.y = ((MonJeu.TAILLE_PLATEAU - 1) / 2) + 1;
		}
		
	}



	public String toString() {
		return ("Heros:x=" + x + ",y=" + y);
	}

}
