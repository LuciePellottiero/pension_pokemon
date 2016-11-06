package animaux;

public abstract class PokemonFactory {
	
	
	public static AbstractPokemon createPokemon(final String race, final String name, final IPokemon.Sexe sexe) throws Exception {
		switch(race) {
			case "Roucool":
				return new Roucool(name, sexe, (int) Roucool.AIGLE_POIDS_BEBE, (int) Roucool.AIGLE_BEBE_TAILLE, 1);
			case "Lokhlass":
				return new Lokhlass(name, sexe, (int) Lokhlass.LOKHLASS_POIDS, (int) Lokhlass.LOKHLASS_TAILLE, 1);
			case "Bulbizarre":
				return new Bulbizarre(name, sexe, (int) Bulbizarre.BULBIZARRE_POIDS, (int) Bulbizarre.BULBIZARRE_TAILLE, 1);
			case "Florizarre":
				return new Florizarre(name, sexe, (int) Florizarre.FLORIZARRE_BEBE_POIDS, (int) Florizarre.FLORIZARRE_BEBE_TAILLE, 1);
			case "Herbizarre":
				return new Herbizarre(name, sexe, (int) Herbizarre.HERBIZARRE_POIDS, (int) Herbizarre.HERBIZARRE_TAILLE, 1);
			case "Magicarpe":
				return new Magicarpe(name, sexe, (int) Magicarpe.MAGICARPE_POIDS, (int) Magicarpe.MAGICARPE_TAILLE, 1);
			case "Leviator":
				return new Leviator(name, sexe, (int) Leviator.LEVIATOR_POIDS, (int) Leviator.LEVIATOR_TAILLE, 1);
			case "Pikachu":
				return new Pikachu(name, sexe, (int) Pikachu.PIKACHU_POIDS, (int) Pikachu.PIKACHU_TAILLE, 1);
			default: 
				throw new Exception("Unknown race");
		}
	}
}
