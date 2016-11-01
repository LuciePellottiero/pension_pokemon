package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.Sexe;

public class Aigle extends Autre implements Volant{
	
	public final static String AIGLE_CRI = "Kluh";
	public final static int AIGLE_MAX_SANTE = 60;
	public final static int AIGLE_SEUIL_SOMMEIL = 100;
	public final static int AIGLE_SEUIL_FAIM = 40;
	public final static int AIGLE_TEMPS_GESTATION = 40;
	public final static float AIGLE_POIDS_BEBE = 0.2f;
	public final static float AIGLE_BEBE_TAILLE = 0.01f;

	public Aigle(final String nom, final Sexe sexe, final int poids, final int taille, final int age) {
		super("Aigle", null, nom, sexe, poids, taille, age, AIGLE_CRI, AIGLE_MAX_SANTE, AIGLE_SEUIL_SOMMEIL, AIGLE_SEUIL_FAIM, AIGLE_TEMPS_GESTATION);
		
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
	public AbstractAnimal Pondre(final String nom) throws Exception {
		if(sexe == Sexe.FEMELLE){
			System.out.println(this.getNom() + " met bas.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
		}
		
		// TODO : rendre sexe random
		return new Aigle(nom, Sexe.MALE, this);
	}

}
