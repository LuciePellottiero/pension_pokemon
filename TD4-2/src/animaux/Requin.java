package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.AnimalType;

public class Requin extends Autre implements Marin{
	
	public static final String REQUIN_CRI = "Tintan, tintan, tintantantant";
	public static final int REQUIN_SANTE_MAX = 100;
	public static final int REQUIN_SEUIL_SOMMEIL = 80;
	public static final int REQUIN_SEUIL_FAIM = 70;
	public static final int REQUIN_TEMPS_GESTATION = 380;
	public static final float REQUIN_BEBE_POIDS = 10f;
	public static final float REQUIN_BEBE_TAILLE = 15f;

	public Requin(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Requin", null, nom, sexe, poids, taille, age, REQUIN_CRI, REQUIN_SANTE_MAX, REQUIN_SEUIL_SOMMEIL, REQUIN_SEUIL_FAIM, REQUIN_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.MARIN);
		
		this.setTypes(types);
	}

	@Override
	public String Nager() {
		return this.getNom() + " nage a une allure inquietante";
	}

	@Override
	public float getBebePoids() {
		return REQUIN_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return REQUIN_BEBE_TAILLE;
	}

}
