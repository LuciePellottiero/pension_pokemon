package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Tigre extends Mammifere implements Vagabondant{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 8810462180912771858L;
	
	public static final String TIGRE_CRI = "Miahou";
	public static final int TIGRE_TEMPS_GESTATION = 105;
	public static final float TIGRE_BEBE_POIDS = 10f;
	public static final float TIGRE_BEBE_TAILLE = 1.5f;
	public final static IAnimal.AnimalType TYPES[] = {AnimalType.VAGABONDANT};

	public Tigre(String nom, IAnimal.Sexe sexe, int poids, int taille, int age) {
		super("Tigre", new LinkedList<IAnimal.AnimalType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, TIGRE_CRI, TIGRE_TEMPS_GESTATION);
	}

	public Tigre(String nom, IAnimal.Sexe sexe, Tigre tigre) {
		super(nom, sexe, tigre);
	}

	@Override
	public String Vagabonder() {
		return this.getNom() + " se deplace avec grace";
	}

	@Override
	public float getBebePoids() {
		return TIGRE_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return TIGRE_BEBE_TAILLE;
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
			return new Tigre(nom, IAnimal.Sexe.MALE, this);
		}
		else{
			return new Tigre(nom, IAnimal.Sexe.FEMELLE, this);
		}
	}
	
}
