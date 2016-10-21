package pokemon;

import java.util.Collection;
import java.util.LinkedList;

import pokemon.AbstractPokemon.AnimalType;

public class Carapuce extends AbstractPokemon implements Eau{
	
	public static final String CARAPUCE_CRI = "Carapuce";
	public static final int CARAPUCE_SANTE_MAX = 100;
	public static final int CARAPUCE_SEUIL_SOMMEIL = 80;
	public static final int CARAPUCE_SEUIL_FAIM = 70;
	public static final int CARAPUCE_TEMPS_GESTATION = 380;
	public static final float CARAPUCE_BEBE_POIDS = 10f;
	public static final float CARAPUCE_BEBE_TAILLE = 15f;

	public Carapuce(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Carapuce", null, nom, sexe, poids, taille, age, CARAPUCE_CRI, CARAPUCE_SANTE_MAX, CARAPUCE_SEUIL_SOMMEIL, CARAPUCE_SEUIL_FAIM, CARAPUCE_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.EAU);
		
		this.setTypes(types);
	}

	@Override
	public String PistoletAO() {
		return this.getNom() + " nage a une allure inquietante";
	}

	@Override
	public float getBebePoids() {
		return CARAPUCE_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return CARAPUCE_BEBE_TAILLE;
	}

}
