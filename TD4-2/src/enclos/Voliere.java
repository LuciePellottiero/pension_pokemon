package enclos;

import pokemon.AbstractPokemon;
import pokemon.AbstractPokemon.PokemonType;

public class Voliere extends AbstractEnclos{
	
	private final int hauteur;
	private Proprete etatToit;

	public Voliere(String nomEnclos, float superficie, int nbMaxPokemon, final int hauteur) {
		super(nomEnclos, superficie, nbMaxPokemon);
		this.hauteur = hauteur;
		etatToit = new Proprete("toit");
	}

	public final int getHauteur(){
		return hauteur;
	}
	
	@Override
	public boolean ajouterPokemon(AbstractPokemon pokemon) {
		if (!pokemon.getTypes().contains(PokemonType.VOL)) {
			throw new IllegalArgumentException("Une voliere ne peut que contenir des Pokemons de type Vol");
		}
		if (this.getNbPokemon() > 0) {
			
			String raceCourante = this.getPokemon().iterator().next().getRace();
			if (!raceCourante.equals(pokemon.getRace())) {
				throw new IllegalArgumentException("Le race d'animaux de cette volière est " + raceCourante);
			}
			else {
				return this.getPokemon().add(pokemon);
			}
		}
		else {
			return this.getPokemon().add(pokemon);
		}
	}

	@Override
	public String entretenir() {
		if (!this.getPokemon().isEmpty()) {
			return "L'entretient ne peut se faire que si la volière est vide";
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
				this.getNbPokemon() + "/" + this.getNbMaxPokemon() + " pokemon, " + 
				this.getProprete().getNom() + " : " + this.getProprete().getEtatStr() + ", " + 
				this.etatToit.getNom() + " : " + etatToit.getEtatStr() + System.lineSeparator();
		
		return res;
	}

}
