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
		
		crayon.setColor(Color.RED);
		crayon.fillOval(x * taille_c, y * taille_c, taille_c, taille_c);

	}

}
