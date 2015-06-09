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
		pj.add(new Fantome());
		tab_cases = new Case[taille][taille];
		
		
		for(int i = 0; i < taille; i++){
			
			for(int j = 0; j < taille; j++){
				
				//Condition pour un premier exemple d'affichage des cases
				if(((i%2 == 0) && (j%2 == 0)) ||  (i == 0) || (i == tab_cases.length-1) || (j == 0) || (j == tab_cases[i].length-1)) {
				
					tab_cases[i][j] = new Case(i, j, false);
				
				} else {
				
					tab_cases[i][j] = new Case(i, j, true);
					
				}
					
			}

		}
		
		
		tab_cases[29][29] = new Amulette(29, 29, true);
		tab_cases[1][1] = new Porte(1,1,true);
		for(int k=0; k<pj.size();k++){
			Personnage perso=pj.get(k);
			tab_cases[perso.getX()][perso.getY()].setOccupee(true);
			
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
		int update = 0;
				
		//on prend les coordonnees actuelles du personnage
		for(int i=0;i<pj.size();i++){
			int posX = pj.get(i).getX();
			int posY = pj.get(i).getY();
			//pour le choix aleatoire de direction
			int choix;
			//pour la commande a effectuer selon si heros ou monstre
			Commande commande;	
			if(pj.get(i)instanceof Heros){
				commande=cde;
			}else{
				//test si le mosntre est proche du heros
				if(-10<=pj.get(i).getX()-pj.get(0).getX() && 10>=pj.get(i).getX()-pj.get(0).getX() 
				&& -10<=pj.get(i).getY()-pj.get(0).getY() && 10>=pj.get(i).getY()-pj.get(0).getY()){
					
		
					Heros h = (Heros) pj.get(0);
					Monstre m = (Monstre) pj.get(i);
					commande = new Commande();
					
					if(h.getX() > m.getX()){
						
						commande.droite = true;
						
						if(h.getY() < m.getY()){
							
							commande.haut = true;
						
						}else{
							
							commande.bas = true;
							
						}
						
						
					}else{
						
						
						commande.gauche = true;
						
						if(h.getY() < m.getY()){
							
							commande.haut = true;
						
						}else{
							
							commande.bas = true;
							
						}
						
						
					}
					
					
					
					
					
					
				}else{
					//le monstre est �loign� donc il choisit une direction au hasard
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
			}
			/*
			 * verifie que la case de destination de personnage est franchissable sinon le deplacement ne se fait pas
			 * si la case d'arrivee est occupee, le personnage retourne a sa position initiale
			 * sinon il se deplace sur la case qui devient occupee
			 */
			if(commande.haut){
				if(posY-1>=0 && posY-1<TAILLE_PLATEAU){
					if(this.getPj(i).verifierCase(tab_cases[posX][posY-1]) && !tab_cases[posX][posY-1].estOccupee()){
						this.getPj(i).deplacer(commande);
					

					}
				}
			}
			if(commande.bas){
				if(posY+1>=0 && posY+1<TAILLE_PLATEAU){
					if(this.getPj(i).verifierCase(tab_cases[posX][posY+1]) && !tab_cases[posX][posY+1].estOccupee()){
						this.getPj(i).deplacer(commande);
					
					}
				}
			}
			if(commande.gauche){
				if(posX-1>=0 && posX-1<TAILLE_PLATEAU){
					if(this.getPj(i).verifierCase(tab_cases[posX-1][posY]) && !tab_cases[posX-1][posY].estOccupee()){
						this.getPj(i).deplacer(commande);
					

					}
				}
			}
			if(commande.droite){
				if(posX+1>=0 && posX+1<TAILLE_PLATEAU){
					if(this.getPj(i).verifierCase(tab_cases[posX+1][posY]) && !tab_cases[posX+1][posY].estOccupee()){
						this.getPj(i).deplacer(commande);
					
					}
				}
			}
			//test gestion de l'appui sur deux touches a la fois
			if(pj.get(i).getX()>=0 && pj.get(i).getX() <TAILLE_PLATEAU && pj.get(i).getY()>=0 && pj.get(i).getY() <TAILLE_PLATEAU){
				if(!(this.getPj(i).verifierCase(tab_cases[pj.get(i).getX()][pj.get(i).getY()])) || tab_cases[pj.get(i).getX()][pj.get(i).getY()].estOccupee()){
				
					pj.get(i).setX(posX);;
					pj.get(i).setY(posY);
				
				}else{
					tab_cases[pj.get(i).getX()][pj.get(i).getY()].setOccupee(true);
					tab_cases[posX][posY].setOccupee(false);

				}
			}else{
				pj.get(i).setX(posX);
				pj.get(i).setY(posY);
			}
			
			update++;
		}
	
		if(tab_cases[pj.get(0).getX()][pj.get(0).getY()] instanceof Declencheur){
			
			Declencheur dec = (Declencheur) tab_cases[pj.get(0).getX()][pj.get(0).getY()];
			
			dec.declencherEffet(pj.get(0));
				
		}
	}
	
	
	@Override
	/**
	 * Methode permettant de dire que le jeu n'est jamais fini
	 */
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}
	
	
	/**
	 * Methode permettant de dessiner l'ensemble des objets du labyrinthe
	 * 
	 * @param im
	 * 			BufferedImage
	 */
	public void dessinerObjet(BufferedImage im){
		
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		int taille_c = DessinMonJeu.TAILLE_CASE;
		
		for (int i = 0; i < tab_cases.length; i++) {

			for (int j = 0; j < tab_cases.length; j++) {

				tab_cases[i][j].dessinerObjet(im);
		
		
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
