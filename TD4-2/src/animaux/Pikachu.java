package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Pikachu extends AbstractPokemon implements TypeElectrik{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 8810462180912771858L;
	
	public static final String PIKACHU_CRI = "pika pika";
	public static final float PIKACHU_POIDS = 6f;
	public static final float PIKACHU_TAILLE = 0.4f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.ELECTRIK};

	public Pikachu(String nom, IPokemon.Sexe sexe, float poids, float taille, int age) {
		super("Pikachu", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, PIKACHU_CRI);
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
	
}
