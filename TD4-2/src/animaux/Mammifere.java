package animaux;

import java.util.Collection;

public abstract class Mammifere extends AbstractAnimal{
	
	public Mammifere(
			final String race,
			final Collection<AnimalType> types,
			final String nom, 
			final Sexe sexe,
			final int poids, 
			final int taille, 
			final int age, 
			final String cri,
			final int tempsGestation) {
		super(race, types,  nom, sexe, poids, taille, age, cri, tempsGestation);
	}
	
	public Mammifere(final String nom, final Sexe sexe, final Mammifere animal) {
		super(nom, sexe, animal);
	}

	@Override
	public AbstractAnimal seReproduire(String nom) throws Exception {
		return this.MettreBas(nom);
	}
	public abstract AbstractAnimal MettreBas(final String nom) throws Exception;
}
