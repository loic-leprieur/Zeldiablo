package monJeu;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Heros {

	/**
	 * position en X et y
	 */
	public int x;
	public int y;

	/**
	 * taille de l'environnement
	 */
	final static int LIMIT_X = 10;
	final static int LIMIT_Y = 10;

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

	/**
	 * deplacer le personnage dans une direction
	 * 
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 */
	public void deplacer(Commande c) {
		
		if (c.gauche)
		{
			this.x--;
			if (this.x < 0)
				this.x = 0;
		}

		if (c.droite)
		{
			this.x++;
			if (this.x >LIMIT_X)
				this.x = LIMIT_X;
		}
		
		if(c.haut)
		{
			this.y--;
			if (this.y < 0){
				this.y = 0;				
			}
		}
		
		if(c.bas)
		{
			this.y++;
			if (this.y > LIMIT_Y)
			{
				this.y = LIMIT_Y;				
			}
		}
	}

	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

}
