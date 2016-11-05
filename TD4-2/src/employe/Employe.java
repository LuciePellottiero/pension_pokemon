package employe;

import java.io.Serializable;

import animaux.AbstractAnimal;
import animaux.IAnimal;
import enclos.AbstractEnclos;

public class Employe implements Serializable{
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -7214996969319942034L;
	
	private final String nom;
	@SuppressWarnings("unused")
	private final IAnimal.Sexe sexe;
	@SuppressWarnings("unused")
	private final int age;
	
	public Employe(final String nom, final IAnimal.Sexe sexe, final int age) {
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String examinerEnclos(AbstractEnclos enclos) {
		
		String res = this.nom + " examine ";
		
		res += enclos.toString();
		
		for (AbstractAnimal animal : enclos.getAnimaux()) {
			res += animal + System.lineSeparator();
		}
		
		return res;
	}
	
	public String nettoyer(AbstractEnclos enclos) {
		String res = this.nom + " nettoie " + enclos.getNomEnclos();
		res += ": état = " +enclos.entretenir();
		return res;
	}
	
	public String nourrir(AbstractEnclos enclos) {
		String res = this.nom + " nourris les animaux de " + enclos.getNomEnclos() + System.lineSeparator(); 
		
		for (AbstractAnimal animal : enclos.getAnimaux()) {
			res += animal.manger();
		}
		
		return res;
	}
	
	public String transferer(AbstractAnimal animal, AbstractEnclos ancienEnclos, AbstractEnclos nouvelEnclos) {
		String res = "";
		
		if (!ancienEnclos.getAnimaux().contains(animal)) {
			throw new IllegalArgumentException("L'ancien enclos ne contient pas " + animal.getNom());
		}
		nouvelEnclos.ajouterAnimal(animal);
		
		if (!ancienEnclos.enleverAnimal(animal)) {
			res += "Erreur lors du transfère depuis " + ancienEnclos.getNomEnclos();
		}
		
		return res;
	}
}
