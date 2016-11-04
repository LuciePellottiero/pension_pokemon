package animaux;

import java.util.Collection;
import java.util.LinkedList;

public class Aigle extends Autre implements Volant{
	
	public final static String AIGLE_CRI = "Kluh";
	public final static int AIGLE_TEMPS_GESTATION = 40;
	public final static float AIGLE_POIDS_BEBE = 0.2f;
	public final static float AIGLE_BEBE_TAILLE = 0.01f;

	public Aigle(final String nom, final Sexe sexe, final int poids, final int taille, final int age) {
		super("Aigle", null, nom, sexe, poids, taille, age, AIGLE_CRI, AIGLE_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.VOLANT);
		
		this.setTypes(types);
	}

	public Aigle(String nom, Sexe sexe, Aigle aigle) {
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
		if(sexe == Sexe.FEMELLE){
			System.out.println(this.getNom() + " pond.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
		}
		
		// TODO : rendre sexe random
		return new Aigle(nom, Sexe.MALE, this);
	}

}
