package evenement;

import java.io.Serializable;

import pensionPokemon.PensionPokemon;

/**
 * Tous les évenements qui se produisent indépendamment du joueur (employé)
 * @author Lucie
 *
 */
public interface IEvenement extends Serializable{
	public void verifEvenement(PensionPokemon pension);
}
