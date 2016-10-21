package pokemon;

import java.util.Collection;
import java.util.LinkedList;

import pokemon.AbstractPokemon.AnimalType;

public class Magicarpe extends AbstractPokemon implements Normal{

	public static final String MAGICARPE_CRI = "Magicarpe";
	public static final int MAGICARPE_SANTE_MAX = 10;
	public static final int MAGICARPE_SEUIL_SOMMEIL = 70;
	public static final int MAGICARPE_SEUIL_FAIM = 65;
	public static final int MAGICARPE_TEMPS_GESTATION = 4;
	public static final float MAGICARPE_BEBE_POIDS = 0.0001f;
	public static final float MAGICARPE_BEBE_TAILLE = 0.0002f;
	
	public Magicarpe(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Magicarpe", null, nom, sexe, poids, taille, age, MAGICARPE_CRI, MAGICARPE_SANTE_MAX, MAGICARPE_SEUIL_SOMMEIL, MAGICARPE_SEUIL_FAIM, MAGICARPE_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.EAU);
		
		this.setTypes(types);
	}

	@Override
	public String Trempette() {
		return this.getNom() + " nage un peu ridiculement";
	}

	@Override
	public float getBebePoids() {
		return MAGICARPE_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return MAGICARPE_BEBE_TAILLE;
	}

}
