package pokeEnclos;

import animaux.IPokemon;

public class PokeVoliere extends AbstractPokeEnclos{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -3650306296290063545L;
	
	private float hauteur;
	
	public PokeVoliere(String nomEnclos, float superficie, int nbMaxAnimaux, float hauteur) {
		super(nomEnclos, superficie, nbMaxAnimaux, IPokemon.PokemonType.VOL);
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
				this.getNbPokemon() + "/" + this.getNbMaxPokemon() + " animaux, " + 
				this.getPropretes() + System.lineSeparator();
		
		return res;
	}

}
