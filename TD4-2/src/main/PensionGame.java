package main;

import java.io.BufferedReader;
import java.io.IOException;

import enclos.AbstractEnclos;
import pension.Pension;
import pokemon.AbstractPokemon;

public class PensionGame {
	
	private final static int NB_ACTION_PER_TURN = 6;
	
	private final static String MENU = "m";
	
	private final static String RETURN = "r";
	
	private final static String POKEMONS_DISPLAY_ALL = "al";
	private final static String ENCLOSURE = "e";
	
	private final static String ENCLOSURE_DISPLAY = "i";
	private final static String ENCLOSURE_POKEMONS = "a";
	private final static String ENCLOSURE_SELECT = "s";
	private final static String ENCLOSURE_NEW = "n";
	
	private final Pension pension;
	private final BufferedReader input;
	private boolean gameOver = false;
	private int nbAction;
	
	private AbstractEnclos selectedEnclos;
	
	public PensionGame(final Pension pension, final BufferedReader input) {
		this.pension = pension;
		this.input = input;
	}
	
	public void displayGameMenu() {
		System.out.println("Menu : ");
		System.out.println("Quitter partie : " + Main.QUITTER);
		System.out.println("Retour : " + RETURN);
	}
	
	private boolean actionMenu(String input) {
		switch (input) {
			case Main.QUITTER :
				gameOver = true;
				return true;
			case RETURN:
				return true;
		}
		
		return false;
	}
	
	private void displayActions() {
		System.out.println("Actions possibles : ");
		System.out.println("Menu : " + MENU);
		System.out.println("Enclos : " + ENCLOSURE);
		System.out.println("Afficher tous les annimaux : " + POKEMONS_DISPLAY_ALL);
	}
	
	private void menusHandler() {
		
		String choix = "";
		while(!actionMenu(choix)) {
			displayGameMenu();
			
			try {
				choix = input.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void displayEnclosure() {
		System.out.println("Menu enclos : ");
		System.out.println("Retour : " + RETURN);
		System.out.println("Infos : " + ENCLOSURE_DISPLAY);
		System.out.println("Animaux : " + ENCLOSURE_POKEMONS);
	}
	
	private boolean enclosureAction(final String input) {
		switch(input) {
			case RETURN:
				return true;
			case ENCLOSURE_DISPLAY:
				System.out.println(this.selectedEnclos);
				return false;
			case ENCLOSURE_POKEMONS:
				for (AbstractPokemon pokemon : this.selectedEnclos.getPokemon()) {
					System.out.println(pokemon);
				}
				return false;
		}
		return false;
	}
	
	private boolean newEnclosureHandler(final String input) {
		switch(input) {
		
		}
		return false;
	}
	
	private void displayNewEncolsure() {
		
	}
	
	private void newEnclosure() {
		String choix = "";
		
		while(!newEnclosureHandler(choix)) {
			displayNewEncolsure();
			
			try {
				choix = input.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private boolean selectEnclosure(final String input, boolean isReturn) {
		if (input.equals(RETURN)) {
			isReturn = true;
			return true;
		}
		else if (input.equals(ENCLOSURE_NEW)) {
			newEnclosure();
			return true;
		}
		for (AbstractEnclos enclos : pension.getEnclos()) {
			if (enclos.getNomEnclos().equals(input)) {
				this.selectedEnclos = enclos;
				return true;
			}
		}
		return false;
	}
	
	private void displayAllEnclosures() {
		for (AbstractEnclos enclos : pension.getEnclos()) {
			System.out.println(enclos);
		}
		System.out.println("Retour : " + RETURN);
		System.out.println("Nouvel enclo: " + ENCLOSURE_NEW);
	}
	
	private void enclosureHandler() {
		String choix = "";
		boolean isReturn = false;
		
		while(!selectEnclosure(choix, isReturn)) {
			displayAllEnclosures();
			
			try {
				choix = input.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		while(!isReturn && !enclosureAction(choix)) {
			displayEnclosure();
			
			try {
				choix = input.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void handleInput(final String input) {
		switch(input) {
			case MENU:
				menusHandler();
				break;
			case ENCLOSURE:
				enclosureHandler();
				break;
			case POKEMONS_DISPLAY_ALL:
				System.out.println(pension.getPokemonStr());
				break;
		}
	}
	
	public void play() {
		System.out.println("Have fun");
		
		String choix = "";
		
		while (!gameOver) {
			
			//TODO random events.
			
			nbAction = 0;
			while(!gameOver && nbAction < NB_ACTION_PER_TURN) {
				try {
					displayActions();
					choix = input.readLine();
					handleInput(choix);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
