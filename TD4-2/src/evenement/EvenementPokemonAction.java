package evenement;

import java.util.concurrent.ThreadLocalRandom;

import pensionPokemon.PensionPokemon;
import pokemon.AbstractPokemon;

/**
 * Décrit les événements concernant les pokemon pour une action
 * @author Lucie
 *
 */
public class EvenementPokemonAction extends EvenementAction {

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 7978513932511704772L;
	
	private AbstractPokemon pokemon;
	private final static int CHANCE_DODO = 20;
	private final static int CHANCE_REVEIL = 75;
	private final static int CHANCE_FAIM = 20;
	
	public EvenementPokemonAction(AbstractPokemon pokemon){
		this.pokemon = pokemon;	
	}
	
	@Override
	public void verifEvenement(PensionPokemon pension) {
		
		int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		if(pokemon.isDodo()){
			if(random <= CHANCE_REVEIL){
				System.out.println(pokemon.emettreSon());
				System.out.println(pokemon.seReveiller());
			}
			
		}
		else{
			if (random <= CHANCE_DODO) {
				System.out.println(pokemon.sendormir());
			}
		}
		
		random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		if(!pokemon.isFaim()){
			if(random <= CHANCE_FAIM){
				System.out.println(pokemon.emettreSon());
				System.out.println(pokemon.aFaim());
			}
		}	
	}

}
