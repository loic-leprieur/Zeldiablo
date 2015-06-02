package monJeu;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public class MonJeu implements Jeu {

	
	/**
	 * Attribut representant le heros du jeu
	 */
	
	Personnage heros;
	
	
	/**
	 * Constructeur sans parametres qui construit un nouveau heros
	 */
	
	public MonJeu(){
			
		this.heros = new Personnage();
		
	}
	
 	
	/**
	 * Methode qui permet au heros de se deplacer
	 * 
	 * @param commande
	 * 			Commande a executer
	 */
	
	

	@Override
	public void evoluer(Commande c){
		heros.deplacer(c);
	}
		
		
		public String toString() {
			return (heros.toString());
		}

		


		@Override
		public boolean etreFini() {
			
			return false;
		}


	
		
		
		
		
}