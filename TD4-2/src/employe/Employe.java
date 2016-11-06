package employe;

import java.io.Serializable;

import animaux.AbstractPokemon;
import animaux.IPokemon;
import pokeEnclos.AbstractPokeEnclos;

public class Employe implements Serializable{
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -7214996969319942034L;
	
	private final String nom;
	@SuppressWarnings("unused")
	private final IPokemon.Sexe sexe;
	@SuppressWarnings("unused")
	private final int age;
	
	public Employe(final String nom, final IPokemon.Sexe sexe, final int age) {
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String examinerEnclos(AbstractPokeEnclos enclos) {
		
		String res = this.nom + " examine ";
		
		res += enclos.toString();
		
		for (AbstractPokemon animal : enclos.getPokemon()) {
			res += animal + System.lineSeparator();
		}
		
		return res;
	}
	
	public String nettoyer(AbstractPokeEnclos enclos) {
		String res = this.nom + " nettoie " + enclos.getNomEnclos();
		res += ": état = " +enclos.entretenir();
		return res;
	}
	
	public String nourrir(AbstractPokeEnclos enclos) {
		String res = this.nom + " nourris les animaux de " + enclos.getNomEnclos() + System.lineSeparator(); 
		
		for (AbstractPokemon animal : enclos.getPokemon()) {
			res += animal.manger();
		}
		
		return res;
	}
	
	public String transferer(AbstractPokemon animal, AbstractPokeEnclos ancienEnclos, AbstractPokeEnclos nouvelEnclos) {
		String res = "";
		
		if (!ancienEnclos.getPokemon().contains(animal)) {
			throw new IllegalArgumentException("L'ancien enclos ne contient pas " + animal.getNom());
		}
		nouvelEnclos.ajouterPokemon(animal);
		
		if (!ancienEnclos.enleverPokemon(animal)) {
			res += "Erreur lors du transfère depuis " + ancienEnclos.getNomEnclos();
		}
		
		return res;
	}
}
