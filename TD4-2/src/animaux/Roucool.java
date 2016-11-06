package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Roucool extends AbstractPokemon implements TypeVol{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 1539152368906171554L;
	
	public final static String AIGLE_CRI = "Kluh";
	public final static float AIGLE_POIDS_BEBE = 0.2f;
	public final static float AIGLE_BEBE_TAILLE = 0.01f;
	public final static PokemonType[] TYPES = {PokemonType.VOL};

	public Roucool(String nom, IPokemon.Sexe sexe, float poids, float taille, int age) {
		super("Aigle", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, AIGLE_CRI);
	}

	public Roucool(String nom, IPokemon.Sexe sexe, Roucool aigle) {
		super(nom, sexe, aigle);
	}

	@Override
	public String Voler() {
		return this.getNom() + " s'envole majestueusement vers d'autres cieux";
		
	}

	@Override
	public float getPoids() {
		return AIGLE_POIDS_BEBE;
	}

	@Override
	public float getTaille() {
		return AIGLE_BEBE_TAILLE;
	}
	
	@Override
	public AbstractPokemon pondre(final String nom) throws Exception {
		if(sexe == IPokemon.Sexe.FEMELLE){
			System.out.println(this.getNom() + " pond.");
		}
		else{
			System.out.println("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
			throw new Exception("Cet animal est un mâle, il ne peut pas pondre, abrutit !");
		}
		
		int random = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if (random == 0){
			return new Roucool(nom, IPokemon.Sexe.MALE, this);
		}
		else{
			return new Roucool(nom, IPokemon.Sexe.FEMELLE, this);
		}
	}

}
