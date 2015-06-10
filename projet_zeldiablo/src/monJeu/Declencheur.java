package monJeu;

public class Declencheur extends Case {
	
	/**
	 * constructeur d'une case
	 * qui peut activer un effet
	 * @param posX
	 * @param posY
	 * @param etat
	 */
	public Declencheur(int posX, int posY, boolean etat) {
		super(posX, posY, etat);
	}
	
	/**
	 * methode vide override par les cases
	 * dérivees par declencheur
	 * @param pers
	 */
	public void declencherEffet(Personnage pers){
		
		
	};
	

	

}
