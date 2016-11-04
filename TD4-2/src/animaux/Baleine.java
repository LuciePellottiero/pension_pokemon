package animaux;

import java.util.Collection;
import java.util.LinkedList;

public class Baleine extends Mammifere implements Marin{
	
	public final static String BALEINE_CRI = "Lalala";
	public final static int BALEINE_TEMPS_GESTATION = 365;
	public final static float BALEINE_BEBE_POIDS = 1000f;
	public final static float BALEINE_BEBE_TAILLE = 5f;
	
	public Baleine(final String nom, Sexe sexe, int poids, int taille, int age) {
		super("Baleine", null, nom, sexe, poids, taille, age, BALEINE_CRI, BALEINE_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.MARIN);
		
		this.setTypes(types);
	}
	
	public Baleine(final String nom, final Sexe sexe, final Baleine baleine) {
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
		if(sexe == Sexe.FEMELLE){
			System.out.println(this.getNom() + " met bas.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas mettre bas, abrutit !");
		}
		
		// TODO : rendre sexe random
		return new Baleine(nom, Sexe.MALE, this);
	}

}
