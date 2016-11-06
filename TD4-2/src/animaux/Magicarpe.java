package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

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
		super("Poisson rouge", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, MAGICARPE_CRI, level);
	}

	public Magicarpe(String nom, IPokemon.Sexe sexe, Magicarpe magicarpe) {
		super(nom, sexe, magicarpe);
	}

	@Override
	public String Nager() {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canEvolved() {
		// TODO Auto-generated method stub
		return false;
	}
}
