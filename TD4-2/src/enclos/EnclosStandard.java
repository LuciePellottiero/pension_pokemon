package enclos;

import pokemon.AbstractPokemon;

public class EnclosStandard extends AbstractEnclos{

	public EnclosStandard(String nomEnclos, float superficie, int nbMaxPokemon) {
		super(nomEnclos, superficie, nbMaxPokemon);
	}

	@Override
	public boolean ajouterPokemon(AbstractPokemon pokemon) {
		if (this.getNbPokemon() > 0) {
			
			String raceCourante = this.getPokemon().iterator().next().getRace();
			if (!raceCourante.equals(pokemon.getRace())) {
				throw new IllegalArgumentException("Le race d'animaux de cet enclos est " + raceCourante);
			}
			else {
				return this.getPokemon().add(pokemon);
			}
		}
		return this.getPokemon().add(pokemon);
	}

	@Override
	public String entretenir() {
		if (!this.getPokemon().isEmpty()) {
			return "L'entretient ne peut se faire que si l'enclos est vide";
		}
		
		return this.getProprete().entretient();
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				this.getNbPokemon() + "/" + this.getNbMaxPokemon() + " animaux, " + 
				this.getProprete().getNom() + " : " + this.getProprete().getEtatStr() + System.lineSeparator();
		
		return res;
	}

}
