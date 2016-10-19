package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.AnimalType;

public class Ours extends Mammifere{

	public static final String OURS_CRI = "Grohar";
	public static final int OURS_SANTE_MAX = 90;
	public static final int OURS_SEUIL_SOMMEIL = 60;
	public static final int OURS_SEUIL_FAIM = 150;
	public static final int OURS_TEMPS_GESTATION = 49;
	public static final float OURS_BEBE_POIDS = 10f;
	public static final float OURS_BEBE_TAILLE = 0.2f;
	
	public Ours(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Ours", null, nom, sexe, poids, taille, age, OURS_CRI, OURS_SANTE_MAX, OURS_SEUIL_SOMMEIL, OURS_SEUIL_FAIM, OURS_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.NORMAL);
		
		this.setTypes(types);
	}

	@Override
	public float getBebePoids() {
		return OURS_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return OURS_BEBE_TAILLE;
	}
}
