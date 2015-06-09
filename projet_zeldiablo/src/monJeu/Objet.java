package monJeu;

import java.awt.image.BufferedImage;

/**
 * classe definissant 
 * les items dans un Monjeu
 * @author Loïc
 *
 */
public abstract class Objet {
	private int x;
	private int y;
	
	/**
	 * construteur par defaut
	 * @param abs - abscisse de l'objet
	 * @param ord - ordonnee de l'objet
	 */
	public Objet(int abs, int ord){
		x=abs;
		y=ord;
	}
	
	/**
	 * methode abstrait dessinant
	 * l'objet dans le MonJeu
	 * @param im
	 */
	public abstract void dessinerObjet(BufferedImage im);
	
	/**
	 * getteur de l'abscisse
	 * de l'objet
	 * @return abscisse
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * setteur de l'objet
	 * @param x - nouvelle abscisse
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * getteur de l'ordonnee
	 * de l'objet
	 * @return ordonnee
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * setteur de l'objet
	 * @param y - nouvelle ordonnee
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * methode abstraite
	 * affichant les infos de l'objet
	 */
	public abstract String toString();
	
	
	
}
