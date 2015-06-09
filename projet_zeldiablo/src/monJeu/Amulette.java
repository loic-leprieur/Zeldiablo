package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Amulette extends Declencheur {
	
	private boolean estAffiche;
	
	public Amulette(int posX, int posY, boolean etat) {
		super(posX, posY, etat);
		estAffiche=true;
	}

	
	@Override
	public void declencherEffet(Personnage pers) {
		if(pers instanceof Heros){
			estAffiche=false;
			((Heros) pers).setPossedeAmu(true);
		}
		
	}

	@Override
	public String toString() {
		
		return("type:Amulette");
	 }
	
	@Override
	public void dessinerObjet(BufferedImage im){
		if(estAffiche){
			Graphics2D crayon = (Graphics2D) im.getGraphics();
			int taille_c = DessinMonJeu.TAILLE_CASE;
			crayon.setColor(Color.YELLOW);
			crayon.fillRect((x*taille_c)+5, (y*taille_c)+5, taille_c-10, taille_c-10);
		}
			
			
	}

}
