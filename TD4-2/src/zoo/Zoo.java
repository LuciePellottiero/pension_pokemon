package zoo;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal;
import employe.Employe;
import enclos.AbstractEnclos;

public class Zoo {

	private final String nom;
	private final Employe employe;
	private final int nbMaxEnclos;
	private Collection<AbstractEnclos> enclos;
	
	public Zoo(final String nom, final Employe employe, final int nbMaxEnclos) {
		this.nom = nom;
		this.nbMaxEnclos = nbMaxEnclos;
		this.employe = employe;
		
		enclos = new LinkedList<AbstractEnclos>();
	}
	
	public String getAnimauxStr() {
		String str = "";
		
		for(AbstractEnclos enclos : enclos) {
			for (AbstractAnimal animal : enclos.getAnimaux()) {
				str += animal.toString() + System.lineSeparator();
			}
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
