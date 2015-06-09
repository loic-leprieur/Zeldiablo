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
		
		this.x = 3;
		this.y = 3;
	
		
	}
	
	
	@Override
	/**
	 * Methode retournant les caracteristiques d'un monstre
	 * 
	 * @return
	 * 			Chaine de caracteres decrivant le monstre
	 */
	public String toString() {
		
		return ("Monstre:x=" + x + ",y=" + y);
	}
	

	@Override
	/**
	 * Methode permettant de dessiner un monstre dans le labyrinthe
	 */
	public abstract void dessinerObjet(BufferedImage im);	

}
