package animaux;

import java.util.Collection;
import java.util.LinkedList;

public class PoissonRouge extends Autre implements Marin{

	public static final String POISSON_ROUGE_CRI = "Bloubloup";
	public static final int POISSON_ROUGE_TEMPS_GESTATION = 4;
	public static final float POISSON_ROUGE_BEBE_POIDS = 0.0001f;
	public static final float POISSON_ROUGE_BEBE_TAILLE = 0.0002f;
	
	public PoissonRouge(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Poisson rouge", null, nom, sexe, poids, taille, age, POISSON_ROUGE_CRI, POISSON_ROUGE_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.MARIN);
		
		this.setTypes(types);
	}

	public PoissonRouge(String nom, Sexe sexe, PoissonRouge poissonRouge) {
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
		if(sexe == Sexe.FEMELLE){
			System.out.println(this.getNom() + "pond.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
		}
		
		// TODO : rendre sexe random
		return new PoissonRouge(nom, Sexe.MALE, this);
	}
}
