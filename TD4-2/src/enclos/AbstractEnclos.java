package enclos;

import java.util.Collection;
import java.util.LinkedList;

import pokemon.AbstractPokemon;

public abstract class AbstractEnclos {
	
	private String nomEnclos;
	private final float superficie;
	private final int nbMaxPokemon;
	private Collection<AbstractPokemon> pokemon;
	private Proprete proprete;
	
	protected AbstractEnclos(final String nomEnclos, final float superficie, final int nbMaxPokemon) {
		this.nomEnclos = nomEnclos;
		this.superficie = superficie;
		this.nbMaxPokemon = nbMaxPokemon;
	
		this.pokemon = new LinkedList<AbstractPokemon>();
		this.proprete = new Proprete("cage");
	}

	public String getNomEnclos() {
		return nomEnclos;
	}

	public float getSuperficie() {
		return superficie;
	}

	public int getNbMaxPokemon() {
		return nbMaxPokemon;
	}

	public Collection<AbstractPokemon> getPokemon() {
		return pokemon;
	}

	public int getNbPokemon() {
		return pokemon.size();
	}

	public Proprete getProprete() {
		return proprete;
	}
	
	public abstract boolean ajouterPokemon(final AbstractPokemon pokemon);
	
	public boolean enleverPokemon(final AbstractPokemon animal) {
		return pokemon.remove(animal);
	}
	
	public abstract String entretenir();
	
	@Override
	public abstract String toString();
}
