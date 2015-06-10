package monJeu;

import java.awt.image.BufferedImage;

import moteurJeu.Commande;


/**
 * Classe modelisant un monstre
 */
public abstract class Monstre extends Personnage {

	
	/**
	 * Constructeur d'un monstre
	 */
	public Monstre(){
		
		this.pv = 50;
		this.setX(3);  
		this.setY(3);
	
		
	}
	
	
	@Override
	/**
	 * Methode retournant les caracteristiques d'un monstre
	 * 
	 * @return
	 * 			Chaine de caracteres decrivant le monstre
	 */
	public String toString() {
		
		return ("Monstre:x=" + getX() + ",y=" + getY());
	}
	

	@Override
	/**
	 * Methode permettant de dessiner un monstre dans le labyrinthe
	 */
	public abstract void dessinerObjet(BufferedImage im);	

}
