package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import animaux.IPokemon.PokemonType;

public class Raichu extends AbstractPokemon implements TypeElectrik{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -1855601376502020034L;
	
	public static final String RAICHU_CRI = "rai raichu";
	public static final float RAICHU_POIDS = 30f;
	public static final float RAICHU_TAILLE = 0.8f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.ELECTRIK};

	public Raichu(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Raichu", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, RAICHU_CRI, level);
	}

	public Raichu(String nom, IPokemon.Sexe sexe, Raichu raichu) {
		super(nom, sexe, raichu);
	}

	@Override
	public float getPoids() {
		return RAICHU_POIDS;
	}

	@Override
	public float getTaille() {
		return RAICHU_TAILLE;
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
			return new Pikachu(nom, IPokemon.Sexe.MALE, Pikachu.PIKACHU_POIDS, Pikachu.PIKACHU_TAILLE, 0, 1);
		}
		else{
			return new Pikachu(nom, IPokemon.Sexe.FEMELLE, Pikachu.PIKACHU_POIDS, Pikachu.PIKACHU_TAILLE, 0, 1);
		}
	}

	@Override
	public AbstractPokemon evoluer() {
		return null;
	}

	@Override
	public boolean canEvolved() {
		return false;
	}
}
