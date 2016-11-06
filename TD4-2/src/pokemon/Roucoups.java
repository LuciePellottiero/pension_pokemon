package pokemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Roucoups extends AbstractPokemon implements TypeVol{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 1539152368906171554L;
	
	public final static String ROUCOUPS_CRI = "rourou roucooool";
	public final static float ROUCOUPS_POIDS = 30f;
	public final static float ROUCOUPS_TAILLE = 1.1f;
	public final static PokemonType[] TYPES = {PokemonType.VOL};

	public Roucoups(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Roucoups", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, ROUCOUPS_CRI, level);
	}

	public Roucoups(String nom, IPokemon.Sexe sexe, Roucoups roucoups) {
		super(nom, sexe, roucoups);
	}

	@Override
	public String Voler() {
		return this.getNom() + " s'envole majestueusement vers d'autres cieux";
		
	}

	@Override
	public float getPoids() {
		return ROUCOUPS_POIDS;
	}

	@Override
	public float getTaille() {
		return ROUCOUPS_TAILLE;
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
		return new Roucarnage(this.getNom(), this.getSexe(), Roucarnage.ROUCARNAGE_POIDS, Roucarnage.ROUCARNAGE_TAILLE, this.getAge(), this.getLevel());
	}

	@Override
	public boolean canEvolved() {
		if(this.getLevel() >= 36) {
			return true;
		}
		return false;
	}

}
