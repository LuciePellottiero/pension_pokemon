package pokemon;

import java.util.Collection;
import java.util.LinkedList;

import pokemon.AbstractPokemon.PokemonType;

public class Herbizarre extends AbstractPokemon implements Plante{
	
	public final static String HERBIZARRE_CRI = "Herbizarre";
	public final static int HERBIZARRE_MAX_SANTE = 80;
	public final static int HERBIZARRE_SEUIL_SOMMEIL = 70;
	public final static int HERBIZARRE_SEUIL_FAIM = 42;
	public final static int HERBIZARRE_TEMPS_GESTATION = 60;
	public final static float HERBIZARRE_EVO_POIDS = 0.5f;
	public final static float HERBIZARRE_EVO_TAILLE = 0.3f;

	public Herbizarre(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Herbizarre", null, nom, sexe, poids, taille, age, HERBIZARRE_CRI, HERBIZARRE_MAX_SANTE, HERBIZARRE_SEUIL_SOMMEIL, HERBIZARRE_SEUIL_FAIM, HERBIZARRE_TEMPS_GESTATION);
		
		Collection<PokemonType> types = new LinkedList<PokemonType>();
		types.add(PokemonType.PLANTE);
		
		this.setTypes(types);
	}

	@Override
	public String TranchHerbe() {
		return this.getNom() + " vagabonde tranquillement";
	}

	@Override
	public float getEvoPoids() {
		return HERBIZARRE_EVO_POIDS;
	}

	@Override
	public float getEvoTaille() {
		return HERBIZARRE_EVO_TAILLE;
	}
	
}
