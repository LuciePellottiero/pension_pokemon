package animaux;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import animaux.IAnimal.AnimalType;
import animaux.IAnimal.Sexe;

public class Baleine extends Mammifere implements Marin{
	
	public final static String BALEINE_CRI = "Lalala";
	public final static int BALEINE_TEMPS_GESTATION = 365;
	public final static float BALEINE_BEBE_POIDS = 1000f;
	public final static float BALEINE_BEBE_TAILLE = 5f;
	public final static IAnimal.AnimalType TYPES[] = {AnimalType.MARIN};
	
	public Baleine(final String nom, IAnimal.Sexe sexe, int poids, int taille, int age) {
		super("Baleine", new LinkedList<IAnimal.AnimalType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, BALEINE_CRI, BALEINE_TEMPS_GESTATION);
	}
	
	public Baleine(final String nom, final IAnimal.Sexe sexe, final Baleine baleine) {
		super(nom, sexe, baleine);
	}
	
	@Override
	public String Nager() {
		return this.getNom() + " nage calmement";
	}

	@Override
	public float getBebePoids() {
		return BALEINE_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return BALEINE_BEBE_TAILLE;
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
			return new Baleine(nom, IAnimal.Sexe.MALE, this);
		}
		else{
			return new Baleine(nom, IAnimal.Sexe.FEMELLE, this);
		}
	}

}
