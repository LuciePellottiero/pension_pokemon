package pokemon;

import java.util.Collection;
import java.util.LinkedList;

import pokemon.AbstractPokemon.PokemonType;

public class Salameche extends AbstractPokemon{

	public static final String SALAMECHE_CRI = "Salameche";
	public static final int SALAMECHE_SANTE_MAX = 90;
	public static final int SALAMECHE_SEUIL_SOMMEIL = 60;
	public static final int SALAMECHE_SEUIL_FAIM = 150;
	public static final int SALAMECHE_TEMPS_GESTATION = 49;
	public static final float SALAMECHE_EVO_POIDS = 10f;
	public static final float SALAMECHE_EVO_TAILLE = 0.2f;
	
	public Salameche(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Salameche", null, nom, sexe, poids, taille, age, SALAMECHE_CRI, SALAMECHE_SANTE_MAX, SALAMECHE_SEUIL_SOMMEIL, SALAMECHE_SEUIL_FAIM, SALAMECHE_TEMPS_GESTATION);
		
		Collection<PokemonType> types = new LinkedList<PokemonType>();
		types.add(PokemonType.FEU);
		
		this.setTypes(types);
	}

	@Override
	public float getEvoPoids() {
		return SALAMECHE_EVO_POIDS;
	}

	@Override
	public float getEvoTaille() {
		return SALAMECHE_EVO_TAILLE;
	}
}
