package animaux;

import java.util.Collection;

public abstract class AbstractAnimal implements IAnimal{
	
	public static enum Sexe {
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
	
	public static enum AnimalType {
		VOLANT,
		MARIN,
		VAGABONDANT,
		NORMAL;
	}
	
	private final String race;
	private Collection<AnimalType> types;
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
	private int sante;
	private final int maxSante;
	private final String cri;
	private final int tempsGestation;
	
	protected AbstractAnimal(
					final String race,
					final Collection<AnimalType> types,
					final String nom, 
					final Sexe sexe, 
					final int poids,
					final int taille,
					final int age,
					final String cri, 
					final int maxSante, 
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
		this.maxSante = maxSante;
		this.seuilSommeil = seuilSommeil;
		this.seuilFaim = seuilFaim;
		this.tempsGestation = tempsGestation;
		
		this.faim = 0;
		this.dort = false;
		this.sante = maxSante;
	}
	
	public AbstractAnimal(
			final String nom,
			final Sexe sexe,
			final AbstractAnimal animal) {
		this.race = animal.getRace();
		this.types = animal.getTypes();
		this.nom = nom;
		this.sexe = sexe;
		this.poids = animal.getBebePoids();
		this.taille = animal.getBebeTaille();
		this.age = 0;
		this.cri = animal.cri;
		this.maxSante = animal.maxSante;
		this.seuilSommeil = animal.seuilSommeil;
		this.seuilFaim = animal.seuilFaim;
		this.tempsGestation = animal.tempsGestation;
		
		this.faim = 0;
		this.dort = false;
		this.sante = maxSante;
	}
	
	@Override
	public String getRace() {
		return this.race;
	}
	
	@Override
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
	
	@Override
	public String emettreSon(){
		return this.cri;
		
	}
	
	@Override
	public String etreSoigne(final int soin){
		this.sante += soin;
		
		if (this.sante > this.maxSante) {
			this.sante = this.maxSante;
		}
		
		return this.nom + " a ete soigne.";
	}
	
	@Override
	public String sendormir(final int temps) {
		this.sommeil -= temps;
		this.dort = true;
		return this.nom + " s'endort.";
	}
	
	@Override
	public String seReveiller(){
		if(!this.dort) {
			return this.nom + " ne dormait pas.";
		}
		this.dort = false;
		return this.nom + " s'est reveille.";
	}

	@Override
	public Collection<AnimalType> getTypes() {
		return this.types;
	}
	
	@Override
	public void setTypes(final Collection<AnimalType> types) {
		this.types = types;
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
	public Sexe getSexe() {
		return sexe;
	}

	@Override
	public float getPoids() {
		return poids;
	}

	@Override
	public void setPoids(float poids) {
		this.poids = poids;
	}

	@Override
	public float getTaille() {
		return taille;
	}

	@Override
	public void setTaille(float taille) {
		this.taille = taille;
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
	public int getFaim() {
		return faim;
	}

	@Override
	public boolean isDodo() {
		return dort;
	}
	
	@Override
	public int getSommeil() {
		return this.sommeil;
	}
	
	@Override
	public int getSeuilSommeil() {
		return this.seuilSommeil;
	}
	
	@Override
	public int getSeuilFaim() {
		return this.seuilFaim;
	}
	
	@Override
	public int getSante() {
		return sante;
	}

	@Override
	public void setSante(int sante) {
		this.sante = sante;
	}
	
	@Override
	public abstract float getBebePoids();
	
	@Override
	public abstract float getBebeTaille();

	@Override
	public String toString() {
		return race + " " + nom + " : " + sexe + ", " + poids + "Kg, " + taille + "m, " + age
				+ " ans, " + sante + "/" + maxSante + " PV, faim = " + faim + ", " + (dort ? "dort" : "reveille") + 
				", cri = " + cri;
	}
}
