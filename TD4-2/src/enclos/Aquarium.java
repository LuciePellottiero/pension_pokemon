package enclos;

import pokemon.AbstractPokemon;
import pokemon.AbstractPokemon.PokemonType;

public class Aquarium extends AbstractEnclos{
	private final int profondeur;
	private Proprete niveauEau;
	private Proprete salinite;

	public Aquarium(String nomEnclos, float superficie, int nbMaxPokemon, final int profondeur) {
		super(nomEnclos, superficie, nbMaxPokemon);
		this.profondeur = profondeur;
		niveauEau = new Proprete("niveau de l'eau");
		salinite = new Proprete("salinite");
	}
	
	public final int getProfondeur(){
		return profondeur;
	}

	@Override
	public boolean ajouterPokemon(AbstractPokemon pokemon) {
		if (!pokemon.getTypes().contains(PokemonType.EAU)) {
			throw new IllegalArgumentException("Un aquarium ne peut que contenir des animaux marins");
		}
		if (this.getNbPokemon() > 0) {
			
			String raceCourante = this.getPokemon().iterator().next().getRace();
			if (!raceCourante.equals(pokemon.getRace())) {
				throw new IllegalArgumentException("Le race de Pokemon de cet aquarium est " + raceCourante);
			}
			return this.getPokemon().add(pokemon);
		}
		return this.getPokemon().add(pokemon);
	}

	@Override
	public String entretenir() {
		if (!this.getPokemon().isEmpty()) {
			return "L'entretient ne peut se faire que si l'aquarium est vide";
		}
		
		Proprete priorite;
		
		int etat = Math.min(this.niveauEau.getEtat(), this.getProprete().getEtat());
		if (etat == this.niveauEau.getEtat()) {
			priorite = this.niveauEau;
		}
		else {
			priorite = this.salinite;
		}
		
		etat = Math.min(priorite.getEtat(), this.salinite.getEtat());
		if (etat == this.salinite.getEtat()) {
			priorite = this.salinite;
		}
		
		return priorite.entretient();
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				"profondeur: " + this.getProfondeur() + "m, " +
				this.getNbPokemon() + "/" + this.getNbMaxPokemon() + " pokemon, " + 
				this.getProprete().getNom() + " : " + this.getProprete().getEtatStr() + ", " + 
				this.niveauEau.getNom() + " : " + niveauEau.getEtatStr() + System.lineSeparator() + ", " +
				this.salinite.getNom() + " : " + salinite.getEtatStr() + System.lineSeparator();
		
		return res;
	}
}
