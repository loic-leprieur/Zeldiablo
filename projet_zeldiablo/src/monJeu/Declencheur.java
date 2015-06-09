package monJeu;

public abstract class Declencheur extends Case {

	public Declencheur(int posX, int posY, boolean etat) {
		super(posX, posY, etat);
	}
	
	
	public void declencherEffet(Personnage pers){
		
		
	};
	
	
	public abstract String toString();
	

}
