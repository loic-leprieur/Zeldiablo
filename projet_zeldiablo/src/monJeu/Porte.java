package monJeu;

public class Porte extends Declencheur{

	public Porte(int posX, int posY, boolean etat) {
		super(posX, posY, etat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void declencherEffet(Personnage pers) {
		// TODO Auto-generated method stub
		if(((Heros)pers).isPossedeAmu()){
			
		}else{
			
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
