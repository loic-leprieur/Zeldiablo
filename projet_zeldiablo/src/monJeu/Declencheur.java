package monJeu;

public abstract class Declencheur extends Case {

	public Declencheur(boolean etat) {
		super(etat);
	}
	
	
	public abstract void declencherEffet(Personnage pers);
	
	
	public abstract String toString();
	

}
