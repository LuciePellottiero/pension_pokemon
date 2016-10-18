package enclos;

import animaux.AbstractAnimal;

public class EnclosStandard extends AbstractEnclos{

	public EnclosStandard(String nomEnclos, float superficie, int nbMaxAnimaux) {
		super(nomEnclos, superficie, nbMaxAnimaux);
	}

	@Override
	public boolean ajouterAnimal(AbstractAnimal animal) {
		if (this.getNbAnimaux() > 0) {
			
			String raceCourante = this.getAnimaux().iterator().next().getRace();
			if (!raceCourante.equals(animal.getRace())) {
				throw new IllegalArgumentException("Le race d'animaux de cet enclos est " + raceCourante);
			}
			else {
				return this.getAnimaux().add(animal);
			}
		}
		return this.getAnimaux().add(animal);
	}

	@Override
	public String entretenir() {
		if (!this.getAnimaux().isEmpty()) {
			return "L'entretient ne peut se faire que si l'enclos est vide";
		}
		
		return this.getProprete().entretient();
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				this.getNbAnimaux() + "/" + this.getNbMaxAnimaux() + " animaux, " + 
				this.getProprete().getNom() + " : " + this.getProprete().getEtatStr() + System.lineSeparator();
		
		return res;
	}

}
