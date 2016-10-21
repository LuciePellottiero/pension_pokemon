package pokemon;

import java.util.Collection;
import java.util.LinkedList;

import pokemon.AbstractPokemon.PokemonType;

public class Bulbizarre extends AbstractPokemon implements Plante{
	
	public final static String BULBIZARRE_CRI = "Bulbizarre";
	public final static int BULBIZARRE_MAX_SANTE = 150;
	public final static int BULBIZARRE_SEUIL_SOMMEIL = 500;
	public final static int BULBIZARRE_SEUIL_FAIM = 100;
	public final static int BULBIZARRE_TEMPS_GESTATION = 365;
	public final static float BULBIZARRE_BEBE_POIDS = 1000f;
	public final static float BULBIZARRE_BEBE_TAILLE = 5f;
	
	public Bulbizarre(final String nom, Sexe sexe, int poids, int taille, int age) {
		super("Bulbizarre", null, nom, sexe, poids, taille, age, BULBIZARRE_CRI, BULBIZARRE_MAX_SANTE, BULBIZARRE_SEUIL_SOMMEIL, BULBIZARRE_SEUIL_FAIM, BULBIZARRE_TEMPS_GESTATION);
		
		Collection<PokemonType> types = new LinkedList<PokemonType>();
		types.add(PokemonType.PLANTE);
		
		this.setTypes(types);
	}

	@Override
	public String TranchHerbe() {
		return this.getNom() + " nage calmement";
	}

	@Override
	public float getBebePoids() {
		return BULBIZARRE_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return BULBIZARRE_BEBE_TAILLE;
	}

}
