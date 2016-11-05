package enclos;

import animaux.IAnimal;

public class Voliere extends AbstractEnclos{
	
	private float hauteur;
	
	public Voliere(String nomEnclos, float superficie, int nbMaxAnimaux, float hauteur) {
		super(nomEnclos, superficie, nbMaxAnimaux, IAnimal.AnimalType.VOLANT);
		this.hauteur = hauteur;
		this.getPropretes().add(new Proprete("toit"));
	}

	public float getHauteur(){
		return hauteur;
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				"hauteur: " + this.getHauteur() + "m, " +
				this.getNbAnimaux() + "/" + this.getNbMaxAnimaux() + " animaux, " + 
				this.getPropretes() + System.lineSeparator();
		
		return res;
	}

}
