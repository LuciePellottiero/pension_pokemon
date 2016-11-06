package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Herbizarre extends AbstractPokemon implements TypePlante, TypePoison{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -7758874200330358160L;
	
	public static final String HERBIZARRE_CRI = "herbi herbizaaarre";
	public static final float HERBIZARRE_POIDS = 13f;
	public static final float HERBIZARRE_TAILLE = 1f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.PLANTE, PokemonType.POISON};
	
	public Herbizarre(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Herbizarre", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, HERBIZARRE_CRI, level);
	}

	public Herbizarre(String nom, IPokemon.Sexe sexe, Herbizarre herbizarre) {
		super(nom, sexe, herbizarre);
	}

	@Override
	public float getPoids() {
		return HERBIZARRE_POIDS;
	}

	@Override
	public float getTaille() {
		return HERBIZARRE_TAILLE;
	}
	
	@Override
	public AbstractPokemon pondre(final String nom) throws Exception {
		if(sexe == IPokemon.Sexe.FEMELLE){
			System.out.println(this.getNom() + " pond.");
		}
		else{
			System.out.println("Ce pokemon est un mâle, il ne peut pas pondre, abrutit !");
			throw new Exception("Ce pokemon est un mâle, il ne peut pas pondre, abrutit !");
		}
		
		int random = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if (random == 0){
			return new Bulbizarre(nom, IPokemon.Sexe.MALE, Bulbizarre.BULBIZARRE_POIDS, Bulbizarre.BULBIZARRE_TAILLE, 0, 1);
		}
		else{
			return new Bulbizarre(nom, IPokemon.Sexe.FEMELLE, Bulbizarre.BULBIZARRE_POIDS, Bulbizarre.BULBIZARRE_TAILLE, 0, 1);
		}
	}

	@Override
	public AbstractPokemon evoluer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canEvolved() {
		//TODO
		return false;
	}

}
