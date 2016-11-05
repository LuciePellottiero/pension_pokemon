package animaux;

import java.io.Serializable;
import java.util.Collection;

import evenement.EvenementAnimalAction;
import evenement.EvenementAnimalTour;

public interface IAnimal extends Comparable<AbstractAnimal>, Serializable{
	enum AnimalType {
		VOLANT,
		MARIN,
		VAGABONDANT,
		NORMAL;
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
	public Collection<IAnimal.AnimalType> getTypes();
	public String getNom();
	public void setNom(String nom);
	public IAnimal.Sexe getSexe();
	public float getPoids();
	public void setPoids(float poids);
	public float getTaille();
	public void setTaille(float taille);
	public int getAge();
	public String viellir();
	public boolean isFaim();
	public boolean isDodo();
	public boolean isMalade();
	public void setSante(boolean malade);
	public abstract float getBebePoids();
	public abstract float getBebeTaille();
	public String aFaim();
	public EvenementAnimalAction getEvenementAction();
	public EvenementAnimalTour getEvenementTour();
	public String tombeMalade();
	public AbstractAnimal seReproduire(String nom) throws Exception;
}
