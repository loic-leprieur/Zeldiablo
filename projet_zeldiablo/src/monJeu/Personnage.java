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
	final static int LIMIT_X = 10;
	final static int LIMIT_Y = 10;

	public abstract void deplacer(Commande commande);
	public abstract String toString();
	
}
