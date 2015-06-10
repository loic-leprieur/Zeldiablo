package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Piege extends Declencheur {
	
	
	private boolean estActive;
	
	

	public Piege(int posX, int posY, boolean etat) {
		super(posX, posY, etat);
		estActive = false;
	}

	
	
	
		
	@Override
	public void declencherEffet(Personnage pers){
					
		pers.setPv(pers.getPv() - 10);
		estActive = true;
		
		};
		
		

		public void dessinerObjet(BufferedImage im){
			
			if(estActive){
			
			Graphics2D crayon = (Graphics2D) im.getGraphics();
			int taille_c = DessinMonJeu.TAILLE_CASE;
			
				
			crayon.setColor(Color.ORANGE);
			crayon.fillRect(this.x * taille_c, this.y *  taille_c, taille_c, taille_c);
				
			}
			}
}
