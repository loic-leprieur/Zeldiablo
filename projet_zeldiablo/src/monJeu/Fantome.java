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
		setX(MonJeu.TAILLE_PLATEAU-3);
		setY(3);
	}

	
	@Override
	/**
	 * Methode permettant de dessiner un fantome dans le labyrinthe
	 */
	public void dessinerObjet(BufferedImage im) {
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		
		if(attaque) {
			crayon.setColor(Color.BLACK);
		} else {
			crayon.setColor(Color.GREEN);
		}
		
		crayon.fillOval(getX() * taille_c, getY() * taille_c, taille_c, taille_c);
		
		crayon.setColor(Color.BLACK);
		crayon.drawRect(getX() * taille_c, (getY() * taille_c) - 10, taille_c ,10 );
		
		
		crayon.setColor(Color.GREEN);
		crayon.fillRect((getX() * taille_c )+ 1, (getY() * taille_c) - 9, (int) (pv * 0.49) ,9 );

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
