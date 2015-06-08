package monJeu;

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
		pj.add(new Monstre());
		pj.add(new Monstre());
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
			Commande commande;	
			if(pj.get(i)==Heros.class){
				//TODO
			}
			//verifie que la case de destination de personnage est franchissable sinon le deplacement ne se fait pas
			if(commande.haut){
				if(tab_cases[posX][posY-1].estFranchissable()){
					this.getPj().deplacer(commande);

				}
			}
			if(commande.bas){
				if(tab_cases[posX][posY+1].estFranchissable()){
					this.getPj().deplacer(commande);
				}
			}
			if(commande.gauche){
				if(tab_cases[posX-1][posY].estFranchissable()){
					this.getPj().deplacer(commande);

				}
			}
			if(commande.droite){
				if(tab_cases[posX+1][posY].estFranchissable()){
					this.getPj().deplacer(commande);

				}
			}
			//test gestion de l'appui sur deux touches a la fois
			if(pj.x==0 || pj.x==tab_cases.length-1)
				pj.x=posX;
			if(pj.y==0 || pj.y==tab_cases.length-1)
				pj.y=posY;
			if(!(tab_cases[pj.x][pj.y].estFranchissable())){
				pj.x=posX;
				pj.y=posY;
			}
		}
	}
	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	public Personnage getPj() {
		return pj;
	}

	public Case[][] getCases(){
		
		return this.tab_cases;
		
	}
	
	
}
