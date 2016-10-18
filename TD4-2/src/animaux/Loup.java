package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.AnimalType;

public class Loup extends Mammifere implements Vagabondant{
	
	public final static String LOUP_CRI = "Ahouuuuuu";
	public final static int LOUP_MAX_SANTE = 80;
	public final static int LOUP_SEUIL_SOMMEIL = 70;
	public final static int LOUP_SEUIL_FAIM = 42;
	public final static int LOUP_TEMPS_GESTATION = 60;
	public final static float LOUP_BEBE_POIDS = 0.5f;
	public final static float LOUP_BEBE_TAILLE = 0.3f;

	public Loup(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Loup", null, nom, sexe, poids, taille, age, LOUP_CRI, LOUP_MAX_SANTE, LOUP_SEUIL_SOMMEIL, LOUP_SEUIL_FAIM, LOUP_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.VAGABONDANT);
		
		this.setTypes(types);
	}

	@Override
	public String Vagabonder() {
		return this.getNom() + " vagabonde tranquillement";
	}

	@Override
	public float getBebePoids() {
		return LOUP_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return LOUP_BEBE_TAILLE;
	}
	
}
