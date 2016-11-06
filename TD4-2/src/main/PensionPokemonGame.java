package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import IHM.Menu;
import IHM.MenuAction;
import pensionPokemon.PensionPokemon;
import pokeEnclos.AbstractPokeEnclos;
import pokeEnclos.PokeBassin;
import pokeEnclos.EnclosStandard;
import pokeEnclos.PokeVoliere;
import pokemon.AbstractPokemon;
import pokemon.Bulbizarre;
import pokemon.Florizarre;
import pokemon.Herbizarre;
import pokemon.IPokemon;
import pokemon.Leviator;
import pokemon.Lokhlass;
import pokemon.Magicarpe;
import pokemon.Pikachu;
import pokemon.PokemonFactory;
import pokemon.Roucarnage;
import pokemon.Roucool;
import pokemon.Roucoups;

/**
 * Le jeu
 * @author Lucie
 *
 */
public class PensionPokemonGame implements Serializable{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 901926969115423814L;

	private final static int NB_ACTION_PER_TURN = 6;
	
	private final PensionPokemon pension;
	private BufferedReader reader;
	private boolean gameOver = false;
	private static int nbAction;
	public static boolean quitter;
	private static IPokemon.Sexe pokemonSexe;
	public static Collection<AbstractPokemon> bebe;
	public static Collection<AbstractPokeEnclos> bebeEnclos;
	
	public PensionPokemonGame(final PensionPokemon pension, final BufferedReader input) {
		this.pension = pension;
		this.reader = input;
		if (reader == null) {
			this.reader = new BufferedReader(new InputStreamReader(System.in));
		}
		bebe = new ArrayList<AbstractPokemon>();
		bebeEnclos = new ArrayList<AbstractPokeEnclos>();
	}
	
