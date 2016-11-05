package zoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import animaux.AbstractAnimal;
import employe.Employe;
import enclos.AbstractEnclos;

public class Zoo implements Serializable{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 7020412288975185458L;
	
	private final String nom;
	private final Employe employe;
	private final int nbMaxEnclos;
	private Collection<AbstractEnclos> enclos;
	
	public Zoo(final String nom, final Employe employe, final int nbMaxEnclos) {
		this.nom = nom;
		this.nbMaxEnclos = nbMaxEnclos;
		this.employe = employe;
		
		enclos = new ArrayList<AbstractEnclos>();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getAnimauxStr() {
		String str = "";
		
		List<AbstractAnimal> sortedAnimals = new ArrayList<AbstractAnimal>();
		
		for(AbstractEnclos enclos : enclos) {
			for (AbstractAnimal animal : enclos.getAnimaux()) {
				sortedAnimals.add(animal);
			}
		}
		
		Collections.sort(sortedAnimals);
		
		for (AbstractAnimal animalsName : sortedAnimals) {
			str += animalsName + System.lineSeparator();
		}
		
		return str;
	}
	
	public int getNbMaxEnclos(){
		return nbMaxEnclos;
	}
	
	public boolean ajouterEnclos(final AbstractEnclos enclos) {
		if (this.enclos.size() == this.nbMaxEnclos) {
			return false;
		}
		
		return this.enclos.add(enclos);
	}
	
	public Employe getEmploye() {
		return this.employe;
	}
	
	public Collection<AbstractEnclos> getEnclos() {
		return this.enclos;
	}
}
