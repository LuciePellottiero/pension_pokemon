package enclos;

import animaux.AbstractAnimal;

public class EnclosStandard extends AbstractEnclos{

	public EnclosStandard(String nomEnclos, float superficie, int nbMaxAnimaux) {
		super(nomEnclos, superficie, nbMaxAnimaux);
	}

	@Override
	public boolean ajouterAnimal(AbstractAnimal animal) {
		if (this.getNbAnimaux() >= this.getNbMaxAnimaux()) {
			throw new IllegalArgumentException("Cet enclos est complet.");
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
		return this.getAnimaux().add(animal);
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				this.getNbAnimaux() + "/" + this.getNbMaxAnimaux() + " animaux, " + 
				this.getPropretes() + System.lineSeparator();
		
		return res;
	}

}
