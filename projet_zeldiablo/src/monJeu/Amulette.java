package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Amulette extends Objet {


	/**
	 * Attribut representant le heros qui porte l'amulette ou non
	 */
	
	private Heros porteur;
	
	
	/**
	 * 
	 * Constructeur qui instancie une amulette au coordones spécifiees
	 * 
	 * @param abs
	 * 
	 * 			Abscisse de l'amulette
	 * 
	 * @param ord
	 * 
	 * 			Ordonne de l'amulette
	 */
	
	public Amulette(int abs, int ord) {
		super(abs, ord);
		this.porteur = null;
	}

	
	/**
	 * 
	 * Methode qui permet de dessiner une amulette si elle n'est pas porte
	 * 
	 * @param im
	 * 
	 * 			Image dans laquelle on dessine l'amulette
	 * 
	 */
	
	
	@Override
	public void dessinerObjet(BufferedImage im) {
		
		int x_amu = 1;
		int y_amu = 1;
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		crayon.setColor(Color.YELLOW);
		
		
		
		if(this.porteur == null){
		
			x_amu = (getX()* taille_c) + 5;
			y_amu = (getY() * taille_c) + 5;
			
		}else{
			
			x_amu = (porteur.getX()* taille_c) + 5;
			y_amu = (porteur.getY() * taille_c) + 5;
		}
	
		
		
		crayon.fillRect(x_amu, y_amu  , (taille_c - 10), (taille_c - 10));
		
		

	}

	
	/**
	 * 
	 * Getter de l'attribut porteur
	 * 
	 * @return
	 * 
	 * 			Retourne le Heros portant l'objet (null si pas de porteur)
	 */
	
	public Heros getHeros(){
		
		return this.porteur;
		
	}
	
	/**
	 * 
	 * Setter de l'attribut porteur
	 * 
	 * @param pers
	 * 
	 * 				Nouvel heros portant l'amulette
	 */
	
	
	public void setHeros(Heros pers){
		
		this.porteur = pers;
		
	}
	
	/**
	 * 
	 * Mehode toString qui permet de renvoyer une chaine decrivant l'amulette
	 * 
	 * @return 
	 * 
	 * 		Chaine decrivant l'amulette
	 * 
	 */
	
	@Override
	public String toString() {
		return "Amulette:x=" + getX() + "y=" + getY() +"porteur=" + porteur;
	}

}
