package animaux;

import java.util.Collection;

public abstract class Autre extends AbstractAnimal{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 3647827102634278508L;

	public Autre(
			final String race, 
			final Collection<IAnimal.AnimalType> types,
			final String nom, 
			final IAnimal.Sexe sexe,
			final int poids, 
			final int taille, 
			final int age,
			final String cri,
			final int tempsGestation) {
		super(race, types, nom, sexe, poids, taille, age, cri, tempsGestation);
	}
	
	public Autre(final String nom, final IAnimal.Sexe sexe, final Autre animal) {
		super(nom, sexe, animal);
	}
	
	@Override
	public AbstractAnimal seReproduire(String nom) throws Exception {
		return this.pondre(nom);
	}

	public abstract AbstractAnimal pondre(final String nom) throws Exception;
}
