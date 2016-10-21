package pokemon;

import java.util.Collection;

public abstract class AbstractPokemon {
	
	public static enum Sexe {
		MALE("\u2642"),
		FEMELLE("\u2640");
		
		private final String sexe;
		
		private Sexe(final String sexe) {
			this.sexe = sexe;
		}
	}
	
	public static enum PokemonType {
		EAU,
		ELECTRIQUE,
		FEU,
		PLANTE,
		VOL;
	}
	
	private final String race;
	private Collection<PokemonType> types;
	private String nom;
	protected final Sexe sexe;
	private float poids;
	private float taille;
	private int age;
	private int faim;
	private final int seuilFaim;
	private final int seuilSommeil;
	private int sommeil;
	private boolean dort;
	private int pv;
	private final int maxPv;
	private final String cri;
	private final int tempsGestation;
	
	protected AbstractPokemon(
					final String race,
					final Collection<PokemonType> types,
					final String nom, 
					final Sexe sexe, 
					final int poids,
					final int taille,
					final int age,
					final String cri, 
					final int maxPv, 
					final int seuilSommeil, 
					final int seuilFaim,
					final int tempsGestation) {
		
		this.race = race;
		this.types = types;
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.cri = cri;
		this.maxPv = maxPv;
		this.seuilSommeil = seuilSommeil;
		this.seuilFaim = seuilFaim;
		this.tempsGestation = tempsGestation;
		
		this.faim = 0;
		this.dort = false;
		this.pv = maxPv;
	}
	
	public AbstractPokemon(
			final String nom,
			final Sexe sexe,
			final AbstractPokemon pokemon) {
		this.race = pokemon.getRace();
		this.types = pokemon.getTypes();
		this.nom = nom;
		this.sexe = sexe;
		this.poids = pokemon.getEvoPoids();
		this.taille = pokemon.getEvoTaille();
		this.age = 0;
		this.cri = pokemon.cri;
		this.maxPv = pokemon.maxPv;
		this.seuilSommeil = pokemon.seuilSommeil;
		this.seuilFaim = pokemon.seuilFaim;
		this.tempsGestation = pokemon.tempsGestation;
		
		this.faim = 0;
		this.dort = false;
		this.pv = maxPv;
	}
	
	public String getRace() {
		return this.race;
	}
	
	public String manger(){
		if (!dort){
			if (this.faim <= 0) {
				return this.nom + " n'a pas faim";
			}
			--faim;
			return this.nom + " a mange";
		}
		return this.nom + " dort et ne peux pas manger";
	}
	
	public String emettreSon(){
		return this.cri;
		
	}
	
	public String etreSoigne(final int soin){
		this.pv += soin;
		
		if (this.pv > this.maxPv) {
			this.pv = this.maxPv;
		}
		
		return this.nom + " a ete soigne.";
	}
	
	public String sendormir(final int temps) {
		this.sommeil -= temps;
		this.dort = true;
		return this.nom + " s'endort.";
	}
	
	public String seReveiller(){
		this.dort = false;
		return this.nom + " s'est reveille.";
	}

	public Collection<PokemonType> getTypes() {
		return this.types;
	}
	
	protected void setTypes(final Collection<PokemonType> types) {
		this.types = types;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public int getAge() {
		return age;
	}

	public String viellir() {
		++this.age;
		return this.nom + " a veillis";
	}

	public int getFaim() {
		return faim;
	}

	public boolean isDodo() {
		return dort;
	}
	
	public int getSommeil() {
		return this.sommeil;
	}
	
	public int getSeuilSommeil() {
		return this.seuilSommeil;
	}
	
	public int getSeuilFaim() {
		return this.seuilFaim;
	}
	
	public int getSante() {
		return pv;
	}

	public void setSante(int sante) {
		this.pv = sante;
	}
	
	public abstract float getEvoPoids();
	
	public abstract float getEvoTaille();

	@Override
	public String toString() {
		return race + " " + nom + " : " + sexe + ", " + poids + "Kg, " + taille + "m, " + age
				+ " ans, " + pv + "/" + maxPv + " PV, faim = " + faim + ", " + (dort ? "dort" : "reveille") + 
				", cri = " + cri;
	}
}
