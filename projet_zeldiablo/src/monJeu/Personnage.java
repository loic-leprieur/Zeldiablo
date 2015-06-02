package monJeu;


public class Personnage {
	// position en abscisse
	private int posX;
	// position en ordonnee
	private int posY;
	
	/**
	 * constructeur par defaut
	 * initilialise la position
	 * de l'aventurier
	 */
	public Personnage(){
		posX=5;
		posY=5;
	}
	
	/**
	 * translation du personnage
	 * @param x
	 * @param y
	 */
	public void seDeplacer(int x, int y){
		posX+=x;
		posY+=y;
	}
	
	/**
	 * affichage des infos
	 * d'un aventurier
	 */
	@Override
	public String toString() {
		return "Aventurier [posX=" + posX + ", posY=" + posY + "]";
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
