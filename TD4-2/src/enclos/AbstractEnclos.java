package enclos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import animaux.AbstractAnimal;
import animaux.IAnimal;
import animaux.IAnimal.AnimalType;
import evenement.EvenementEnclos;

public abstract class AbstractEnclos {
	
	private String nomEnclos;
	private final float superficie;
	private final int nbMaxAnimaux;
	private Collection<AbstractAnimal> animaux;
	private Collection<Proprete> propretes;
	private EvenementEnclos evenement;
	private final Collection<IAnimal.AnimalType> acceptedTypes;
	
	protected AbstractEnclos(final String nomEnclos, final float superficie, final int nbMaxAnimaux, final IAnimal.AnimalType...types) {
		this.nomEnclos = nomEnclos;
		this.superficie = superficie;
		this.nbMaxAnimaux = nbMaxAnimaux;
		this.acceptedTypes = new ArrayList<IAnimal.AnimalType>(Arrays.asList(types));
	
		this.animaux = new ArrayList<AbstractAnimal>();
		this.propretes = new ArrayList<Proprete>();
		this.propretes.add(new Proprete("sol"));
		this.evenement = new EvenementEnclos(this);
	}
	
	public Collection<IAnimal.AnimalType> getAcceptedtypes() {
		return this.acceptedTypes;
	}
	
	public EvenementEnclos getEvenement(){
		return evenement;
	}

	public String getNomEnclos() {
		return nomEnclos;
	}
	
	public void setNomEnclos(String nomEnclos){
		this.nomEnclos = nomEnclos;
	}

	public float getSuperficie() {
		return superficie;
	}

	public int getNbMaxAnimaux() {
		return nbMaxAnimaux;
	}

	public Collection<AbstractAnimal> getAnimaux() {
		return animaux;
	}

	public int getNbAnimaux() {
		return animaux.size();
	}

	public Collection<Proprete> getPropretes() {
		return propretes;
	}
	
	public boolean ajouterAnimal(final AbstractAnimal animal) {
		if (this.getNbAnimaux() >= this.getNbMaxAnimaux()) {
			throw new IllegalArgumentException("Cet enclos est complet.");
		}
		
		boolean isAccepted = false;
		for(AnimalType type : this.acceptedTypes) {
			if(animal.getTypes().contains(type)) {
				isAccepted = true;
				break;
			}
		}
		
		if (!isAccepted) {
			throw new IllegalArgumentException("Cet enclos ne peut que contenir des animaux de type : " +
					System.lineSeparator() + this.acceptedTypes);
		}
		
		if (this.getNbAnimaux() > 0) {
			
			String raceCourante = this.getAnimaux().iterator().next().getRace();
			if (!raceCourante.equals(animal.getRace())) {
				throw new IllegalArgumentException("Le race d'animaux de cet enclos est " + raceCourante);
			}
			return this.getAnimaux().add(animal);
		}
		return this.getAnimaux().add(animal);
	}
	
	public boolean enleverAnimal(final AbstractAnimal animal) {
		return animaux.remove(animal);
	}
	
	public String entretenir() {
		if (!this.getAnimaux().isEmpty()) {
			throw new IllegalArgumentException("L'entretien ne peut se faire que si l'enclos est vide");
		}
		
		Proprete priorite = this.getPropretes().iterator().next();
		
		for (Proprete proprete : this.getPropretes()) {
			if (priorite.getEtat() < proprete.getEtat()) {
				priorite = proprete;
			}
		}
		
		return priorite.entretien();
	}
	
	@Override
	public abstract String toString();
}
