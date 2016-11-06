package pokeEnclos;

import pokemon.IPokemon;

/**
 * Enclos de format bassin pouvant acceuillir des pokemon aquatiques (types eau et glace)
 * @author Lucie
 *
 */
public class PokeBassin extends AbstractPokeEnclos{
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 862366975768595026L;
	
	private final float profondeur;

	public PokeBassin(String nomEnclos, float superficie, int nbMaxAnimaux, float profondeur) {
		super(nomEnclos, superficie, nbMaxAnimaux, IPokemon.PokemonType.EAU, IPokemon.PokemonType.GLACE);
		this.profondeur = profondeur;
		this.getPropretes().add(new Proprete("niveau de l'eau"));
		this.getPropretes().add(new Proprete("salinite"));
	}
	
	public final float getProfondeur(){
		return profondeur;
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				"profondeur: " + this.getProfondeur() + "m, " +
				this.getNbPokemon() + "/" + this.getNbMaxPokemon() + " animaux, " + 
				this.getPropretes() + System.lineSeparator();
		
		return res;
	}
}
