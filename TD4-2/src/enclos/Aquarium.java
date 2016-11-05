package enclos;

import animaux.IAnimal;

public class Aquarium extends AbstractEnclos{
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 862366975768595026L;
	
	private final float profondeur;

	public Aquarium(String nomEnclos, float superficie, int nbMaxAnimaux, float profondeur) {
		super(nomEnclos, superficie, nbMaxAnimaux, IAnimal.AnimalType.MARIN);
		this.profondeur = profondeur;
		this.getPropretes().add(new Proprete("niveau de l'eau"));
		this.getPropretes().add(new Proprete("salinite"));
	}
	
	public final float getProfondeur(){
		return profondeur;
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				"profondeur: " + this.getProfondeur() + "m, " +
				this.getNbAnimaux() + "/" + this.getNbMaxAnimaux() + " animaux, " + 
				this.getPropretes() + System.lineSeparator();
		
		return res;
	}
}
