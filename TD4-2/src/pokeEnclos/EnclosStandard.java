package pokeEnclos;

import pokemon.IPokemon;

public class EnclosStandard extends AbstractPokeEnclos{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -981895495248491916L;
	

	public EnclosStandard(String nomEnclos, float superficie, int nbMaxAnimaux) {
		super(nomEnclos, superficie, nbMaxAnimaux, IPokemon.PokemonType.PLANTE, IPokemon.PokemonType.NORMAL);
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				this.getNbPokemon() + "/" + this.getNbMaxPokemon() + " animaux, " + 
				this.getPropretes() + System.lineSeparator();
		
		return res;
	}

}
