package animaux;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import animaux.IAnimal.AnimalType;
import animaux.IAnimal.Sexe;

public class PoissonRouge extends Autre implements Marin{

	public static final String POISSON_ROUGE_CRI = "Bloubloup";
	public static final int POISSON_ROUGE_TEMPS_GESTATION = 4;
	public static final float POISSON_ROUGE_BEBE_POIDS = 0.0001f;
	public static final float POISSON_ROUGE_BEBE_TAILLE = 0.0002f;
	public final static IAnimal.AnimalType TYPES[] = {AnimalType.MARIN};
	
	public PoissonRouge(String nom, IAnimal.Sexe sexe, int poids, int taille, int age) {
		super("Poisson rouge", new LinkedList<IAnimal.AnimalType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, POISSON_ROUGE_CRI, POISSON_ROUGE_TEMPS_GESTATION);
	}

	public PoissonRouge(String nom, IAnimal.Sexe sexe, PoissonRouge poissonRouge) {
		super(nom, sexe, poissonRouge);
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

	@Override
	public AbstractAnimal pondre(final String nom) throws Exception {
		if(sexe == IAnimal.Sexe.FEMELLE){
			System.out.println(this.getNom() + "pond.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
		}
		
		int random = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if (random == 0){
			return new PoissonRouge(nom, IAnimal.Sexe.MALE, this);
		}
		else{
			return new PoissonRouge(nom, IAnimal.Sexe.FEMELLE, this);
		}
	}
}
