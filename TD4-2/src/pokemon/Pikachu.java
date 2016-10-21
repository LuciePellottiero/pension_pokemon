package pokemon;

import java.util.Collection;
import java.util.LinkedList;

public class Pikachu extends Autre implements Electrique{
	
	public final static String PIKACHU_CRI = "Pikachu";
	public final static int PIKACHU_MAX_SANTE = 60;
	public final static int PIKACHU_SEUIL_SOMMEIL = 100;
	public final static int PIKACHU_SEUIL_FAIM = 40;
	public final static int PIKACHU_TEMPS_GESTATION = 40;
	public final static float PIKACHU_POIDS_BEBE = 0.2f;
	public final static float PIKACHU_BEBE_TAILLE = 0.01f;

	public Pikachu(final String nom, final Sexe sexe, final int poids, final int taille, final int age) {
		super("Pikachu", null, nom, sexe, poids, taille, age, PIKACHU_CRI, PIKACHU_MAX_SANTE, PIKACHU_SEUIL_SOMMEIL, PIKACHU_SEUIL_FAIM, PIKACHU_TEMPS_GESTATION);
		
		Collection<AnimalType> types = new LinkedList<AnimalType>();
		types.add(AnimalType.ELECTRIQUE);
		
		this.setTypes(types);
	}

	@Override
	public String Eclair() {
		return this.getNom() + " s'envole majestueusement vers d'autres cieux";
		
	}

	@Override
	public float getBebePoids() {
		return PIKACHU_POIDS_BEBE;
	}

	@Override
	public float getBebeTaille() {
		return PIKACHU_BEBE_TAILLE;
	}

}
