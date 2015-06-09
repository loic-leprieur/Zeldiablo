package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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


	@Override
	/**
	 * Methode retournant les caracteristiques d'un heros
	 * 
	 * @return
	 * 			Chaine de caracteres decrivant le heros
	 */
	public String toString() {
		return ("Heros:x=" + x + ",y=" + y);
	}



	@Override
	/**
	 * Methode permettant de dessiner un heros dans le labyrinthe
	 */
	public void dessinerObjet(BufferedImage im) {
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		
		crayon.setColor(Color.blue);
		crayon.fillOval(x * taille_c, y * taille_c, taille_c, taille_c);
		
	}

}
