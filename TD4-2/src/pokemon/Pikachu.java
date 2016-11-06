package pokemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Pikachu, pokemon de type electrik. Quand plusieurs de ces POKéMON se réunissent, ils provoquent de gigantesques orages.
 * @author Lucie
 *
 */
public class Pikachu extends AbstractPokemon implements TypeElectrik{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 8810462180912771858L;
	
	public static final String PIKACHU_CRI = "pika pika";
	public static final float PIKACHU_POIDS = 6f;
	public static final float PIKACHU_TAILLE = 0.4f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.ELECTRIK};

	public Pikachu(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Pikachu", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, PIKACHU_CRI, level);
	}

	public Pikachu(String nom, IPokemon.Sexe sexe, Pikachu pikachu) {
		super(nom, sexe, pikachu);
	}

	@Override
	public float getPoids() {
		return PIKACHU_POIDS;
	}

	@Override
	public float getTaille() {
		return PIKACHU_TAILLE;
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
			return new Pikachu(nom, IPokemon.Sexe.MALE, this);
		}
		else{
			return new Pikachu(nom, IPokemon.Sexe.FEMELLE, this);
		}
	}

	@Override
	public AbstractPokemon evoluer() {
		return new Raichu(this.getNom(), this.getSexe(), Raichu.RAICHU_POIDS, Raichu.RAICHU_TAILLE, this.getAge(), this.getLevel());
	}

	@Override
	public boolean canEvolved() {
		if(this.getLevel() >= 30) {
			return true;
		}
		return false;
	}

	@Override
	public String foudroyer() {
		return this.getNom() + " provoque de petits éclairs";
	}
	
}
