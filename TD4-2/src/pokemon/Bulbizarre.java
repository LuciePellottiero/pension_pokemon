package pokemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Bulbizarre, pokemon de type plante. Il a une étrange graine plantée sur son dos. Elle grandit avec lui depuis la naissance.
 * @author Lucie
 *
 */
public class Bulbizarre extends AbstractPokemon implements TypePlante{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 3007740908533717611L;
	
	public final static String BULBIZARRE_CRI = "bulbi bulbi";
	public final static float BULBIZARRE_POIDS = 6.9f;
	public final static float BULBIZARRE_TAILLE = 0.7f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.PLANTE};

	public Bulbizarre(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Bulbizarre", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, BULBIZARRE_CRI, level);
	}

	public Bulbizarre(String nom, IPokemon.Sexe sexe, Bulbizarre bulbizarre) {
		super(nom, sexe, bulbizarre);
	}

	@Override
	public float getPoids() {
		return BULBIZARRE_POIDS;
	}

	@Override
	public float getTaille() {
		return BULBIZARRE_TAILLE;
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
			return new Bulbizarre(nom, IPokemon.Sexe.MALE, this);
		}
		else{
			return new Bulbizarre(nom, IPokemon.Sexe.FEMELLE, this);
		}
	}

	@Override
	public AbstractPokemon evoluer() {
		
		return new Herbizarre(this.getNom(), this.getSexe(), Herbizarre.HERBIZARRE_POIDS, Herbizarre.HERBIZARRE_TAILLE, this.getAge(), this.getLevel());
	}

	@Override
	public boolean canEvolved() {
		if(this.getLevel() >= 15) {
			return true;
		}
		return false;
	}

	@Override
	public String fouetLiane() {
		return this.getNom() + " agite maladroitement ses lianes";
	}
	
}
