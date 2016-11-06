package pokemon;

public abstract class PokemonFactory {
	
	
	public static AbstractPokemon createPokemon(final String race, final String name, final IPokemon.Sexe sexe) throws Exception {
		switch(race) {
			case "Roucool":
				return new Roucool(name, sexe, (int) Roucool.ROUCOOL_POIDS, (int) Roucool.ROUCOOL_TAILLE, 1, 1);
			case "Lokhlass":
				return new Lokhlass(name, sexe, (int) Lokhlass.LOKHLASS_POIDS, (int) Lokhlass.LOKHLASS_TAILLE, 1, 1);
			case "Bulbizarre":
				return new Bulbizarre(name, sexe, (int) Bulbizarre.BULBIZARRE_POIDS, (int) Bulbizarre.BULBIZARRE_TAILLE, 1, 1);
			case "Florizarre":
				return new Florizarre(name, sexe, (int) Florizarre.FLORIZARRE_POIDS, (int) Florizarre.FLORIZARRE_TAILLE, 1, 30);
			case "Herbizarre":
				return new Herbizarre(name, sexe, (int) Herbizarre.HERBIZARRE_POIDS, (int) Herbizarre.HERBIZARRE_TAILLE, 1,  15);
			case "Magicarpe":
				return new Magicarpe(name, sexe, (int) Magicarpe.MAGICARPE_POIDS, (int) Magicarpe.MAGICARPE_TAILLE, 1, 1);
			case "Leviator":
				return new Leviator(name, sexe, (int) Leviator.LEVIATOR_POIDS, (int) Leviator.LEVIATOR_TAILLE, 1, 30);
			case "Pikachu":
				return new Pikachu(name, sexe, (int) Pikachu.PIKACHU_POIDS, (int) Pikachu.PIKACHU_TAILLE, 1, 1);
			case "Roucoups":
				return new Roucoups(name, sexe, (int) Roucoups.ROUCOUPS_POIDS, (int) Roucoups.ROUCOUPS_TAILLE, 1, 18);
			case "Roucarnage":
				return new Roucarnage(name, sexe, (int) Roucarnage.ROUCARNAGE_POIDS, (int) Roucarnage.ROUCARNAGE_TAILLE, 1, 18);
			default: 
				throw new Exception("Unknown race");
		}
	}
}
