package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

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
		this.pj=new ArrayList<Personnage>();
		pj.add(new Heros());
		pj.add(new Orc());
		pj.add(new Orc());
		tab_cases = new Case[taille][taille];
		
		
		for(int i = 0; i < taille; i++){
			
			for(int j = 0; j < taille; j++){
				
				//Condition pour un premier exemple d'affichage des cases
				if(((i%2 == 0) && (j%2 == 0)) ||  (i == 0) || (i == tab_cases.length-1) || (j == 0) || (j == tab_cases[i].length-1)) {
				
					tab_cases[i][j] = new Case(false);
				
				} else {
				
					tab_cases[i][j] = new Case(true);
					
				}
					
			}

		}
		
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		String res=" ";
		for(int i=0;i<pj.size();i++)
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
		//on prend les coordonnees actuelles du personnage
		for(int i=0;i<pj.size();i++){
			int posX = pj.get(i).x;
			int posY = pj.get(i).y;
			//pour le choix aleatoire de direction
			int choix;
			//pour la commande a effectuer selon si heros ou monstre
			Commande commande;	
			if(pj.get(i)instanceof Heros){
				commande=cde;
			}else{
				commande = new Commande();
				choix = pj.get(i).choixAleatoire();
				switch(choix){
				case 0:
					commande.haut=true;
					break;
				case 1:
					commande.bas=true;
					break;
				case 2:
					commande.gauche=true;
					break;
				case 3:
					commande.droite=true;
					break;
				default:
					
				}
			}
			//verifie que la case de destination de personnage est franchissable sinon le deplacement ne se fait pas
			/* si la case d'arrivee est occupee, le personnage retourne a sa position initiale
			 * sinon il se deplace sur la case qui devient occupee*/
			if(commande.haut){
				if(tab_cases[posX][posY-1].estFranchissable() && !tab_cases[posX][posY-1].estOccupee()){
					this.getPj(i).deplacer(commande);
					

				}
			}
			if(commande.bas){
				if(tab_cases[posX][posY+1].estFranchissable() && !tab_cases[posX][posY+1].estOccupee()){
					this.getPj(i).deplacer(commande);
					
				}
			}
			if(commande.gauche){
				if(tab_cases[posX-1][posY].estFranchissable() && !tab_cases[posX-1][posY].estOccupee()){
					this.getPj(i).deplacer(commande);
					

				}
			}
			if(commande.droite){
				if(tab_cases[posX+1][posY].estFranchissable() && !tab_cases[posX+1][posY].estOccupee()){
					this.getPj(i).deplacer(commande);
					
				}
			}
			//test gestion de l'appui sur deux touches a la fois
			
			if(!(tab_cases[pj.get(i).x][pj.get(i).y].estFranchissable()) || tab_cases[pj.get(i).x][pj.get(i).y].estOccupee()){
				
				pj.get(i).x=posX;
				pj.get(i).y=posY;
				
			}else{
				tab_cases[pj.get(i).x][pj.get(i).y].setOccupee(true);
				tab_cases[posX][posY].setOccupee(false);

			}
		}
	}
	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}
	
	public void dessinerObjet(BufferedImage im){
		
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		
		for (int i = 0; i < tab_cases.length; i++) {

			for (int j = 0; j < tab_cases.length; j++) {

				if (!(tab_cases[i][j].estFranchissable())) {

					
					crayon.setColor(Color.gray);
					crayon.fillRect(i * taille_c, j *  taille_c, taille_c, taille_c);
				}
		
		
			}
		}
		
		
		for(int i = 0; i < pj.size(); i++){
			
			
			pj.get(i).dessinerObjet(im);			
			
		}
		
		
		
		
	}

	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	public Personnage getPj(int i) {
		if(i>=pj.size() || i<0)
			return null;
		else
			return pj.get(i);
	}

	public Case[][] getCases(){
		
		return this.tab_cases;
		
	}
	
	
}
