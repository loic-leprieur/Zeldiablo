
public class Jeu {

	
	Aventurier heros;
	
	
	
	public Jeu(){
			
		this.heros = new Aventurier();
		
	}
	
 	
	
	
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
