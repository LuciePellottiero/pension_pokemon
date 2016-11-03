package enclos;

import animaux.AbstractAnimal;
import animaux.AbstractAnimal.AnimalType;

public class Aquarium extends AbstractEnclos{
	private final float profondeur;
	private Proprete niveauEau;
	private Proprete salinite;

	public Aquarium(String nomEnclos, float superficie, int nbMaxAnimaux, float profondeur) {
		super(nomEnclos, superficie, nbMaxAnimaux);
		this.profondeur = profondeur;
		niveauEau = new Proprete("niveau de l'eau");
		salinite = new Proprete("salinite");
	}
	
	public final float getProfondeur(){
		return profondeur;
	}

	@Override
	public boolean ajouterAnimal(AbstractAnimal animal) {
		if (this.getNbAnimaux() >= this.getNbMaxAnimaux()) {
			throw new IllegalArgumentException("Cet enclos est complet.");
		}
		if (!animal.getTypes().contains(AnimalType.MARIN)) {
			throw new IllegalArgumentException("Un aquarium ne peut que contenir des animaux marins");
		}
		if (this.getNbAnimaux() > 0) {
			
			String raceCourante = this.getAnimaux().iterator().next().getRace();
			if (!raceCourante.equals(animal.getRace())) {
				throw new IllegalArgumentException("Le race d'animaux de cet enclos est " + raceCourante);
			}
			return this.getAnimaux().add(animal);
		}
		return this.getAnimaux().add(animal);
	}

	@Override
	public String entretenir() {
		if (!this.getAnimaux().isEmpty()) {
			return "L'entretien ne peut se faire que si l'enclos est vide";
		}
		
		Proprete priorite;
		
		int etat = Math.min(this.niveauEau.getEtat(), this.getProprete().getEtat());
		if (etat == this.niveauEau.getEtat()) {
			priorite = this.niveauEau;
		}
		else {
			priorite = this.salinite;
		}
		
		etat = Math.min(priorite.getEtat(), this.salinite.getEtat());
		if (etat == this.salinite.getEtat()) {
			priorite = this.salinite;
		}
		
		return priorite.entretient();
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				"profondeur: " + this.getProfondeur() + "m, " +
				this.getNbAnimaux() + "/" + this.getNbMaxAnimaux() + " animaux, " + 
				this.getProprete().getNom() + " : " + this.getProprete().getEtatStr() + ", " + 
				this.niveauEau.getNom() + " : " + niveauEau.getEtatStr() + System.lineSeparator() + ", " +
				this.salinite.getNom() + " : " + salinite.getEtatStr() + System.lineSeparator();
		
		return res;
	}
}
