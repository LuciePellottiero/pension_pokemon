package evenement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

import pensionPokemon.PensionPokemon;
import pokeEnclos.AbstractPokeEnclos;
import pokemon.AbstractPokemon;
import pokemon.IPokemon;
/**
 * Décrit les événements concernant les pokemon pour un tour
 * @author Lucie
 *
 */
public class EvenementPokemonTour extends EvenementTour{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -2921241511488905808L;
	
	private final static int CHANCE_MALADE = 30;
	private final static int CHANCE_BEBE = 20;
	
	private AbstractPokemon pokemon;
	
	public EvenementPokemonTour(final AbstractPokemon pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public void verifEvenement(PensionPokemon pension) {
		
		if(pokemon.canEvolved()) {
			AbstractPokemon evolution = pokemon.evoluer();
			
			System.out.println(pokemon.getNom() + " évolue en " + evolution.getRace());
			
			for(AbstractPokeEnclos enclos : pension.getEnclos()) {
				if(enclos.getPokemon().contains(pokemon)) {
					enclos.getPokemon().remove(pokemon);
					enclos.getPokemon().add(evolution);
					this.pokemon = evolution;
					return;
				}
			}
		}
		
		int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		
		if(!pokemon.isMalade()){
			if(random <= CHANCE_MALADE){
				System.out.println(pokemon.emettreSon());
				System.out.println(pokemon.tombeMalade());
			}
		}
		
		random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		if(random <= CHANCE_BEBE && pokemon.getSexe() == IPokemon.Sexe.FEMELLE) {
			
			AbstractPokemon bebe = null;
			String name = "";
			
			for(AbstractPokeEnclos enclos : pension.getEnclos()) {
				if(enclos.getPokemon().contains(pokemon)) {
					boolean hasMale = false;
					for (AbstractPokemon currentPokemon : enclos.getPokemon()) {
						if(currentPokemon.getSexe() == IPokemon.Sexe.MALE) {
							hasMale = true;
							break;
						}
					}
					
					if (hasMale && enclos.getNbPokemon() < enclos.getNbMaxPokemon()) {
						
						
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						
						try {
							bebe = pokemon.pondre(name);
						} 
						catch (Exception e1) {
							e1.printStackTrace();
						}
						
						System.out.println(pokemon.getNom() + " a eu un bébé!");
						System.out.println(bebe);
						
						while(name.length() < 2) {
							System.out.println("Entrez le nom du bébé (au moins deux charactères) : ");
							
							try {
								name = reader.readLine();
							} 
							catch (IOException e) {
								e.printStackTrace();
							}
							
						}
						bebe.setNom(name);
						enclos.ajouterPokemon(bebe);
						break;
					}
				}
			}
		}
		
		pokemon.levelUp();
		
	}

}
