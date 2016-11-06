package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Leviator extends AbstractPokemon implements TypeEau, TypeDragon{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 1748288755320168156L;
	
	public static final String LEVIATOR_CRI = "tor leviatoooor";
	public static final float LEVIATOR_POIDS = 235f;
	public static final float LEVIATOR_TAILLE = 6.5f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.EAU, PokemonType.DRAGON};

	public Leviator(String nom, IPokemon.Sexe sexe, float poids, float taille, int age) {
		super("Leviator", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, LEVIATOR_CRI);
	}

	public Leviator(String nom, IPokemon.Sexe sexe, Leviator leviator) {
		super(nom, sexe, leviator);
	}

	@Override
	public String Nager() {
		return this.getNom() + " nage a une allure inquietante";
	}

	@Override
	public float getPoids() {
		return LEVIATOR_POIDS;
	}

	@Override
	public float getTaille() {
		return LEVIATOR_TAILLE;
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
			return new Magicarpe(nom, IPokemon.Sexe.MALE, Magicarpe.MAGICARPE_POIDS, Magicarpe.MAGICARPE_TAILLE, 0);
		}
		else{
			return new Magicarpe(nom, IPokemon.Sexe.FEMELLE, Magicarpe.MAGICARPE_POIDS, Magicarpe.MAGICARPE_TAILLE, 0);
		}
	}

}
