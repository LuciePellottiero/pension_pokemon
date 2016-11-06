package evenement;

import java.io.Serializable;

import pensionPokemon.PensionPokemon;

public interface IEvenement extends Serializable{
	public void verifEvenement(PensionPokemon pension);
}
