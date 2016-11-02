package animaux;

import animaux.AbstractAnimal.Sexe;

public abstract class AnimalFactory {
	
	
	public static AbstractAnimal createAnimal(final String race, final String name, final Sexe sexe) throws Exception {
		switch(race) {
			case "Aigle":
				return new Aigle(name, sexe, (int) Aigle.AIGLE_POIDS_BEBE, (int) Aigle.AIGLE_BEBE_TAILLE, 1);
			case "Baleine":
				return new Baleine(name, sexe, (int) Baleine.BALEINE_BEBE_POIDS, (int) Baleine.BALEINE_BEBE_TAILLE, 1);
			case "Loup":
				return new Loup(name, sexe, (int) Loup.LOUP_BEBE_POIDS, (int) Loup.LOUP_BEBE_TAILLE, 1);
			case "Ours":
				return new Ours(name, sexe, (int) Ours.OURS_BEBE_POIDS, (int) Ours.OURS_BEBE_TAILLE, 1);
			case "Pingouin":
				return new Pingouin(name, sexe, (int) Pingouin.PINGOUIN_BEBE_POIDS, (int) Pingouin.PINGOUIN_BEBE_TAILLE, 1);
			case "Poisson rouge":
				return new PoissonRouge(name, sexe, (int) PoissonRouge.POISSON_ROUGE_BEBE_POIDS, (int) PoissonRouge.POISSON_ROUGE_BEBE_TAILLE, 1);
			case "Requin":
				return new Requin(name, sexe, (int) Requin.REQUIN_BEBE_POIDS, (int) Requin.REQUIN_BEBE_TAILLE, 1);
			case "Tigre":
				return new Tigre(name, sexe, (int) Tigre.TIGRE_BEBE_POIDS, (int) Tigre.TIGRE_BEBE_TAILLE, 1);
			default: 
				throw new Exception("Unknown race");
		}
	}
}
