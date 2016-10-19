package animaux;

import java.util.Collection;

import animaux.AbstractAnimal.AnimalType;
import animaux.AbstractAnimal.Sexe;

public interface IAnimal {
	public String getRace();
	public String manger();
	public String emettreSon();
	public String etreSoigne(final int soin);
	public String sendormir(final int temps);
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
	public int getFaim();
	public boolean isDodo();
	public int getSommeil();
	public int getSeuilSommeil();
	public int getSeuilFaim();
	public int getSante();
	public void setSante(int sante);
	public abstract float getBebePoids();
	public abstract float getBebeTaille();

}
