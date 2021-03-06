package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import sun.applet.Main;
import moteurJeu.Commande;
import moteurJeu.Jeu;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class MonJeu implements Jeu {

	/**
	 * le personnage du jeu
	 */
	private ArrayList<Personnage> pj;
	private Case[][] tab_cases;
	public static int TAILLE_PLATEAU = 0;

	/**
	 * constructeur de jeu avec un Personnage et un labyrinthe comportant
	 * uniquement des cases non traversables
	 */

	public MonJeu(int taille) {

		TAILLE_PLATEAU = taille;
		this.pj = new ArrayList<Personnage>();
		tab_cases = new Case[taille][taille];
		FileReader fis;
		
		try {
			InputStream test = Main.class.getResourceAsStream("/Labyrinthe.txt");
			InputStreamReader stream = new InputStreamReader(test);
			//fis = new FileReader("/Labyrinthe.txt");
			BufferedReader br = new BufferedReader(stream);
			
			for(int i = 0; i < taille; i++){
				
				String ligne = br.readLine();
				String[] tab_ligne = ligne.split(" ");
				
				for(int j = 0; j < tab_ligne.length; j++) {
					
					switch(tab_ligne[j]){
					
					case "X":
						tab_cases[j][i] = new Case(j,i,false);
						break;
						
					case "-":
						tab_cases[j][i] = new Case(j,i,true);
						break;
						
					case "H":
						pj.add(new Heros(j,i));
						tab_cases[j][i] = new Case(j,i,true);
						break;
						
					case "O":
						pj.add(new Orc(j,i));
						tab_cases[j][i] = new Case(j,i,true);
						break;
						
					case "F":
						pj.add(new Fantome(j,i));
						tab_cases[j][i] = new Case(j,i,true);
						break;
					
					
					
					}
					
				}
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int nb_pieges = 0;

		while (nb_pieges < 5) {

			int x = (int) (Math.random() * 30);
			int y = (int) (Math.random() * 30);
			Heros h = (Heros) pj.get(0);

			int distance_h = (int) Math.sqrt(Math.pow(x - h.getX(), 2)
					+ Math.pow(y - h.getY(), 2));

			if (tab_cases[x][y].estFranchissable() && distance_h > 5) {

				tab_cases[x][y] = new Piege(x, y, true);
				nb_pieges++;

			}

		}

		tab_cases[29][29] = new Amulette(29, 29, true);
		tab_cases[29][1] = new Porte(29, 1, true);

		for (int k = 0; k < pj.size(); k++) {
			Personnage perso = pj.get(k);
			tab_cases[perso.getX()][perso.getY()].setOccupee(true);

		}

	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		String res = " ";
		for (int i = 0; i < pj.size(); i++)
			res += ("" + (pj.get(i).toString()));
		return res;
	}

	/**
	 * demande a deplacer le personnage
	 * 
	 * @param commande
	 *            chaine qui donne ordre
	 */
	public void evoluer(Commande cde) {
		int update = 0;

		// on prend les coordonnees actuelles du personnage
		for (int i = 0; i < pj.size(); i++) {
			int posX = pj.get(i).getX();
			int posY = pj.get(i).getY();

			if (pj.get(i) instanceof Monstre && pj.get(i).estMort()) {
				tab_cases[posX][posY].setOccupee(false);
				pj.remove(i);
				
			} else {
								// pour le choix aleatoire de direction
				int choix;
				// pour la commande a effectuer selon si heros ou monstre
				Commande commande;
				if (pj.get(i) instanceof Heros) {
					commande = cde;
				} else {
					Heros h = (Heros) pj.get(0);
					Monstre m = (Monstre) pj.get(i);
					commande = new Commande();

					// Verifie si le heros est a cote pour le taper
					if (-1 <= m.getX() - h.getX() && 1 >= m.getX() - h.getX()
							&& -1 <= m.getY() - h.getY()
							&& 1 >= m.getY() - h.getY()) {
						commande.attaque = true;

					} else {
						// test si le mosntre est proche du heros
						if (-6 <= pj.get(i).getX() - pj.get(0).getX()
								&& 6 >= pj.get(i).getX() - pj.get(0).getX()
								&& -6 <= pj.get(i).getY() - pj.get(0).getY()
								&& 6 >= pj.get(i).getY() - pj.get(0).getY()) {

							if (h.getX() > m.getX()) {

								commande.droite = true;

								if (h.getY() < m.getY()) {

									commande.haut = true;

								} else {

									commande.bas = true;

								}

							} else {

								commande.gauche = true;

								if (h.getY() < m.getY()) {

									commande.haut = true;

								} else {

									commande.bas = true;

								}

							}

						} else {
							// le monstre est �loign� donc il choisit une
							// direction au hasard
							commande = new Commande();
							choix = pj.get(i).choixAleatoire();
							switch (choix) {
							case 0:

								commande.haut = true;

								break;
							case 1:
								commande.bas = true;
								break;
							case 2:
								commande.gauche = true;
								break;
							case 3:
								commande.droite = true;
								break;
							default:

							}
						}
					}
				}
				/*
				 * verifie que la case de destination de personnage est
				 * franchissable sinon le deplacement ne se fait pas si la case
				 * d'arrivee est occupee, le personnage retourne a sa position
				 * initiale sinon il se deplace sur la case qui devient occupee
				 */
				if (commande.attaque) {
					if (pj.get(i) instanceof Heros) {
						for(int j=1;j<pj.size();j++){
							if(-1<=pj.get(j).getX()-pj.get(i).getX() && 1>=pj.get(j).getX()-pj.get(i).getX() && -1<=pj.get(j).getY()-pj.get(i).getY() && 1>=pj.get(j).getY()-pj.get(i).getY()){
								pj.get(i).attaque(pj.get(j));
							}
						}

					}else{
						pj.get(i).attaque(pj.get(0));
					}
				} else {
					if (commande.haut) {
						if (posY - 1 >= 0 && posY - 1 < TAILLE_PLATEAU) {
							if (this.getPj(i).verifierCase(
									tab_cases[posX][posY - 1])
									&& !tab_cases[posX][posY - 1].estOccupee()) {
								this.getPj(i).deplacer(commande);

							}
						}
					}
					if (commande.bas) {
						if (posY + 1 >= 0 && posY + 1 < TAILLE_PLATEAU) {
							if (this.getPj(i).verifierCase(
									tab_cases[posX][posY + 1])
									&& !tab_cases[posX][posY + 1].estOccupee()) {
								this.getPj(i).deplacer(commande);

							}
						}
					}
					if (commande.gauche) {
						if (posX - 1 >= 0 && posX - 1 < TAILLE_PLATEAU) {
							if (this.getPj(i).verifierCase(
									tab_cases[posX - 1][posY])
									&& !tab_cases[posX - 1][posY].estOccupee()) {
								this.getPj(i).deplacer(commande);

							}
						}
					}
					if (commande.droite) {
						if (posX + 1 >= 0 && posX + 1 < TAILLE_PLATEAU) {
							if (this.getPj(i).verifierCase(
									tab_cases[posX + 1][posY])
									&& !tab_cases[posX + 1][posY].estOccupee()) {
								this.getPj(i).deplacer(commande);

							}
						}
					}
				}
				// test gestion de l'appui sur deux touches a la fois
				if (pj.get(i).getX() >= 0 && pj.get(i).getX() < TAILLE_PLATEAU
						&& pj.get(i).getY() >= 0
						&& pj.get(i).getY() < TAILLE_PLATEAU) {
					if (!(this.getPj(i)
							.verifierCase(tab_cases[pj.get(i).getX()][pj.get(i)
									.getY()]))
							|| tab_cases[pj.get(i).getX()][pj.get(i).getY()]
									.estOccupee()) {

						pj.get(i).setX(posX);
						pj.get(i).setY(posY);

					} else {
						tab_cases[pj.get(i).getX()][pj.get(i).getY()]
								.setOccupee(true);
						tab_cases[posX][posY].setOccupee(false);

					}
				} else {
					pj.get(i).setX(posX);
					pj.get(i).setY(posY);
				}

				update++;
			}

			if (tab_cases[pj.get(0).getX()][pj.get(0).getY()] instanceof Declencheur) {

				Declencheur dec = (Declencheur) tab_cases[pj.get(0).getX()][pj
						.get(0).getY()];

				dec.declencherEffet(pj.get(0));

			}
		}
	}

	@Override
	/**
	 * Methode permettant de dire que le jeu n'est jamais fini
	 */
	public boolean etreFini() {
		// le jeu n'est jamais fini

		if (pj.get(0).estMort()) {
			
			JOptionPane.showMessageDialog(null, "Vous etes mort !", "Mort", JOptionPane.INFORMATION_MESSAGE);

			return true;
		}

		return false;
	}

	/**
	 * Methode permettant de dessiner l'ensemble des objets du labyrinthe
	 * 
	 * @param im
	 *            BufferedImage
	 */
	public void dessinerObjet(BufferedImage im) {

		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;

		for (int i = 0; i < tab_cases.length; i++) {

			for (int j = 0; j < tab_cases.length; j++) {

				tab_cases[i][j].dessinerObjet(im);

			}
		}

		for (int i = 0; i < pj.size(); i++) {

			pj.get(i).dessinerObjet(im);
		}

	}

	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	public Personnage getPj(int i) {
		if (i >= pj.size() || i < 0)
			return null;
		else
			return pj.get(i);
	}

	public Case[][] getCases() {

		return this.tab_cases;

	}

}
