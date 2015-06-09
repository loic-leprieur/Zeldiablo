package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 * Classe modelisant un fantome
 */
public class Fantome extends Monstre {

	
	/**
	 * Constructeur d'un fantome
	 */
	public Fantome() {
		super();
	}

	
	@Override
	/**
	 * Methode permettant de dessiner un fantome dans le labyrinthe
	 */
	public void dessinerObjet(BufferedImage im) {
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		
		crayon.setColor(Color.green);
		crayon.fillOval(x * taille_c, y * taille_c, taille_c, taille_c);

	}
	
	
	@Override
	/**
	 * Methode permettant de verifier que le fantome puisse se trouver sur une case
	 * 
	 * @param c
	 * 			Case a tester
	 * 
	 * @return
	 * 			Boleen indiquant si la fantome peut se deplacer sur cette case
	 */
	public boolean verifierCase(Case c){
		
		return (!c.estOccupee());
		
	}

}