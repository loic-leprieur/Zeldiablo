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
	public void evoluer(Commande commandeUser) {
		// TODO Auto-generated method stub
		
	}
	
	public void evoluer(String commande){
		
		
		switch(commande){
		
		case "H":
			
			heros.seDeplacer(0,10);
			break;
		
		case "B":
			heros.seDeplacer(0,-10);
			break;
			
		case "G":
			heros.seDeplacer(-10,0);
			break;
			
		case "D":
			heros.seDeplacer(10,0);
			break;
			
		case "exit":
			System.exit(0);
			
		default:
			System.out.println("Commande non reconnue !");
			break;
		
		
		}
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
				//Demande de commandes a executer a l'utilisateur
				Scanner sc = new Scanner(System.in);
				String dir = sc.nextLine();
			
				//Demande au jeu de deplacer le heros
				j.evoluer(dir);
			}

		}
		
		
		
		public String toString() {
			return (heros.getPosX()+", "+heros.getPosY());
		}

		


		@Override
		public boolean etreFini() {
			// TODO Auto-generated method stub
			return false;
		}


	
		
		
		
		
}