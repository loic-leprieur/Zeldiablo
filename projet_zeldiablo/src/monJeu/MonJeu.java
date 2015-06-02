package monJeu;

import java.util.Scanner;

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
		
		
		/**
		 * Methode principale
		 * 
		 * @param args
		 * 		Arguments lors de l'execution
		 */
		public static void main(String[] args) {
			
			//Creation du jeu
			MonJeu j = new MonJeu();
			
			while(true) {
			
				
			
				//Demande au jeu de deplacer le heros
				j.evoluer(dir);
			}

		}
		
		
		
		public String toString() {
			return (heros.toString());
		}

		


		@Override
		public boolean etreFini() {
			// TODO Auto-generated method stub
			return false;
		}


	
		
		
		
		
}