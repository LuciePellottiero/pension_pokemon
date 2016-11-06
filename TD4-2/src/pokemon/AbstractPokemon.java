package pokemon;

import java.io.Serializable;
import java.util.Collection;

import evenement.EvenementPokemonAction;
import evenement.EvenementPokemonTour;

public abstract class AbstractPokemon implements IPokemon, Serializable{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 3003146390313202310L;
	
	private final String race;
	private Collection<IPokemon.PokemonType> types;
	private String nom;
	protected final IPokemon.Sexe sexe;
	private float poids;
	private float taille;
	private int age;
	private boolean faim;
	private boolean dort;
	private boolean malade;
	private final String cri;
	private final EvenementPokemonAction action;
	private final EvenementPokemonTour tour;
	private int level;
	
	protected AbstractPokemon(
					final String race,
					final Collection<IPokemon.PokemonType> types,
					final String nom, 
					final IPokemon.Sexe sexe, 
					final float poids,
					final float taille,
					final int age,
					final String cri,
					final int level) {
		
		this.race = race;
		this.types = types;
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.cri = cri;
		this.faim = false;
		this.dort = false;
		this.malade = false;
		this.level = level;
		
		this.action = new EvenementPokemonAction(this);
		this.tour = new EvenementPokemonTour(this);
	}
	
	public AbstractPokemon(
			final String nom,
			final IPokemon.Sexe sexe,
			final AbstractPokemon animal) {
		this.race = animal.getRace();
		this.types = animal.getTypes();
		this.nom = nom;
		this.sexe = sexe;
		this.poids = animal.getPoids();
		this.taille = animal.getTaille();
		this.age = 0;
		this.cri = animal.cri;
		this.level = animal.getLevel();
		
		this.faim = false;
		this.dort = false;
		this.malade = false;
		
		this.action = new EvenementPokemonAction(this);
		this.tour = new EvenementPokemonTour(this);
	}
	
	@Override
	public EvenementPokemonAction getEvenementAction() {
		return this.action;
	}
	
	@Override
	public EvenementPokemonTour getEvenementTour() {
		return this.tour;
	}
	
	@Override
	public String getRace() {
		return this.race;
	}
	
	@Override
	public String manger(){
		if (!dort){
			if (this.faim == false) {
				return this.nom + " n'a pas faim" + System.lineSeparator();
			}
			this.faim = false;
			return this.nom + " a mangé" + System.lineSeparator();
		}
		return this.nom + " dort et ne peux pas manger" + System.lineSeparator();
	}
	
	@Override
	public String emettreSon(){
		return this.nom + " : " + this.cri;
		
	}
	
	@Override
	public String etreSoigne(){
		this.malade = false;
		return this.nom + " a ete soigné.";
	}
	
	@Override
	public String sendormir() {
		this.dort = true;
		return this.nom + " s'endort.";
	}
	
	@Override
	public String aFaim() {
		this.faim = true;
		return this.nom + " a faim.";
	}
	
	@Override
	public String tombeMalade() {
		this.malade = true;
		return this.nom + " est malade.";
	}
	
	@Override
	public String seReveiller(){
		if(!this.dort) {
			return this.nom + " ne dormait pas.";
		}
		this.dort = false;
		return this.nom + " s'est reveillé.";
	}

	@Override
	public Collection<IPokemon.PokemonType> getTypes() {
		return this.types;
	}
	
	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public IPokemon.Sexe getSexe() {
		return sexe;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String viellir() {
		++this.age;
		return this.nom + " a veilli";
	}

	@Override
	public boolean isFaim() {
		return faim;
	}

	@Override
	public boolean isDodo() {
		return dort;
	}
	
	@Override
	public boolean isMalade() {
		return malade;
	}

	@Override
	public void setSante(boolean malade) {
		this.malade = malade;
	}
	
	@Override
	public abstract float getPoids();
	
	@Override
	public abstract float getTaille();
	
	@Override
	public void levelUp() {
		this.level++;
	}
	
	@Override
	public int getLevel(){
		return this.level;
	}

	@Override
	public String toString() {
		return race + " " + nom + " : " + sexe + ", level : " + level + ", " + poids + "Kg, " + taille + "m, " + age
				+ " ans, " + (malade ? "malade, " : "en bonne santé, ") + (faim ? "affamé, " : "") + (dort ? "dort, " : "reveillé, ") + 
				"cri = " + cri;
	}
	
	@Override
	public int compareTo(AbstractPokemon o) {
		return this.getNom().compareTo(o.getNom());
	}

	public abstract AbstractPokemon pondre(final String nom) throws Exception;
}
