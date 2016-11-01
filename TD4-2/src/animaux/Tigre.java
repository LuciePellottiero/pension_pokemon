package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.AnimalType;
import animaux.AbstractAnimal.Sexe;

public class Tigre extends Mammifere implements Vagabondant{
	
	public static final String TIGRE_CRI = "Miahou";
	public static final int TIGRE_SANTE_MAX = 95;
	public static final int TIGRE_SEUIL_SOMMEIL = 65;
	public static final int TIGRE_SEUIL_FAIM = 80;
	public static final int TIGRE_TEMPS_GESTATION = 105;
	public static final float TIGRE_BEBE_POIDS = 10f;
	public static final float TIGRE_BEBE_TAILLE = 15f;

	public Tigre(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Tigre", null, nom, sexe, poids, taille, age, TIGRE_CRI, TIGRE_SANTE_MAX, TIGRE_SEUIL_SOMMEIL, TIGRE_SEUIL_FAIM, TIGRE_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.VAGABONDANT);
		
		this.setTypes(types);
	}

	public Tigre(String nom, Sexe sexe, Tigre tigre) {
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
		if(sexe == Sexe.FEMELLE){
			System.out.println(this.getNom() + " met bas.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
		}
		
		// TODO : rendre sexe random
		return new Tigre(nom, Sexe.MALE, this);
	}
	
}
