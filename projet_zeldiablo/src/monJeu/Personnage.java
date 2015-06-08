package monJeu;
import moteurJeu.*;

public abstract class Personnage {
	/**
	 * position en X et y
	 */
	public int x;
	public int y;

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
			if (this.x >MonJeu.TAILLE_PLATEAU - 1)
				this.x = MonJeu.TAILLE_PLATEAU - 1;
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
			if (this.y > MonJeu.TAILLE_PLATEAU - 1)
			{
				this.y = MonJeu.TAILLE_PLATEAU - 1;				
			}
		}
	}
	
	
	public int choixAleatoire(){
		
		return (int) (Math.random()*4);
		
	}
	
	public abstract String toString();
	
}
