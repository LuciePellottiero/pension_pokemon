package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Roucool extends AbstractPokemon implements TypeVol{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 1539152368906171554L;
	
	public final static String ROUCOOL_CRI = "rourou roucooool";
	public final static float ROUCOOL_POIDS = 1.8f;
	public final static float ROUCOOL_TAILLE = 0.3f;
	public final static PokemonType[] TYPES = {PokemonType.VOL};

	public Roucool(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Roucool", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, ROUCOOL_CRI, level);
	}

	public Roucool(String nom, IPokemon.Sexe sexe, Roucool roucool) {
		super(nom, sexe, roucool);
	}

	@Override
	public String Voler() {
		return this.getNom() + " s'envole majestueusement vers d'autres cieux";
		
	}

	@Override
	public float getPoids() {
		return ROUCOOL_POIDS;
	}

	@Override
	public float getTaille() {
		return ROUCOOL_TAILLE;
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

	@Override
	public AbstractPokemon evoluer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canEvolved() {
		// TODO Auto-generated method stub
		return false;
	}

}
