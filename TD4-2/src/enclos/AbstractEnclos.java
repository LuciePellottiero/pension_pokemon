package enclos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal;
import evenement.EvenementEnclos;

public abstract class AbstractEnclos {
	
	private String nomEnclos;
	private final float superficie;
	private final int nbMaxAnimaux;
	private Collection<AbstractAnimal> animaux;
	private Collection<Proprete> propretes;
	private EvenementEnclos evenement;
	
	protected AbstractEnclos(final String nomEnclos, final float superficie, final int nbMaxAnimaux) {
		this.nomEnclos = nomEnclos;
		this.superficie = superficie;
		this.nbMaxAnimaux = nbMaxAnimaux;
	
		this.animaux = new ArrayList<AbstractAnimal>();
		this.propretes = new ArrayList<Proprete>();
		this.propretes.add(new Proprete("sol"));
		this.evenement = new EvenementEnclos(this);
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
	
	public abstract boolean ajouterAnimal(final AbstractAnimal animal);
	
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
