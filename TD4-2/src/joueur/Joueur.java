package joueur;

import enclos.AbstractEnclos;
import pokemon.AbstractPokemon;
import pokemon.AbstractPokemon.Sexe;

public class Joueur {
	private final String nom;
	private final AbstractPokemon.Sexe sexe;
	private final int age;
	
	public Joueur(final String nom, final Sexe sexe, final int age) {
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}
	
	public String examinerEnclos(AbstractEnclos enclos) {
		
		String res = this.nom + " examine ";
		
		res += enclos.toString();
		
		for (AbstractPokemon animal : enclos.getPokemon()) {
			res += animal + System.lineSeparator();
		}
		
		return res;
	}
	
	public String nettoyer(AbstractEnclos enclos) {
		String res = this.nom + " netoie " + enclos.getNomEnclos();
		res += enclos.entretenir();
		return res;
	}
	
	public String nourrir(AbstractEnclos enclos) {
		String res = this.nom + " nourris  les animaux de " + enclos.getNomEnclos() + System.lineSeparator(); 
		
		for (AbstractPokemon animal : enclos.getPokemon()) {
			res += animal.manger();
		}
		
		return res;
	}
	
	public String transferer(AbstractPokemon pokemon, AbstractEnclos ancienEnclos, AbstractEnclos nouvelEnclos) {
		String res = "";
		
		if (!ancienEnclos.getPokemon().contains(pokemon)) {
			throw new IllegalArgumentException("L'ancien enclos ne contient pas " + pokemon.getNom());
		}
		try {
			nouvelEnclos.ajouterPokemon(pokemon);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Erreur lors du transfere vers " + nouvelEnclos.getNomEnclos());
			System.out.println(e.getMessage());
			return "";
		}
		
		if (!ancienEnclos.enleverPokemon(pokemon)) {
			res += "Erreur lors de du transfère depuis " + ancienEnclos.getNomEnclos();
		}
		
		return res;
	}
}
