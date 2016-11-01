package animaux;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal.Sexe;

public class Pingouin extends Autre implements Marin, Volant{

	public static final String PINGOUIN_CRI = "Criahah";
	public static final int PINGOUIN_SANTE_MAX = 50;
	public static final int PINGOUIN_SEUIL_SOMMEIL = 65;
	public static final int PINGOUIN_SEUIL_FAIM = 45;
	public static final int PINGOUIN_TEMPS_GESTATION = 29;
	public static final float PINGOUIN_BEBE_POIDS = 2f;
	public static final float PINGOUIN_BEBE_TAILLE = 0.02f;
	
	public Pingouin(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Pingouin", null, nom, sexe, poids, taille, age, PINGOUIN_CRI, PINGOUIN_SANTE_MAX, PINGOUIN_SEUIL_SOMMEIL, PINGOUIN_SEUIL_FAIM, PINGOUIN_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.MARIN);
		types.add(AnimalType.VOLANT);
		
		this.setTypes(types);
	}

	public Pingouin(String nom, Sexe sexe, Pingouin pingouin) {
		super(nom, sexe, pingouin);
	}

	@Override
	public String Voler() {
		return this.getNom() + " vole, aussi etonnant que cela puisse paraitre";
	}

	@Override
	public String Nager() {
		return this.getNom() + " file dans l'eau";
	}

	@Override
	public float getBebePoids() {
		return PINGOUIN_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return PINGOUIN_BEBE_TAILLE;
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
		return new Pingouin(nom, Sexe.MALE, this);
	}

}
