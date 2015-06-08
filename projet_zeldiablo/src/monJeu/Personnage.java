package monJeu;
import moteurJeu.*;

public abstract class Personnage {
	/**
	 * position en X et y
	 */
	public int x;
	public int y;

	/**
	 * taille de l'environnement
	 */
	final static int LIMIT_X = MonJeu.TAILLE_PLATEAU - 1;
	final static int LIMIT_Y = MonJeu.TAILLE_PLATEAU - 1;

	/**
	 * deplacer le personnage dans une direction
	 * 
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 *            
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
	public abstract String toString();
	
}
