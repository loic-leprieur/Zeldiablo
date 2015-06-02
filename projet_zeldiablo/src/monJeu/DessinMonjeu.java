package monJeu;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import monJeuExemple.MonJeu;
import monJeuExemple.Personnage;
import moteurJeu.DessinJeu;


public class DessinMonjeu implements DessinJeu {
	/**
	 * constante pour gerer la taille des cases
	 */
	private static int TAILLE_CASE = 25;

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
	public DessinMonjeu(MonJeu j) {
		this.jeu = j;
	}

	/**
	 * dessiner un objet consiste a dessiner sur l'image suivante methode
	 * redefinie de Afficheur
	 */
	private void dessinerObjet(String s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		switch (s) {
		case "PJ":
			crayon.setColor(Color.blue);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "MUR":
			crayon.setColor(Color.gray);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		default:
			throw new AssertionError("objet inexistant");
		}
	}
	
	public void DessinMonJeu(MonJeu j) {
		this.jeu = j;
	}
	
	@Override
	public void dessiner(BufferedImage image) {
		// no sait que c'est un jeuTest
		MonJeu j = (MonJeu) jeu;
		Personnage pj = j.getPj();
		this.dessinerObjet("PJ", pj.x, pj.y, image);
		
	}

}
