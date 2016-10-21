package pokemon;

import java.util.Collection;
import java.util.LinkedList;

import pokemon.AbstractPokemon.PokemonType;

public class Poichigeon extends AbstractPokemon implements Vol{
	
	public final static String POICHIGEON_CRI = "Poichigeon";
	public final static int POICHIGEON_MAX_SANTE = 150;
	public final static int POICHIGEON_SEUIL_SOMMEIL = 500;
	public final static int POICHIGEON_SEUIL_FAIM = 100;
	public final static int POICHIGEON_TEMPS_GESTATION = 365;
	public final static float POICHIGEON_BEBE_POIDS = 1000f;
	public final static float POICHIGEON_BEBE_TAILLE = 5f;
	
	public Poichigeon(final String nom, Sexe sexe, int poids, int taille, int age) {
		super("Poichigeon", null, nom, sexe, poids, taille, age, POICHIGEON_CRI, POICHIGEON_MAX_SANTE, POICHIGEON_SEUIL_SOMMEIL, POICHIGEON_SEUIL_FAIM, POICHIGEON_TEMPS_GESTATION);
		
		Collection<PokemonType> types = new LinkedList<PokemonType>();
		types.add(PokemonType.VOL);
		
		this.setTypes(types);
	}

	/*@Override
	public String TranchHerbe() {
		return this.getNom() + " nage calmement";
	}*/

	@Override
	public float getBebePoids() {
		return POICHIGEON_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return POICHIGEON_BEBE_TAILLE;
	}

}
