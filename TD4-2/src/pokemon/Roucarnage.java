package pokemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Roucarnage extends AbstractPokemon implements TypeVol{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 1539152368906171554L;
	
	public final static String ROUCARNAGE_CRI = "roucarnaaaaaaage";
	public final static float ROUCARNAGE_POIDS = 1.8f;
	public final static float ROUCARNAGE_TAILLE = 0.3f;
	public final static PokemonType[] TYPES = {PokemonType.VOL};

	public Roucarnage(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Roucarnage", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, ROUCARNAGE_CRI, level);
	}

	public Roucarnage(String nom, IPokemon.Sexe sexe, Roucarnage roucarnage) {
		super(nom, sexe, roucarnage);
	}

	@Override
	public String Voler() {
		return this.getNom() + " s'envole majestueusement vers d'autres cieux";
		
	}

	@Override
	public float getPoids() {
		return ROUCARNAGE_POIDS;
	}

	@Override
	public float getTaille() {
		return ROUCARNAGE_TAILLE;
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
			return new Roucool(nom, IPokemon.Sexe.MALE, Roucool.ROUCOOL_POIDS, Roucool.ROUCOOL_TAILLE, 0, 1);
		}
		else{
			return new Roucool(nom, IPokemon.Sexe.FEMELLE, Roucool.ROUCOOL_POIDS, Roucool.ROUCOOL_TAILLE, 0, 1);
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
