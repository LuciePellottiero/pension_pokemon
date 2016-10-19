package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.AnimalType;

public class Baleine extends Mammifere implements Marin{
	
	public final static String BALEINE_CRI = "Lalala";
	public final static int BALEINE_MAX_SANTE = 150;
	public final static int BALEINE_SEUIL_SOMMEIL = 500;
	public final static int BALEINE_SEUIL_FAIM = 100;
	public final static int BALEINE_TEMPS_GESTATION = 365;
	public final static float BALEINE_BEBE_POIDS = 1000f;
	public final static float BALEINE_BEBE_TAILLE = 5f;
	public Baleine(final String nom, Sexe sexe, int poids, int taille, int age) {
		super("Baleine", null, nom, sexe, poids, taille, age, BALEINE_CRI, BALEINE_MAX_SANTE, BALEINE_SEUIL_SOMMEIL, BALEINE_SEUIL_FAIM, BALEINE_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.MARIN);
		
		this.setTypes(types);
	}

	@Override
	public String Nager() {
		return this.getNom() + " nage calmement";
	}

	@Override
	public float getBebePoids() {
		return BALEINE_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return BALEINE_BEBE_TAILLE;
	}

}
