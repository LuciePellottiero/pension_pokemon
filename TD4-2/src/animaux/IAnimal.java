package animaux;

import java.util.Collection;

import animaux.AbstractAnimal.AnimalType;
import animaux.AbstractAnimal.Sexe;
import evenement.EvenementAnimalAction;
import evenement.EvenementAnimalTour;

public interface IAnimal extends Comparable<AbstractAnimal>{
	public String getRace();
	public String manger();
	public String emettreSon();
	public String etreSoigne();
	public String sendormir();
	public String seReveiller();
	public Collection<AnimalType> getTypes();
	public void setTypes(final Collection<AnimalType> types);
	public String getNom();
	public void setNom(String nom);
	public Sexe getSexe();
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
