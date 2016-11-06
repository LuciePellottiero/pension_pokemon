package pokemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Lokhlass extends AbstractPokemon implements TypeEau, TypeGlace{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 2846029674344293648L;
	
	public final static String LOKHLASS_CRI = "lokhlaaaaaaaaaas";
	public final static float LOKHLASS_POIDS = 220f;
	public final static float LOKHLASS_TAILLE = 2.5f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.EAU, PokemonType.GLACE};
	
	public Lokhlass(final String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Lokhlass", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, LOKHLASS_CRI, level);
	}
	
	public Lokhlass(final String nom, final IPokemon.Sexe sexe, final Lokhlass lokhlass) {
		super(nom, sexe, lokhlass);
	}
	
	@Override
	public String Nager() {
		return this.getNom() + " nage calmement";
	}

	@Override
	public float getPoids() {
		return LOKHLASS_POIDS;
	}

	@Override
	public float getTaille() {
		return LOKHLASS_TAILLE;
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
			return new Lokhlass(nom, IPokemon.Sexe.MALE, this);
		}
		else{
			return new Lokhlass(nom, IPokemon.Sexe.FEMELLE, this);
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
