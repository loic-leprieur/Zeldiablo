package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

/**
 * un afficheur graphique associe au JeuTest fourni
 * 
 * @author vthomas
 */
public class DessinMonJeu implements DessinJeu {

	/**
	 * constante pour gerer la taille des cases
	 */
	public static int TAILLE_CASE = 25;

	/**
	 * lien vers le jeu a afficher
	 */
	private MonJeu jeu;

	/**
	 * appelle constructeur parent
	 * 
	 * @param j
	 *            le jeutest a afficher
	 */
	public DessinMonJeu(MonJeu j) {
		this.jeu = j;
	}

	
	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		
		jeu.dessinerObjet(im);
	}

}
