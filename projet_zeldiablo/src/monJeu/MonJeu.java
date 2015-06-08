package monJeu;

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
				
				tab_cases[i][j] = new Case(false);
				
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
				
		//v�rifie que la case de destination de personnage est franchissable sinon le deplacement ne se fait pas
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
