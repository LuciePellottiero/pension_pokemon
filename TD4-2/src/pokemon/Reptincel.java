package pokemon;

import java.util.Collection;
import java.util.LinkedList;

import pokemon.AbstractPokemon.AnimalType;

public class Reptincel extends Mammifere implements Feu{
	
	public static final String REPTINCEL_CRI = "Reptincel";
	public static final int REPTINCEL_SANTE_MAX = 95;
	public static final int REPTINCEL_SEUIL_SOMMEIL = 65;
	public static final int REPTINCEL_SEUIL_FAIM = 80;
	public static final int REPTINCEL_TEMPS_GESTATION = 105;
	public static final float REPTINCEL_BEBE_POIDS = 10f;
	public static final float REPTINCEL_BEBE_TAILLE = 15f;

	public Reptincel(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Reptincel", null, nom, sexe, poids, taille, age, REPTINCEL_CRI, REPTINCEL_SANTE_MAX, REPTINCEL_SEUIL_SOMMEIL, REPTINCEL_SEUIL_FAIM, REPTINCEL_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.FEU);
		
		this.setTypes(types);
	}

	@Override
	public String LanceFlemme() {
		return this.getNom() + " se deplace avec grace";
	}

	@Override
	public float getBebePoids() {
		return REPTINCEL_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return REPTINCEL_BEBE_TAILLE;
	}
	
}
