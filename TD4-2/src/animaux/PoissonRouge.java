package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.AnimalType;

public class PoissonRouge extends Autre implements Marin{

	public static final String POISSON_ROUGE_CRI = "Bloubloup";
	public static final int POISSON_ROUGE_SANTE_MAX = 10;
	public static final int POISSON_ROUGE_SEUIL_SOMMEIL = 70;
	public static final int POISSON_ROUGE_SEUIL_FAIM = 65;
	public static final int POISSON_ROUGE_TEMPS_GESTATION = 4;
	public static final float POISSON_ROUGE_BEBE_POIDS = 0.0001f;
	public static final float POISSON_ROUGE_BEBE_TAILLE = 0.0002f;
	
	public PoissonRouge(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Poisson rouge", null, nom, sexe, poids, taille, age, POISSON_ROUGE_CRI, POISSON_ROUGE_SANTE_MAX, POISSON_ROUGE_SEUIL_SOMMEIL, POISSON_ROUGE_SEUIL_FAIM, POISSON_ROUGE_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.MARIN);
		
		this.setTypes(types);
	}

	@Override
	public String Nager() {
		return this.getNom() + " nage un peu ridiculement";
	}

	@Override
	public float getBebePoids() {
		return POISSON_ROUGE_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return POISSON_ROUGE_BEBE_TAILLE;
	}

}
