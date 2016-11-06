package pensionPokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import animaux.AbstractPokemon;
import employe.Employe;
import pokeEnclos.AbstractPokeEnclos;

public class PensionPokemon implements Serializable{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 7020412288975185458L;
	
	private final String nom;
	private final Employe employe;
	private final int nbMaxEnclos;
	private Collection<AbstractPokeEnclos> enclos;
	
	public PensionPokemon(final String nom, final Employe employe, final int nbMaxEnclos) {
		this.nom = nom;
		this.nbMaxEnclos = nbMaxEnclos;
		this.employe = employe;
		
		enclos = new ArrayList<AbstractPokeEnclos>();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPokemonStr() {
		String str = "";
		
		List<AbstractPokemon> sortedPokemon = new ArrayList<AbstractPokemon>();
		
		for(AbstractPokeEnclos enclos : enclos) {
			for (AbstractPokemon pokemon : enclos.getPokemon()) {
				sortedPokemon.add(pokemon);
			}
		}
		
		Collections.sort(sortedPokemon);
		
		for (AbstractPokemon pokemonName : sortedPokemon) {
			str += pokemonName + System.lineSeparator();
		}
		
		return str;
	}
	
	public int getNbMaxEnclos(){
		return nbMaxEnclos;
	}
	
	public boolean ajouterEnclos(final AbstractPokeEnclos enclos) {
		if (this.enclos.size() == this.nbMaxEnclos) {
			return false;
		}
		
		return this.enclos.add(enclos);
	}
	
	public Employe getEmploye() {
		return this.employe;
	}
	
	public Collection<AbstractPokeEnclos> getEnclos() {
		return this.enclos;
	}
}
