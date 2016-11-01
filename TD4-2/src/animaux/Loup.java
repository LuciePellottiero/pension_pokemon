package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.AnimalType;
import animaux.AbstractAnimal.Sexe;

public class Loup extends Mammifere implements Vagabondant{
	
	public final static String LOUP_CRI = "Ahouuuuuu";
	public final static int LOUP_MAX_SANTE = 80;
	public final static int LOUP_SEUIL_SOMMEIL = 70;
	public final static int LOUP_SEUIL_FAIM = 42;
	public final static int LOUP_TEMPS_GESTATION = 60;
	public final static float LOUP_BEBE_POIDS = 0.5f;
	public final static float LOUP_BEBE_TAILLE = 0.3f;

	public Loup(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Loup", null, nom, sexe, poids, taille, age, LOUP_CRI, LOUP_MAX_SANTE, LOUP_SEUIL_SOMMEIL, LOUP_SEUIL_FAIM, LOUP_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.VAGABONDANT);
		
		this.setTypes(types);
	}

	public Loup(String nom, Sexe sexe, Loup loup) {
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
		if(sexe == Sexe.FEMELLE){
			System.out.println(this.getNom() + " met bas.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
		}
		
		// TODO : rendre sexe random
		return new Loup(nom, Sexe.MALE, this);
	}
	
}
