import java.util.Scanner;


/**
 * Classe qui execute un jeu
 */
public class Moteur {

	/**
	 * Methode principale
	 * 
	 * @param args
	 * 		Arguments lors de l'execution
	 */
	public static void main(String[] args) {
		
		//Creation du jeu
		Jeu j = new Jeu();
		
		while(true) {
			//Demande de commandes a executer a l'utilisateur
			String dir = demandeUtilisateur();
			
			//Demande au jeu de deplacer le heros
			j.deplaceHeros(dir);
		}

	}
	
	
	/**
	 * Methode qui permet de demander une direction a l'utilisateur
	 * 
	 * @return
	 * 			Commande a executer
	 */
	public static String demandeUtilisateur() {
		
		Scanner sc = new Scanner(System.in);
		String dir = "";

		System.out.print("Quelle commande souhaitez-vous executer ? : ");
		dir = sc.nextLine();
		System.out.println("");
		
		return dir;
		
	}

}
