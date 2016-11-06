package pokeEnclos;

import pokemon.IPokemon;

/**
 * Enclos basique pouvant acceuillir divers type de pokemon
 * @author Lucie
 *
 */
public class EnclosStandard extends AbstractPokeEnclos{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -981895495248491916L;
	

	public EnclosStandard(String nomEnclos, float superficie, int nbMaxAnimaux) {
		super(nomEnclos, superficie, nbMaxAnimaux, IPokemon.PokemonType.PLANTE, IPokemon.PokemonType.ELECTRIK, IPokemon.PokemonType.POISON);
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				this.getNbPokemon() + "/" + this.getNbMaxPokemon() + " animaux, " + 
				this.getPropretes() + System.lineSeparator();
		
		return res;
	}

}
