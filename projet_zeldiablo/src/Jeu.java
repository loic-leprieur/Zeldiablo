
public class Jeu {

	
	/**
	 * Attribut representant le heros du jeu
	 */
	
	Aventurier heros;
	
	
	/**
	 * Constructeur sans parametres qui construit un nouveau heros
	 */
	
	public Jeu(){
			
		this.heros = new Aventurier();
		
	}
	
 	
	/**
	 * Methode qui permet au heros de se deplacer
	 * 
	 * @param dir
	 * 			Commande a executer
	 */
	
	
	public void deplaceHeros(String dir){
		
		
		switch(dir){
		
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
	
	
	
	
	
}
