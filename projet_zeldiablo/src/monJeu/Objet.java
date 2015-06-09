package monJeu;

import java.awt.image.BufferedImage;

public abstract class Objet {
	private int x;
	private int y;
	
	public Objet(int abs, int ord){
		x=abs;
		y=ord;
	}
	
	public abstract void dessinerObjet(BufferedImage im);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract String toString();
	
	
	
}
