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

	/**
	 * lorsque un heros active une case amulette
	 * il la possede et elle ne s'affiche plus
	 */
	@Override
	public void declencherEffet(Personnage pers) {
		if(pers instanceof Heros){
			estAffiche=false;
			((Heros) pers).setPossedeAmu(true);
		}
		
	}
	
	/**
	 * affichage du type de 
	 * la classe
	 */
	@Override
	public String toString() {
		
		return("type:Amulette");
	 }
	
	/**
	 * dessin specifique a amulette
	 * qui n'est dessinee que lorsqu'elle
	 * est affichee
	 */
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
