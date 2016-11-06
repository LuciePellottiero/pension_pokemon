package pokemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Magicarpe, pokemon de type eau. Autrefois, il était beaucoup plus puissant que cette créature minablement faible.
 * @author Lucie
 *
 */
public class Magicarpe extends AbstractPokemon implements TypeEau{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 6371399193106500530L;
	
	public static final String MAGICARPE_CRI = "Magi magicarpe";
	public static final float MAGICARPE_POIDS = 10f;
	public static final float MAGICARPE_TAILLE = 0.9f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.EAU};
	
	public Magicarpe(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Magicarpe", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, MAGICARPE_CRI, level);
	}

	public Magicarpe(String nom, IPokemon.Sexe sexe, Magicarpe magicarpe) {
		super(nom, sexe, magicarpe);
	}

	@Override
	public String nager() {
		return this.getNom() + " nage un peu ridiculement";
	}

	@Override
	public float getPoids() {
		return MAGICARPE_POIDS;
	}

	@Override
	public float getTaille() {
		return MAGICARPE_TAILLE;
	}

	@Override
	public AbstractPokemon pondre(final String nom) throws Exception {
		if(sexe == IPokemon.Sexe.FEMELLE){
			System.out.println(this.getNom() + "pond.");
		}
		else{
			System.out.println("Ce pokemon est un mâle, il ne peut pas pondre, abrutit !");
			throw new Exception("Ce pokemon est un mâle, il ne peut pas pondre, abrutit !");
		}
		
		int random = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if (random == 0){
			return new Magicarpe(nom, IPokemon.Sexe.MALE, this);
		}
		else{
			return new Magicarpe(nom, IPokemon.Sexe.FEMELLE, this);
		}
	}

	@Override
	public AbstractPokemon evoluer() {
		return new Leviator(this.getNom(), this.getSexe(), Leviator.LEVIATOR_POIDS, Leviator.LEVIATOR_TAILLE, this.getAge(), this.getLevel());
	}

	@Override
	public boolean canEvolved() {
		if(this.getLevel() >= 30) {
			return true;
		}
		return false;
	}
}
