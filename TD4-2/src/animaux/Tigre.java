package animaux;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Tigre extends AbstractPokemon implements TypeNormal{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 8810462180912771858L;
	
	public static final String TIGRE_CRI = "Miahou";
	public static final float TIGRE_BEBE_POIDS = 10f;
	public static final float TIGRE_BEBE_TAILLE = 1.5f;
	public final static IPokemon.PokemonType TYPES[] = {PokemonType.NORMAL};

	public Tigre(String nom, IPokemon.Sexe sexe, int poids, int taille, int age) {
		super("Tigre", new LinkedList<IPokemon.PokemonType>(Arrays.asList(TYPES)), nom, sexe, poids, taille, age, TIGRE_CRI);
	}

	public Tigre(String nom, IPokemon.Sexe sexe, Tigre tigre) {
		super(nom, sexe, tigre);
	}

	@Override
	public String Vagabonder() {
		return this.getNom() + " se deplace avec grace";
	}

	@Override
	public float getPoids() {
		return TIGRE_BEBE_POIDS;
	}

	@Override
	public float getTaille() {
		return TIGRE_BEBE_TAILLE;
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
			return new Tigre(nom, IPokemon.Sexe.MALE, this);
		}
		else{
			return new Tigre(nom, IPokemon.Sexe.FEMELLE, this);
		}
	}
	
}
