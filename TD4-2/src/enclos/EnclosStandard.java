package enclos;

import animaux.IAnimal;

public class EnclosStandard extends AbstractEnclos{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -981895495248491916L;
	

	public EnclosStandard(String nomEnclos, float superficie, int nbMaxAnimaux) {
		super(nomEnclos, superficie, nbMaxAnimaux, IAnimal.AnimalType.NORMAL, IAnimal.AnimalType.VAGABONDANT);
	}

	@Override
	public String toString() {
		 
		String res = this.getNomEnclos() + " : " + this.getSuperficie() + "m², " + 
				this.getNbAnimaux() + "/" + this.getNbMaxAnimaux() + " animaux, " + 
				this.getPropretes() + System.lineSeparator();
		
		return res;
	}

}