	private boolean menuQuitter() {
		Menu menu = new Menu("Menu", reader);
		
		final PensionPokemonGame thisGame = this;
		menu.addAction(new MenuAction("Sauvegarder", "s") {
			
			@Override
			public boolean action() {
				FileOutputStream fileOut = null;
				try {
					fileOut = new FileOutputStream(Main.SAVE_FOLDER + pension.getEmploye().getNom() + pension.getNom());
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					reader = null;
					out.writeObject(thisGame);
					out.close();
					fileOut.close();
					
					System.out.println("Partie sauvegardée");
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				
				return false;
			}
		});
		
		menu.addAction(new MenuAction("Quitter", "q") {
			@Override
			public boolean action() {
				gameOver = true;
				quitter = true;
				return true;
			}
		});
		
		menu.addAction(new MenuAction("Retour", "r") {
			@Override
			public boolean action() {
				quitter = false;
				return true;
			}
		});
		
		menu.menu();
		return quitter;
		
	}
	
	public void play() {
		System.out.println("Have fun");
		
		if (reader == null) {
			this.reader = new BufferedReader(new InputStreamReader(System.in));
		}
		
		Menu menuPrincipal = new Menu("Menu principal", reader);
		
		menuPrincipal.addAction(new MenuAction("Options", "o") {
			
			@Override
			public boolean action() {
				return menuQuitter();
			}
		});
		
		menuPrincipal.addAction(new MenuAction("Enclos", "e") {
			
			@Override
			public boolean action() {
				menuEnclosPrinc();
				return true;
			}
		});
		
		menuPrincipal.addAction(new MenuAction("Afficher tous les pokemon", "a") {
			
			@Override
			public boolean action() {
				System.out.println(pension.getPokemonStr());
				return false;
			}
		});
		
		while (!gameOver) {
			
			nbAction = 0;
			System.out.println("Nouveau tour");
			
			while(!gameOver && nbAction < NB_ACTION_PER_TURN) {
				menuPrincipal.menu();
			}
			
			if (gameOver) {
				break;
			}
			
			evenementTour();
		}
	}
	
	public void evenementTour(){
		Collection<AbstractPokemon> pokemons = new ArrayList<AbstractPokemon>();
		
		for(AbstractPokeEnclos enclos : pension.getEnclos()){
			enclos.getEvenement().verifEvenement(pension);
			
			pokemons.addAll(enclos.getPokemon());
		}
		
		for(AbstractPokemon pokemon : pokemons) {
			pokemon.getEvenementTour().verifEvenement(pension);
		}
	}
	
	public void useActionPoint() {
		++nbAction;
		System.out.println("Action effectuée (" + (NB_ACTION_PER_TURN - nbAction) + " actions restantes)");
		evenementAction();
	}
	
	public void evenementAction(){
		for(AbstractPokeEnclos enclos : pension.getEnclos()){			
			for(AbstractPokemon pokemon : enclos.getPokemon()) {
				pokemon.getEvenementAction().verifEvenement(pension);
			}
		}
	}	
	
	/*--------------------------------MENU ENCLOS SELECTIONNE---------------------------*/
	
	private void enclosureAction(final AbstractPokeEnclos selectedEnclos) {
		
		Menu enclosureMenu = new Menu("Menu de l'enclos " + selectedEnclos.getNomEnclos(), reader);
		
		enclosureMenu.addAction(new MenuAction("Retour ", "r") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		
		enclosureMenu.addAction(new MenuAction("Examiner", "e") {
			
			@Override
			public boolean action() {
				System.out.println(pension.getEmploye().examinerEnclos(selectedEnclos));
				return false;
			}
		});
		
		enclosureMenu.addAction(new MenuAction("Nettoyer", "ne") {
			
			@Override
			public boolean action() {
				try {
					System.out.println(pension.getEmploye().nettoyer(selectedEnclos));
					useActionPoint();
				}
				catch(Exception e) {
					System.err.println(e.getMessage());
					
				}
				if (nbAction < NB_ACTION_PER_TURN) {
					return false;
				}
				else {
					return true;
				}
			}
		});
		
		enclosureMenu.addAction(new MenuAction("Nourrir les pokemon de l'enclos", "no") {
			
			@Override
			public boolean action() {
				System.out.println(pension.getEmploye().nourrir(selectedEnclos));
				useActionPoint();
				if (nbAction < NB_ACTION_PER_TURN) {
					return false;
				}
				else {
					return true;
				}
			}
		});
		
		enclosureMenu.addAction(new MenuAction("Sélectionner des pokemon", "p") {
			
			@Override
			public boolean action() {
				return pokemonMenu(selectedEnclos);
			}
		});
		
		enclosureMenu.addAction(new MenuAction("Renommer l'enclos", "re") {
			
			@Override
			public boolean action() {
				selectedEnclos.setNomEnclos(chooseName());
				return true;
			}
		});
		
		enclosureMenu.menu();
		return;
	}
	
	/*------------------------------MENU ANIMAUX------------------------------*/
	
	private boolean pokemonMenu(final AbstractPokeEnclos selectedEnclos) {
		Menu pokemonMenu = new Menu("Choix pokemon : ", reader);
		
		for (AbstractPokemon pokemon : selectedEnclos.getPokemon()) {
			pokemonMenu.addAction(new MenuAction("selectionner " + pokemon.getNom(), pokemon.getNom()) {
				
				@Override
				public boolean action() {
					animalAction(pokemon, selectedEnclos);
					return true;
				}
			});
		}
		
		pokemonMenu.addAction(new MenuAction("Nouveau pokemon", "n") {
			
			@Override
			public boolean action() {
				quitter = newPokemon(selectedEnclos);
				return true;
			}
		});
		
		pokemonMenu.addAction(new MenuAction("Retour", "r") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		
		pokemonMenu.menu();
		return quitter;
	}
	
	/*------------------------------CREATION POKEMON---------------------------*/
	
	//TODO choisir race de pokemon et sexe avant son nom
	public class NewPokemonMenuAction extends MenuAction{
		
		private AbstractPokeEnclos selectedEnclos;
		private final String name;
		private final IPokemon.Sexe sexe;
		private final Collection<IPokemon.PokemonType> types;
		
		public NewPokemonMenuAction(final String action, final String input, AbstractPokeEnclos selectedEnclos, 
				final String name, final IPokemon.Sexe sexe, IPokemon.PokemonType...types) {
			super(action, input);
			this.selectedEnclos = selectedEnclos;
			this.name = name;
			this.sexe = sexe;
			this.types = new ArrayList<IPokemon.PokemonType>(Arrays.asList(types));
		}
		
		public Collection<IPokemon.PokemonType> getTypes() {
			return this.types;
		}

		@Override
		public boolean action() {

			try {
				AbstractPokemon newPokemon = PokemonFactory.createPokemon(this.getAction(), name, sexe);
				selectedEnclos.ajouterPokemon(newPokemon);
				useActionPoint();
			} 
			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				System.out.println();
				return false;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if (nbAction < NB_ACTION_PER_TURN) {
				quitter = false;
			}
			else {
				quitter = true;
			}
			return true;
		}

	}
	
	private boolean newPokemon(AbstractPokeEnclos selectedEnclos) {
				
		String name;
		while(true) {
			name = chooseName();
			for (AbstractPokemon pokemon : selectedEnclos.getPokemon()) {
				if (pokemon.getNom().equals(name)) {
					System.err.println("Un autre pokemon de cet enclos porte déjà ce nom");
					continue;
				}
			}
			break;
		}
		
		Menu choixSexe = new Menu("Choix du sexe", reader);
		choixSexe.addAction(new MenuAction("Mâle", "m") {
			
			@Override
			public boolean action() {
				pokemonSexe = IPokemon.Sexe.MALE;
				return true;
			}
		});
		
		choixSexe.addAction(new MenuAction("Femelle", "f") {
			
			@Override
			public boolean action() {
				pokemonSexe = IPokemon.Sexe.FEMELLE;
				return true;
			}
		});
		choixSexe.menu();
		
		Menu pokemonCreation = new Menu("Choisi la race de pokemon", reader);
		
		addValidPokemonAction(pokemonCreation, selectedEnclos, name);
		
		pokemonCreation.addAction(new MenuAction("Retour", "r") {
			
			@Override
			public boolean action() {
				quitter = false;
				return true;
			}
		});
		
		pokemonCreation.menu();
		return quitter;
	}
	
	private void addValidPokemonAction(Menu menu, final AbstractPokeEnclos selectedEnclos, final String name) {
		Collection<NewPokemonMenuAction> menuActions = new ArrayList<NewPokemonMenuAction>();	
		menuActions.add(new NewPokemonMenuAction("Roucool", "rl", selectedEnclos, name, pokemonSexe, Roucool.TYPES));
		menuActions.add(new NewPokemonMenuAction("Herbizarre", "he", selectedEnclos, name, pokemonSexe, Herbizarre.TYPES));
		menuActions.add(new NewPokemonMenuAction("Lokhlass", "lo", selectedEnclos, name, pokemonSexe, Lokhlass.TYPES));
		menuActions.add(new NewPokemonMenuAction("Bulbizarre", "bu", selectedEnclos, name, pokemonSexe, Bulbizarre.TYPES));
		menuActions.add(new NewPokemonMenuAction("Florizarre", "fl", selectedEnclos, name, pokemonSexe, Florizarre.TYPES));
		menuActions.add(new NewPokemonMenuAction("Magicarpe", "ma", selectedEnclos, name, pokemonSexe, Magicarpe.TYPES));
		menuActions.add(new NewPokemonMenuAction("Leviator", "le", selectedEnclos, name, pokemonSexe, Leviator.TYPES));
		menuActions.add(new NewPokemonMenuAction("Pikachu", "pi", selectedEnclos, name, pokemonSexe, Pikachu.TYPES));
		menuActions.add(new NewPokemonMenuAction("Roucoups", "rs", selectedEnclos, name, pokemonSexe, Roucoups.TYPES));
		menuActions.add(new NewPokemonMenuAction("Roucarnage", "re", selectedEnclos, name, pokemonSexe, Roucarnage.TYPES));
		
		for(NewPokemonMenuAction menuAction : menuActions) {
			for (IPokemon.PokemonType type : selectedEnclos.getAcceptedtypes()) {
				if(!menu.containsAction(menuAction) && menuAction.getTypes().contains(type)) {
					menu.addAction(menuAction);
					break;
				}
			}
		}
	}
	
	/*------------------------------MENU POKEMON SELECTIONNE-------------------------------*/
	
	private void animalAction(AbstractPokemon selectedPokemon, AbstractPokeEnclos selectedEnclos) {

		Menu pokemonMenu = new Menu("Menu du pokemon " + selectedPokemon.getNom(), reader);
		
		pokemonMenu.addAction(new MenuAction("Retour ", "r") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		pokemonMenu.addAction(new MenuAction("Infos", "i") {
			
			@Override
			public boolean action() {
				System.out.println(selectedPokemon.toString());
				return false;
			}
		});
		
		pokemonMenu.addAction(new MenuAction("Soigner", "s") {
			
			@Override
			public boolean action() {
				System.out.println(selectedPokemon.etreSoigne());
				useActionPoint();
				if (nbAction < NB_ACTION_PER_TURN) {
					return false;
				}
				else {
					return true;
				}
			}
		});
		
		pokemonMenu.addAction(new MenuAction("Réveiller", "rev") {
			
			@Override
			public boolean action() {
				System.out.println(selectedPokemon.seReveiller());
				useActionPoint();
				if (nbAction < NB_ACTION_PER_TURN) {
					return false;
				}
				else {
					return true;
				}
			}
		});
		
		pokemonMenu.addAction(new MenuAction("Transférer", "t") {
			
			@Override
			public boolean action() {
				transfererPokemon(selectedPokemon, selectedEnclos);
				useActionPoint();
				if (nbAction < NB_ACTION_PER_TURN) {
					return false;
				}
				else {
					return true;
				}
			}
		});
		
	
		pokemonMenu.addAction(new MenuAction("Renommer le pokemon", "re") {
			
			@Override
			public boolean action() {
				selectedPokemon.setNom(chooseName());
				return true;
			}
		});
		
		pokemonMenu.menu();
		return;
	}
	
	public void transfererPokemon(AbstractPokemon selectedPokemon, AbstractPokeEnclos selectedEnclos){
		Menu transfereMenu = new Menu("Selectionner le nouvel enclos du pokemon " + selectedPokemon.getNom(), reader);
		transfereMenu.addAction(new MenuAction("Retour", "r") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		
		for(AbstractPokeEnclos enclos : pension.getEnclos()){
			transfereMenu.addAction(new MenuAction("Selectionner " + enclos.getNomEnclos(), enclos.getNomEnclos()) {
				
				@Override
				public boolean action() {
					try{
						System.out.println(pension.getEmploye().transferer(selectedPokemon, selectedEnclos, enclos));
						return true;
					}
					catch(IllegalArgumentException e){
						System.err.println(e.getMessage());
						return false;
					}
				}
			});
		}
		transfereMenu.menu();
		return;
	}
	
	/*------------------------------CREATION D'ENCLOS-------------------------*/
	
	private String chooseName() {
		String name = "";
		
		while(name.length() < 2) {
			System.out.println("Entrez le nom (au moins deux charactères) : ");
			
			try {
				name = reader.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return name;
	}
	
	private float chooseNumber(final String question) {
		float inputFinal;
		String input;
		
		while (true) {
			System.out.println(question);
			try {
				input = reader.readLine();
				
				inputFinal = Float.parseFloat(input);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				continue;
			}
		}
		return inputFinal;
	}
	
	private boolean newEnclosure() {
		
		Menu newEnclosure = new Menu("Nouvel enclos", reader);
		
		newEnclosure.addAction(new MenuAction("Bassin", "b") {
			
			@Override
			public boolean action() {
				PokeBassin newBassin = newBassin();
				useActionPoint();
				// If there is no action point left, then go back to main menu
				if (nbAction < NB_ACTION_PER_TURN) {
					enclosureAction(newBassin);
				}
				quitter = true;
				return true;
			}
		});
		
		newEnclosure.addAction(new MenuAction("Volière", "v") {
			
			@Override
			public boolean action() {
				PokeVoliere newVoliere = newVoliere();
				useActionPoint();
				// If there is no action point left, then go back to main menu
				if (nbAction < NB_ACTION_PER_TURN) {
					enclosureAction(newVoliere);
				}
				quitter = true;
				return true;
			}
		});
		
		newEnclosure.addAction(new MenuAction("Enclos standard", "e") {
			
			@Override
			public boolean action() {
				EnclosStandard newEnclos = newEnclosStandard();
				useActionPoint();
				// If there is no action point left, then go back to main menu
				if (nbAction < NB_ACTION_PER_TURN) {
					enclosureAction(newEnclos);
				}
				quitter = true;
				return true;
			}
		});
		
		newEnclosure.addAction(new MenuAction("Retour", "r") {
			
			@Override
			public boolean action() {
				quitter = false;
				return true;
			}
		});
		
		newEnclosure.menu();
		
		return quitter;
	}
	
	/*--------------------------------bassin--------------------------*/
	
	private PokeBassin newBassin(){
		String bassinName = chooseName();
		
		float superficieBassin = chooseNumber("Quelle est la superficie en m² de ton bassin ?");
		
		int nbPokemon = (int) chooseNumber("Quel est le nombre maximum de pokemon que peut acceuillir ce bassin ?");

		float profondeur = chooseNumber("Quelle est la profondeur en m de ton bassin ?");
		
		PokeBassin bassin = new PokeBassin(bassinName, superficieBassin, nbPokemon, profondeur);
		
		pension.ajouterEnclos(bassin);
		return bassin;
	}
	
	/*------------------------------------voliere---------------------------------------*/
	
	private PokeVoliere newVoliere(){

		String voliereName = chooseName();

		float superficieVoliere = chooseNumber("Quelle est la superficie en m² de ta voliere ?");
		
		int nbPokemon = (int) chooseNumber("Quel est le nombre maximum de pokemon que peut acceuillir cette voliere ?");

		float hauteur = chooseNumber("Quelle est la hauteur en m de ta volière ?");
		
		PokeVoliere voliere = new PokeVoliere(voliereName, superficieVoliere, nbPokemon, hauteur);
		
		pension.ajouterEnclos(voliere);
		
		return voliere;
	}
	
	/*---------------------------------------enclos standard---------------------------*/
	
	private EnclosStandard newEnclosStandard(){
		String enclosName = chooseName();
		
		float superficieEnclos = chooseNumber("Quelle est la superficie en m² de ton enclos ?");

		int nbPokemon = (int) chooseNumber("Quel est le nombre maximum de pokemon que peut acceuillir cet enclos ?");
		
		EnclosStandard enclos = new EnclosStandard(enclosName, superficieEnclos, nbPokemon);
		
		pension.ajouterEnclos(enclos);
		
		return enclos;
	}
	
	private void menuEnclosPrinc() {
		
		Menu enclosMenu = new Menu("Choix enclos : ", reader);
		
		for (AbstractPokeEnclos enclos : pension.getEnclos()) {
			enclosMenu.addAction(new MenuAction("selectionner " + enclos.getNomEnclos(), enclos.getNomEnclos()) {
				
				@Override
				public boolean action() {
					enclosureAction(enclos);
					return true;
				}
			});
		}
		
		enclosMenu.addAction(new MenuAction("Nouvel enclos", "n") {
			
			@Override
			public boolean action() {
				return newEnclosure();
			}
		});
		
		enclosMenu.addAction(new MenuAction("Retour", "r") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		
		enclosMenu.menu();
	}
	
	
}
