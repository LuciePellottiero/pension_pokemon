package animaux;

import java.io.Serializable;
import java.util.Collection;

import evenement.EvenementAnimalAction;
import evenement.EvenementAnimalTour;

public abstract class AbstractAnimal implements IAnimal, Serializable{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 3003146390313202310L;
	
	private final String race;
	private Collection<IAnimal.AnimalType> types;
	private String nom;
	protected final IAnimal.Sexe sexe;
	private float poids;
	private float taille;
	private int age;
	private boolean faim;
	private boolean dort;
	private boolean malade;
	private final String cri;
	private final int tempsGestation;
	private final EvenementAnimalAction action;
	private final EvenementAnimalTour tour;
	
	protected AbstractAnimal(
					final String race,
					final Collection<IAnimal.AnimalType> types,
					final String nom, 
					final IAnimal.Sexe sexe, 
					final int poids,
					final int taille,
					final int age,
					final String cri, 
					final int tempsGestation) {
		
		this.race = race;
		this.types = types;
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.cri = cri;
		this.tempsGestation = tempsGestation;
		this.faim = false;
		this.dort = false;
		this.malade = false;
		
		this.action = new EvenementAnimalAction(this);
		this.tour = new EvenementAnimalTour(this);
	}
	
	public AbstractAnimal(
			final String nom,
			final IAnimal.Sexe sexe,
			final AbstractAnimal animal) {
		this.race = animal.getRace();
		this.types = animal.getTypes();
		this.nom = nom;
		this.sexe = sexe;
		this.poids = animal.getBebePoids();
		this.taille = animal.getBebeTaille();
		this.age = 0;
		this.cri = animal.cri;
		this.tempsGestation = animal.tempsGestation;
		
		this.faim = false;
		this.dort = false;
		this.malade = false;
		
		this.action = new EvenementAnimalAction(this);
		this.tour = new EvenementAnimalTour(this);
	}
	
	@Override
	public EvenementAnimalAction getEvenementAction() {
		return this.action;
	}
	
	@Override
	public EvenementAnimalTour getEvenementTour() {
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
	public Collection<IAnimal.AnimalType> getTypes() {
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
	public IAnimal.Sexe getSexe() {
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
	public abstract float getBebePoids();
	
	@Override
	public abstract float getBebeTaille();

	@Override
	public String toString() {
		return race + " " + nom + " : " + sexe + ", " + poids + "Kg, " + taille + "m, " + age
				+ " ans, " + (malade ? "malade, " : "en bonne santé, ") + (faim ? "affamé, " : "") + (dort ? "dort, " : "reveillé, ") + 
				"cri = " + cri;
	}
	
	@Override
	public int compareTo(AbstractAnimal o) {
		return this.getNom().compareTo(o.getNom());
	}
}
