package enclos;

import java.io.Serializable;

public class Proprete implements Serializable{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 8929590470289944138L;
	
	private static final int BON = 2;
	private static final int CORRECT = 1;
	private static final int MAUVAIS = 0;
	
	private int etat;
	private final String nom;
	
	public Proprete(final String nom) {
		this.nom = nom;
		this.etat = BON;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getEtat() {
		return this.etat;
	}
	
	public String getEtatStr() {
		return this.etatStr(etat);
	}
	
	private String etatStr(final int etat) {
		switch(etat) {
			case BON:
				return "bon";
			case CORRECT :
				return "correct";
			case MAUVAIS :
				return "mauvais";
			default :
				return "erreur";
		}
	}
	
	public String entretien() {
		
		if (this.etat == BON) {
			return this.etatStr(etat);
		}
		else {
			return this.etatStr(++etat);
		}
	}
	
	public String deteriore() {
		if (this.etat == MAUVAIS) {
			return "état de l'enclos : " + this.etatStr(etat);
		}
		else {
			return "état de l'enclos : " + this.etatStr(--etat);
		}
	}

	@Override
	public String toString() {
		return nom + " : " + etatStr(this.etat);
	}
	
	
}
