package animaux;

import java.io.Serializable;
import java.util.Collection;

import evenement.EvenementPokemonAction;
import evenement.EvenementPokemonTour;

public interface IPokemon extends Comparable<AbstractPokemon>, Serializable{
	enum PokemonType {
		VOL,
		EAU,
		NORMAL,
		PLANTE,
		ELECTRIK,
		GLACE,
		DRAGON,
		POISON;
	}
	enum Sexe {
		MALE("\u2642"),
		FEMELLE("\u2640");
		
		private final String sexe;
		
		private Sexe(final String sexe) {
			this.sexe = sexe;
		}
		
		public String toString() {
			return this.sexe;
		}
	}
	public String getRace();
	public String manger();
	public String emettreSon();
	public String etreSoigne();
	public String sendormir();
	public String seReveiller();
	public Collection<IPokemon.PokemonType> getTypes();
	public String getNom();
	public void setNom(String nom);
	public IPokemon.Sexe getSexe();
	public int getAge();
	public String viellir();
	public boolean isFaim();
	public boolean isDodo();
	public boolean isMalade();
	public void setSante(boolean malade);
	public float getPoids();
	public float getTaille();
	public String aFaim();
	public EvenementPokemonAction getEvenementAction();
	public EvenementPokemonTour getEvenementTour();
	public String tombeMalade();
	public AbstractPokemon pondre(final String nom) throws Exception;
	public AbstractPokemon evoluer();
	public boolean canEvolved();
	public void levelUp();
	public int getLevel();
}
