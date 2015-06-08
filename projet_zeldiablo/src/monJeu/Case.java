package monJeu;

public class Case {
	
	/**
	 * Attribut representant la franchissabilite d'une case
	 */
	
	private boolean franchissable;
	
	
	
	/**
	 * Constructeur par defaut qui initialise une case non franchissable
	 */
	
	
	public Case(boolean etat){
		
		
		this.franchissable = etat;
		
		
		
	}
	

	/**
	 * Methode qui permet de connaitre la franchissabilite d'une case
	 * 
	 * @return
	 * 
	 * 		Retourne true si la case est franchissable, false sinon
	 */
	
	public boolean estFranchissable(){
		
		return this.franchissable;
		
	}
	
	
	/**
	 * Methode qui permet de modifier la franchissabilite d'une case
	 * 
	 * @param etat
	 * 			Nouvel etat de la case
	 */
	
	
	public void setFranchissable(boolean etat){
		
		
		this.franchissable = etat;
	
	}
	
	
	/**
	 * Methode qui permet de renvoyer le type d'une case
	 */
	
	public String toString(){
		
		String type;
		
		if(franchissable){
			
			type = "vide";
			
		}else{
			
			type = "mur";
			
		}
		
		
		
		return "type:" + type;
		
		
	}
	
	
}
