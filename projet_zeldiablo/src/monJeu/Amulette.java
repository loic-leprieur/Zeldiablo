package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Amulette extends Objet {


	private Heros porteur;
	
	
	public Amulette(int abs, int ord) {
		super(abs, ord);
		this.porteur = null;
	}

	@Override
	public void dessinerObjet(BufferedImage im) {
		
		if(this.porteur == null){
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		
		crayon.setColor(Color.YELLOW);
		crayon.fillRect(getX() + 5, getY() + 5, (taille_c - 5), (taille_c - 5));
		
		}

	}

	@Override
	public String toString() {
		return "Amulette:x=" + getX() + "y=" + getY() +"porteur=" + porteur;
	}

}
