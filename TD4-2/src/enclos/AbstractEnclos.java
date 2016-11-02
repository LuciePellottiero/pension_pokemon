package enclos;

import java.util.Collection;
import java.util.LinkedList;

import animaux.AbstractAnimal;

public abstract class AbstractEnclos {
	
	private String nomEnclos;
	private final float superficie;
	private final int nbMaxAnimaux;
	private Collection<AbstractAnimal> animaux;
	private Proprete proprete;
	
	protected AbstractEnclos(final String nomEnclos, final float superficie, final int nbMaxAnimaux) {
		this.nomEnclos = nomEnclos;
		this.superficie = superficie;
		this.nbMaxAnimaux = nbMaxAnimaux;
	
		this.animaux = new LinkedList<AbstractAnimal>();
		this.proprete = new Proprete("cage");
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

	public Proprete getProprete() {
		return proprete;
	}
	
	public abstract boolean ajouterAnimal(final AbstractAnimal animal);
	
	public boolean enleverAnimal(final AbstractAnimal animal) {
		return animaux.remove(animal);
	}
	
	public abstract String entretenir();
	
	@Override
	public abstract String toString();
}
