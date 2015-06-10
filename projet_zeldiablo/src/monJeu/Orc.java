package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 * Classe modelisant un orc
 */
public class Orc extends Monstre {
	
	
	/**
	 * Constructeur d'un orc
	 */
	public Orc() {
		super();
	}

	
	@Override
	/**
	 * Methode permettant de dessiner l'orc
	 * 
	 * @param im
	 * 			BufferedImage
	 */
	public void dessinerObjet(BufferedImage im) {
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		
		if(attaque) {
			crayon.setColor(Color.RED);
		} else {
			crayon.setColor(Color.BLACK);
		}
		
		crayon.fillOval(getX() * taille_c, getY() * taille_c, taille_c, taille_c);
		
		crayon.setColor(Color.BLACK);
		crayon.drawRect(getX() * taille_c, (getY() * taille_c) - 10, taille_c ,10 );
		
		
		crayon.setColor(Color.GREEN);
		crayon.fillRect((getX() * taille_c )+ 1, (getY() * taille_c) - 9, (int) (pv * 0.49) ,9 );

	}

}
