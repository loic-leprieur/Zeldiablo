
public class Aventurier {
	// position en abscisse
	private int posX;
	// position en ordonnee
	private int posY;
	
	/**
	 * constructeur par defaut
	 * initilialise la position
	 * de l'aventurier
	 */
	public Aventurier(){
		posX=0;
		posY=0;
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
