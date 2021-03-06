package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Requin extends Autre implements Marin{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 1748288755320168156L;
	
	public static final String REQUIN_CRI = "Tintan tintan tintantantant";
	public static final int REQUIN_SANTE_MAX = 100;
	public static final int REQUIN_SEUIL_SOMMEIL = 80;
	public static final int REQUIN_SEUIL_FAIM = 70;
	public static final int REQUIN_TEMPS_GESTATION = 380;
	public static final float REQUIN_BEBE_POIDS = 10f;
	public static final float REQUIN_BEBE_TAILLE = 15f;
	public final static IAnimal.AnimalType TYPES[] = {AnimalType.MARIN};

	public Requin(String nom, IAnimal.Sexe sexe, int poids, int taille, int age) {
		super("Requin", new LinkedList<IAnimal.AnimalType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, REQUIN_CRI, REQUIN_TEMPS_GESTATION);
	}

	public Requin(String nom, IAnimal.Sexe sexe, Requin requin) {
		super(nom, sexe, requin);
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
	
	@Override
	public AbstractAnimal pondre(final String nom) throws Exception {
		if(sexe == IAnimal.Sexe.FEMELLE){
			System.out.println(this.getNom() + " pond.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
		}
		
		int random = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if (random == 0){
			return new Requin(nom, IAnimal.Sexe.MALE, this);
		}
		else{
			return new Requin(nom, IAnimal.Sexe.FEMELLE, this);
		}
	}

}
