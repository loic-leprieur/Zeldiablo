package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

public class Porte extends Declencheur{

	public Porte(int posX, int posY, boolean etat) {
		super(posX, posY, etat);
	}

	@Override
	public void declencherEffet(Personnage pers) {
		if(((Heros)pers).isPossedeAmu()){
			
			JOptionPane.showMessageDialog(null, "Vous avez gagne !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
			
			System.exit(0);
		}
	}

	@Override
	public String toString() {
		return "Type:Porte";
	}

	@Override
	public void dessinerObjet(BufferedImage im){
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		crayon.setColor(Color.BLACK);
		crayon.fillRect((x*taille_c)+5, (y*taille_c)+5, taille_c-10, taille_c-10);
	}
	
}
