package monJeu;


/**
 * Classe modelisant une case
 */
public class Case {
	
	/**
	 * Attribut representant la franchissabilite d'une case et si elle est occupee
	 */
	
	private boolean franchissable, occupee;
	
	
	
	/**
	 * Constructeur par defaut qui initialise une case non franchissable
	 * 
	 * @param
	 * 
	 * 		Booleen qui indique si la case est franchissable ou non
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
	 * Retourne vrai si la case verifiee est occupee
	 * @return boolean
	 */
	public boolean estOccupee() {
		return occupee;
	}

	/**
	 * modifie l occupation de la case 
	 * @param occupee
	 */
	public void setOccupee(boolean occupee) {
		this.occupee = occupee;
	}


	/**
	 * Methode qui permet de renvoyer le type d'une case
	 * 
	 * @return
	 * 
	 * 			Retourne une chaine decrivant une case (type)
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
