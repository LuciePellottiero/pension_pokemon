package employe;

import animaux.AbstractAnimal;
import animaux.AbstractAnimal.Sexe;
import enclos.AbstractEnclos;

public class Employe {
	private final String nom;
	private final AbstractAnimal.Sexe sexe;
	private final int age;
	
	public Employe(final String nom, final Sexe sexe, final int age) {
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
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
		String res = this.nom + " netoie " + enclos.getNomEnclos();
		res += enclos.entretenir();
		return res;
	}
	
	public String nourrir(AbstractEnclos enclos) {
		String res = this.nom + " nourris  les animaux de " + enclos.getNomEnclos() + System.lineSeparator(); 
		
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
		try {
			nouvelEnclos.ajouterAnimal(animal);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Erreur lors du transfere vers " + nouvelEnclos.getNomEnclos());
			System.out.println(e.getMessage());
			return "";
		}
		
		if (!ancienEnclos.enleverAnimal(animal)) {
			res += "Erreur lors de du transfère depuis " + ancienEnclos.getNomEnclos();
		}
		
		return res;
	}
}
