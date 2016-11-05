package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Loup extends Mammifere implements Vagabondant{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 3007740908533717611L;
	
	public final static String LOUP_CRI = "Ahouuuuuu";
	public final static int LOUP_TEMPS_GESTATION = 60;
	public final static float LOUP_BEBE_POIDS = 0.5f;
	public final static float LOUP_BEBE_TAILLE = 0.3f;
	public final static IAnimal.AnimalType TYPES[] = {AnimalType.VAGABONDANT};

	public Loup(String nom, IAnimal.Sexe sexe, int poids, int taille, int age) {
		super("Loup", new LinkedList<IAnimal.AnimalType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, LOUP_CRI, LOUP_TEMPS_GESTATION);
	}

	public Loup(String nom, IAnimal.Sexe sexe, Loup loup) {
		super(nom, sexe, loup);
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

	@Override
	public AbstractAnimal MettreBas(final String nom) throws Exception {
		if(sexe == IAnimal.Sexe.FEMELLE){
			System.out.println(this.getNom() + " met bas.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
		}
		
		int random = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if (random == 0){
			return new Loup(nom, IAnimal.Sexe.MALE, this);
		}
		else{
			return new Loup(nom, IAnimal.Sexe.FEMELLE, this);
		}
	}
	
}
