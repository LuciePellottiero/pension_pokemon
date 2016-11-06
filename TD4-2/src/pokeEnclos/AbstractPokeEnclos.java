package pokeEnclos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import evenement.EvenementPokeEnclosTour;
import pokemon.AbstractPokemon;
import pokemon.IPokemon;
import pokemon.IPokemon.PokemonType;

/**
 * Modèle d'un enclos
 * @author Lucie
 *
 */
public abstract class AbstractPokeEnclos implements Serializable {
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 3233730202455437781L;
	
	private String nomEnclos;
	private final float superficie;
	private final int nbMaxPokemon;
	private Collection<AbstractPokemon> pokemons;
	private Collection<Proprete> propretes;
	private EvenementPokeEnclosTour evenement;
	private final Collection<IPokemon.PokemonType> acceptedTypes;
	
	protected AbstractPokeEnclos(final String nomEnclos, final float superficie, final int nbMaxPokemon, final IPokemon.PokemonType...types) {
		this.nomEnclos = nomEnclos;
		this.superficie = superficie;
		this.nbMaxPokemon = nbMaxPokemon;
		this.acceptedTypes = new ArrayList<IPokemon.PokemonType>(Arrays.asList(types));
	
		this.pokemons = new ArrayList<AbstractPokemon>();
		this.propretes = new ArrayList<Proprete>();
		this.propretes.add(new Proprete("sol"));
		this.evenement = new EvenementPokeEnclosTour(this);
	}
	
	public Collection<IPokemon.PokemonType> getAcceptedtypes() {
		return this.acceptedTypes;
	}
	
	public EvenementPokeEnclosTour getEvenement(){
		return evenement;
	}

	public String getNomEnclos() {
		return nomEnclos;
	}
	
	public void setNomEnclos(String nomEnclos){
		this.nomEnclos = nomEnclos;
	}

	public float getSuperficie() {
		return superficie;
	}

	public int getNbMaxPokemon() {
		return nbMaxPokemon;
	}

	public Collection<AbstractPokemon> getPokemon() {
		return pokemons;
	}

	public int getNbPokemon() {
		return pokemons.size();
	}

	public Collection<Proprete> getPropretes() {
		return propretes;
	}
	
	public boolean ajouterPokemon(final AbstractPokemon pokemon) {
		if (this.getNbPokemon() >= this.getNbMaxPokemon()) {
			throw new IllegalArgumentException("Cet enclos est complet.");
		}
		
		boolean isAccepted = false;
		for(PokemonType type : this.acceptedTypes) {
			if(pokemon.getTypes().contains(type)) {
				isAccepted = true;
				break;
			}
		}
		
		if (!isAccepted) {
			throw new IllegalArgumentException("Cet enclos ne peut que contenir des pokemon de type : " +
					System.lineSeparator() + this.acceptedTypes);
		}
		
		// pour n'avoir que des animaux de même race dans un enclos mais inutile pour les pokemon (qui en plus évoluent)
		/*if (this.getNbPokemon() > 0) {
			
			String raceCourante = this.getPokemon().iterator().next().getRace();
			if (!raceCourante.equals(pokemon.getRace())) {
				throw new IllegalArgumentException("Le race de pokemon de cet enclos est " + raceCourante);
			}
			return this.getPokemon().add(pokemon);
		}*/
		return this.getPokemon().add(pokemon);
	}
	
	public boolean enleverPokemon(final AbstractPokemon pokemon) {
		return pokemons.remove(pokemon);
	}
	
	public String entretenir() {
		if (!this.getPokemon().isEmpty()) {
			throw new IllegalArgumentException("L'entretien ne peut se faire que si l'enclos est vide");
		}
		
		Proprete priorite = this.getPropretes().iterator().next();
		
		for (Proprete proprete : this.getPropretes()) {
			if (priorite.getEtat() < proprete.getEtat()) {
				priorite = proprete;
			}
		}
		
		return priorite.entretien();
	}
	
	@Override
	public abstract String toString();
}
