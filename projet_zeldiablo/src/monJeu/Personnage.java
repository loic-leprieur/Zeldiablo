package monJeu;
import java.awt.image.BufferedImage;

import moteurJeu.*;


/**
 * Classe modelisant un personnage
 * 
 */
public abstract class Personnage {
	/**
	 * position en X et y
	 */
	private int x;
	private int y;

	/**
	 * deplacer le personnage dans une direction
	 * 
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 *            
	 */
	public void deplacer(Commande c) {
		
		if (c.gauche)
		{
			this.x--;
			if (this.x < 0)
				this.x = 0;
		}

		if (c.droite)
		{
			this.x++;
			if (this.x >MonJeu.TAILLE_PLATEAU - 1)
				this.x = MonJeu.TAILLE_PLATEAU - 1;
		}
		
		if(c.haut)
		{
			this.y--;
			if (this.y < 0){
				this.y = 0;				
			}
		}
		
		if(c.bas)
		{
			this.y++;
			if (this.y > MonJeu.TAILLE_PLATEAU - 1)
			{
				this.y = MonJeu.TAILLE_PLATEAU - 1;				
			}
		}
	}
	
	
	/**
	 * Methode permettant de recuperer un entier aleatoire compris entre 0 et 4
	 * (utilisee pours les deplacements)
	 * 
	 * @return
	 * 			Nombre aleatoire entre 0 et 4
	 */
	public int choixAleatoire(){
		
		return (int) (Math.random()*4);
		
	}
	
	public boolean verifierCase(Case c){
		if(c.estFranchissable() && !(c.estOccupee()) ){
			return true;
		}else{
			return false;
		}
		
		
	}
	
	/**
	 * 
	 * Getter de l'atribut x du personnage
	 * 
	 * @return 
	 * 
	 * 			coordonné x du personnage
	 */
	
	public int getX() {
		return x;
	}


	/**
	 * Setter de l'atribut x du personnage
	 * 
	 * @param x 
	 * 
	 * 			nouvelle coordoné en x du personnage
	 */
	
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * 
	 * Getter de l'atribut y du personnage
	 * 
	 * @return 
	 * 			coordonné y du personnage
	 */
	public int getY() {
		return y;
	}


	/**
	 * 
	 * Setter de l'atribut x du personnage
	 * 
	 * @param y
	 * 
	 *			 nouvelle coordoné en x du personnage
	 */
	
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * Methode retournant les caracteristiques d'un personnage
	 */
	public abstract String toString();

	
	/**
	 * Methode permettant de dessiner un personnage dans le labyrinthe
	 */
	public abstract void dessinerObjet(BufferedImage im);
}
