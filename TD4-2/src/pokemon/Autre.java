package animaux;

import java.util.Collection;

import animaux.AbstractAnimal.Sexe;

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

	public void PondreOeufs(){
		if(sexe == Sexe.FEMELLE){
			System.out.println(this.getNom() + " pond un oeuf.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas pondre d'oeuf, abrutit !");
		}
	}
}
