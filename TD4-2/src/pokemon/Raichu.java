package pokemon;

import java.util.Collection;
import java.util.LinkedList;

public class Raichu extends AbstractPokemon implements Electrique{

	public static final String RAICHU_CRI = "Raichu";
	public static final int RAICHU_SANTE_MAX = 50;
	public static final int RAICHU_SEUIL_SOMMEIL = 65;
	public static final int RAICHU_SEUIL_FAIM = 45;
	public static final int RAICHU_TEMPS_GESTATION = 29;
	public static final float RAICHU_BEBE_POIDS = 2f;
	public static final float RAICHU_BEBE_TAILLE = 0.02f;
	
	public Raichu(String nom, Sexe sexe, int poids, int taille, int age) {
		super("Raichu", null, nom, sexe, poids, taille, age, RAICHU_CRI, RAICHU_SANTE_MAX, RAICHU_SEUIL_SOMMEIL, RAICHU_SEUIL_FAIM, RAICHU_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.ELECTRIQUE);
		
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
	public float getBebePoids() {
		return RAICHU_BEBE_POIDS;
	}

	@Override
	public float getBebeTaille() {
		return RAICHU_BEBE_TAILLE;
	}

}
