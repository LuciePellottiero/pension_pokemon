package pension;

import java.util.Collection;
import java.util.LinkedList;

import enclos.AbstractEnclos;
import joueur.Joueur;
import pokemon.AbstractPokemon;

public class Pension {

	private final String nom;
	private final Joueur employe;
	private final int nbMaxEnclos;
	private Collection<AbstractEnclos> enclos;
	
	public Pension(final String nom, final Joueur employe, final int nbMaxEnclos) {
		this.nom = nom;
		this.nbMaxEnclos = nbMaxEnclos;
		this.employe = employe;
		
		enclos = new LinkedList<AbstractEnclos>();
	}
	
	public String getPokemonStr() {
		String str = "";
		
		for(AbstractEnclos enclos : enclos) {
			for (AbstractPokemon pokemon : enclos.getPokemon()) {
				str += pokemon.toString() + System.lineSeparator();
			}
		}
		
		return str;
	}
	
	public int getNbMaxEnclos(){
		return nbMaxEnclos;
	}
	
	public boolean ajouterEnclos(final AbstractEnclos enclos) {
		if (this.enclos.size() == this.nbMaxEnclos) {
			return false;
		}
		
		return this.enclos.add(enclos);
	}
	
	public Joueur getEmploye() {
		return this.employe;
	}
	
	public Collection<AbstractEnclos> getEnclos() {
		return this.enclos;
	}
}
