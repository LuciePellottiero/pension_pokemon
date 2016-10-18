package enclos;

import animaux.AbstractAnimal;
import animaux.AbstractAnimal.AnimalType;

public class Voliere extends AbstractEnclos{
	
	private final int hauteur;
	private Proprete etatToit;

	public Voliere(String nomEnclos, float superficie, int nbMaxAnimaux, final int hauteur) {
		super(nomEnclos, superficie, nbMaxAnimaux);
		this.hauteur = hauteur;
		etatToit = new Proprete("toit");
	}

	public final int getHauteur(){
		return hauteur;
	}
	
	@Override
	public boolean ajouterAnimal(AbstractAnimal animal) {
		if (!animal.getTypes().contains(AnimalType.VOLANT)) {
			throw new IllegalArgumentException("Une voliere ne peut que contenir des animaux volants");
		}
		if (this.getNbAnimaux() > 0) {
			
			String raceCourante = this.getAnimaux().iterator().next().getRace();
			if (!raceCourante.equals(animal.getRace())) {
				throw new IllegalArgumentException("Le race d'animaux de cet enclos est " + raceCourante);
			}
			else {
				return this.getAnimaux().add(animal);
			}
		}
		else {
			return this.getAnimaux().add(animal);
		}
	}

	@Override
	public String entretenir() {
		if (!this.getAnimaux().isEmpty()) {
			return "L'entretient ne peut se faire que si l'enclo est vide";
		}
		
		if (this.etatToit.getEtat() >= this.getProprete().getEtat()) {
			return this.getProprete().entretient();
		}
		else {
			return this.etatToit.entretient();
		}
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				"hauteur: " + this.getHauteur() + "m, " +
				this.getNbAnimaux() + "/" + this.getNbMaxAnimaux() + " animaux, " + 
				this.getProprete().getNom() + " : " + this.getProprete().getEtatStr() + ", " + 
				this.etatToit.getNom() + " : " + etatToit.getEtatStr() + System.lineSeparator();
		
		return res;
	}

}
