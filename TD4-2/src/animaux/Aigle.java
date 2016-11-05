package animaux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Aigle extends Autre implements Volant{
	
	public final static String AIGLE_CRI = "Kluh";
	public final static int AIGLE_TEMPS_GESTATION = 40;
	public final static float AIGLE_POIDS_BEBE = 0.2f;
	public final static float AIGLE_BEBE_TAILLE = 0.01f;
	public final static AnimalType[] TYPES = {AnimalType.VOLANT};

	public Aigle(final String nom, final IAnimal.Sexe sexe, final int poids, final int taille, final int age) {
		super("Aigle", new LinkedList<IAnimal.AnimalType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, AIGLE_CRI, AIGLE_TEMPS_GESTATION);
	}

	public Aigle(String nom, IAnimal.Sexe sexe, Aigle aigle) {
		super(nom, sexe, aigle);
	}

	@Override
	public String Voler() {
		return this.getNom() + " s'envole majestueusement vers d'autres cieux";
		
	}

	@Override
	public float getBebePoids() {
		return AIGLE_POIDS_BEBE;
	}

	@Override
	public float getBebeTaille() {
		return AIGLE_BEBE_TAILLE;
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
			return new Aigle(nom, IAnimal.Sexe.MALE, this);
		}
		else{
			return new Aigle(nom, IAnimal.Sexe.FEMELLE, this);
		}
	}

}
