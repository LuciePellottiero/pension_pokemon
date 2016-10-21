package pokemon;

import java.util.Collection;
import java.util.LinkedList;

public class Raichu extends AbstractPokemon implements Electrique{

	public static final String RAICHU_CRI = "Raichu";
	public static final int RAICHU_SANTE_MAX = 50;
	public static final int RAICHU_SEUIL_SOMMEIL = 65;
	public static final int RAICHU_SEUIL_FAIM = 45;
	public static final int RAICHU_TEMPS_GESTATION = 29;
	public static final float RAICHU_EVO_POIDS = 2f;
	public static final float RAICHU_EVO_TAILLE = 0.02f;
	
	public Raichu(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Raichu", null, nom, sexe, poids, taille, age, RAICHU_CRI, RAICHU_SANTE_MAX, RAICHU_SEUIL_SOMMEIL, RAICHU_SEUIL_FAIM, RAICHU_TEMPS_GESTATION);
		
		Collection<PokemonType> types = new LinkedList<PokemonType>();
		types.add(PokemonType.ELECTRIQUE);
		
		this.setTypes(types);
	}

	/*@Override
	public String Voler() {
		return this.getNom() + " vole, aussi etonnant que cela puisse paraitre";
	}*/

	@Override
	public String Eclair() {
		return this.getNom() + " utilise ECLAIR !";
	}

	@Override
	public float getEvoPoids() {
		return RAICHU_EVO_POIDS;
	}

	@Override
	public float getEvoTaille() {
		return RAICHU_EVO_TAILLE;
	}

}
