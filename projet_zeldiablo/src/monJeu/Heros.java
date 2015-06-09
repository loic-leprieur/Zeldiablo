package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Heros extends Personnage{
	
	private boolean possedeAmu;
	
	
	/**
	 * constructeur vide
	 */
	public Heros() {
		
		this.possedeAmu = false;
		
		if((MonJeu.TAILLE_PLATEAU - 1)%2 == 0) {
			this.setX((MonJeu.TAILLE_PLATEAU - 1) / 2);
			this.setY((MonJeu.TAILLE_PLATEAU - 1) / 2);
		} else {
			this.setX(((MonJeu.TAILLE_PLATEAU - 1 )/ 2) + 1);
			this.setY(((MonJeu.TAILLE_PLATEAU - 1) / 2) + 1);
		}
		
	}


	@Override
	/**
	 * Methode retournant les caracteristiques d'un heros
	 * 
	 * @return
	 * 			Chaine de caracteres decrivant le heros
	 */
	public String toString() {
		return ("Heros:x=" + getX() + ",y=" + getY());
	}



	@Override
	/**
	 * Methode permettant de dessiner un heros dans le labyrinthe
	 */
	public void dessinerObjet(BufferedImage im) {
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		
		crayon.setColor(Color.blue);
		crayon.fillOval(getX() * taille_c, getY() * taille_c, taille_c, taille_c);
		
	}


	/**
	 * @return the possedeAmu
	 */
	public boolean isPossedeAmu() {
		return possedeAmu;
	}


	/**
	 * @param possedeAmu the possedeAmu to set
	 */
	public void setPossedeAmu(boolean possedeAmu) {
		this.possedeAmu = possedeAmu;
	}

}
