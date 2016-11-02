package animaux;

import java.util.Collection;

public abstract class Autre extends AbstractAnimal{

	public Autre(
			final String race, 
			final Collection<AnimalType> types,
			final String nom, 
			final Sexe sexe,
			final int poids, 
			final int taille, 
			final int age,
			final String cri,
			final int maxSante,
			final int seuilSommeil,
			final int seuilFaim,
			final int tempsGestation) {
		super(race, types, nom, sexe, poids, taille, age, cri, maxSante, seuilSommeil, seuilFaim, tempsGestation);
	}
	
	public Autre(final String nom, final Sexe sexe, final Autre animal) {
		super(nom, sexe, animal);
	}

	public abstract AbstractAnimal Pondre(final String nom) throws Exception;
}
