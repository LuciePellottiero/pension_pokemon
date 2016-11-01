package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.AnimalType;
import animaux.AbstractAnimal.Sexe;

public class Ours extends Mammifere{

	public static final String OURS_CRI = "Grohar";
	public static final int OURS_SANTE_MAX = 90;
	public static final int OURS_SEUIL_SOMMEIL = 60;
	public static final int OURS_SEUIL_FAIM = 150;
	public static final int OURS_TEMPS_GESTATION = 49;
	public static final float OURS_BEBE_POIDS = 10f;
	public static final float OURS_BEBE_TAILLE = 0.2f;
	
	public Ours(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Ours", null, nom, sexe, poids, taille, age, OURS_CRI, OURS_SANTE_MAX, OURS_SEUIL_SOMMEIL, OURS_SEUIL_FAIM, OURS_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.NORMAL);
		
		this.setTypes(types);
	}

	public Ours(String nom, Sexe sexe, Ours ours) {
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
		if(sexe == Sexe.FEMELLE){
			System.out.println(this.getNom() + " met bas.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
		}
		
		// TODO : rendre sexe random
		return new Ours(nom, Sexe.MALE, this);
	}
}
