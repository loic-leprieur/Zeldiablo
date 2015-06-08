package monJeu;

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
	private Personnage pj;
	private Case[][] tab_cases;
	

	/**
	 * constructeur de jeu avec un Personnage et un labyrinthe comportant
	 * uniquement des cases non traversables
	 */
	
	public MonJeu(int taille) {
		this.pj=new Personnage();		
		tab_cases = new Case[taille][taille];
		
		
		for(int i = 0; i < taille; i++){
			
			for(int j = 0; j < taille; j++){
				
				if((i == 0) || (i == tab_cases.length-1) || (j == 0) || (j == tab_cases[i].length-1)) {
				
					tab_cases[i][j] = new Case(false);
				
				} else {
				
					tab_cases[i][j] = new Case(new Random().nextBoolean());
					
				}
					
			}

		}
		
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		return ("" + this.getPj());
	}

	/**
	 * demande a deplacer le personnage
	 * 
	 * @param commande
	 *            chaine qui donne ordre
	 */
	public void evoluer(Commande commande) {
		//on prend les coordonnees actuelles du personnage
		int posX = pj.x;
		int posY = pj.y;
				
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
