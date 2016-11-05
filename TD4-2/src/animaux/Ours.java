package animaux;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import animaux.IAnimal.AnimalType;
import animaux.IAnimal.Sexe;

public class Ours extends Mammifere{

	public static final String OURS_CRI = "Grohar";
	public static final int OURS_TEMPS_GESTATION = 49;
	public static final float OURS_BEBE_POIDS = 10f;
	public static final float OURS_BEBE_TAILLE = 0.2f;
	public final static IAnimal.AnimalType TYPES[] = {AnimalType.NORMAL};
	
	public Ours(String nom, IAnimal.Sexe sexe, int poids, int taille, int age) {
		super("Ours", new LinkedList<IAnimal.AnimalType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, OURS_CRI, OURS_TEMPS_GESTATION);
	}

	public Ours(String nom, IAnimal.Sexe sexe, Ours ours) {
		super(nom, sexe, ours);
	}

	@Override
	public float getBebePoids() {
		return OURS_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return OURS_BEBE_TAILLE;
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
			return new Ours(nom, IAnimal.Sexe.MALE, this);
		}
		else{
			return new Ours(nom, IAnimal.Sexe.FEMELLE, this);
		}
	}
}
