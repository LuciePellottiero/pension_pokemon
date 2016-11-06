package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Florizarre extends AbstractPokemon implements TypePlante{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 4308624581623051846L;
	
	public static final String FLORIZARRE_CRI = "flori flori zaaaarre";
	public static final float FLORIZARRE_POIDS = 100f;
	public static final float FLORIZARRE_TAILLE = 2f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.PLANTE, PokemonType.POISON};
	
	public Florizarre(String nom, IPokemon.Sexe sexe, float poids, float taille, int age, int level) {
		super("Florizarre", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, FLORIZARRE_CRI, level);
	}

	public Florizarre(String nom, IPokemon.Sexe sexe, Florizarre florizarre) {
		super(nom, sexe, florizarre);
	}

	@Override
	public float getPoids() {
		return FLORIZARRE_POIDS;
	}

	@Override
	public float getTaille() {
		return FLORIZARRE_TAILLE;
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
			return new Bulbizarre(nom, IPokemon.Sexe.MALE, Bulbizarre.BULBIZARRE_POIDS, Bulbizarre.BULBIZARRE_TAILLE, 0, 1);
		}
		else{
			return new Bulbizarre(nom, IPokemon.Sexe.FEMELLE, Bulbizarre.BULBIZARRE_POIDS, Bulbizarre.BULBIZARRE_TAILLE, 0, 1);
		}
	}

	@Override
	public AbstractPokemon evoluer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canEvolved() {
		return false;
	}
}
