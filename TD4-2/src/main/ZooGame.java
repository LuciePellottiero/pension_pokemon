package main;

import java.io.BufferedReader;
import java.io.IOException;

import animaux.AbstractAnimal;
import enclos.AbstractEnclos;
import enclos.Aquarium;
import enclos.EnclosStandard;
import enclos.Voliere;
import zoo.Zoo;

public class ZooGame {
	
	private final static int NB_ACTION_PER_TURN = 6;
	
	private final static String MENU = "m";
	
	private final static String RETURN = "r";
	
	private final static String ANIMALS_DISPLAY_ALL = "al";
	private final static String ENCLOSURE = "e";
	
	private final static String ENCLOSURE_DISPLAY = "i";
	private final static String ENCLOSURE_ANIMALS = "a";
	private final static String ENCLOSURE_NEW = "n";
	
	private final static String AQUARIUM = "a";
	private final static String VOLIERE = "v";
	private final static String ENCLOS_STANDARD = "e";
	
	private final Zoo zoo;
	private final BufferedReader input;
	private boolean gameOver = false;
	private int nbAction;
	
	private AbstractEnclos selectedEnclos;
	
	public ZooGame(final Zoo zoo, final BufferedReader input) {
		this.zoo = zoo;
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
		System.out.println("Afficher tous les animaux : " + ANIMALS_DISPLAY_ALL);
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
	
	private void handleInput(final String input) {
		switch(input) {
			case MENU:
				menusHandler();
				break;
			case ENCLOSURE:
				enclosureHandler();
				break;
			case ANIMALS_DISPLAY_ALL:
				System.out.println(zoo.getAnimauxStr());
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
	
	/*--------------------------------MENU ENCLOS---------------------------*/
	
	private void displayEnclosure() {
		System.out.println("Menu enclos : ");
		System.out.println("Retour : " + RETURN);
		System.out.println("Infos : " + ENCLOSURE_DISPLAY);
		System.out.println("Animaux : " + ENCLOSURE_ANIMALS);
	}
	
	private boolean enclosureAction(final String input) {
		switch(input) {
			case RETURN:
				return true;
			case ENCLOSURE_DISPLAY:
				System.out.println(this.selectedEnclos);
				return false;
			case ENCLOSURE_ANIMALS:
				for (AbstractAnimal animal : this.selectedEnclos.getAnimaux()) {
					System.out.println(animal);
				}
				return false;
		}
		return false;
	}
	
	/*------------------------------CREATION D'ENCLOS-------------------------*/
	
	private boolean newEnclosureHandler(final String input) {
		switch(input) {
			case AQUARIUM:
				newAquarium();
				return true;
			case VOLIERE:
				newVoliere();
				return true;
			case ENCLOS_STANDARD:
				newEnclosStandard();
				return true;
		
		}
		return false;
	}
	
	private void displayNewEncolsure() {
		System.out.println("Choisi le type d'enclos à créer :");
		System.out.println("Aquarium : " + AQUARIUM);
		System.out.println("Volière : " + VOLIERE);
		System.out.println("Enclos standard : " + ENCLOS_STANDARD);
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
	
	/*--------------------------------aquarium--------------------------*/
	
	private void newAquarium(){
		System.out.println("Choisi le nom de ton aquarium");
		String aquariumName = null;
		try {
			aquariumName = input.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Quelle est la superficie en m² de ton aquarium ?");
		String superficieAquariumInput = null;
		float superficieAquarium;
		
		while (true) {
			try {
				superficieAquariumInput = input.readLine();
				
				superficieAquarium = Float.parseFloat(superficieAquariumInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer la superficie en chiffre.");
			}
		}
		
		System.out.println("Quel est le nombre maximum d'animaux que peut acceuillir cet aquarium ?");
		String nbAnimauxInput = null;
		int nbAnimaux;
		
		while (true) {
			try {
				nbAnimauxInput = input.readLine();
				
				nbAnimaux = Integer.parseInt(nbAnimauxInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer le nombre d'animaux en chiffres.");
			}
		}
		
		System.out.println("Quelle est la profondeur en m de ton aquarium ?");
		String profondeurInput = null;
		float profondeur;
		
		while (true) {
			try {
				profondeurInput = input.readLine();
				
				profondeur = Float.parseFloat(profondeurInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer la profondeur en chiffres.");
			}
		}
		
		Aquarium aquarium = new Aquarium(aquariumName, superficieAquarium, nbAnimaux, profondeur);
		
		zoo.ajouterEnclos(aquarium);
	}
	
	/*------------------------------------voliere---------------------------------------*/
	
	private void newVoliere(){
		System.out.println("Choisi le nom de ta voliere.");
		String voliereName = null;
		try {
			voliereName = input.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Quelle est la superficie en m² de ta voliere ?");
		String superficieVoliereInput = null;
		float superficieVoliere;
		
		while (true) {
			try {
				superficieVoliereInput = input.readLine();
				
				superficieVoliere = Float.parseFloat(superficieVoliereInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer la superficie en chiffre.");
			}
		}
		
		System.out.println("Quel est le nombre maximum d'animaux que peut acceuillir cette voliere ?");
		String nbAnimauxInput = null;
		int nbAnimaux;
		
		while (true) {
			try {
				nbAnimauxInput = input.readLine();
				
				nbAnimaux = Integer.parseInt(nbAnimauxInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer le nombre d'animaux en chiffres.");
			}
		}
		
		System.out.println("Quelle est la hauteur en m de ta volière ?");
		String hauteurInput = null;
		float hauteur;
		
		while (true) {
			try {
				hauteurInput = input.readLine();
				
				hauteur = Float.parseFloat(hauteurInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer la hauteur en chiffres.");
			}
		}
		
		Voliere voliere = new Voliere(voliereName, superficieVoliere, nbAnimaux, hauteur);
		
		zoo.ajouterEnclos(voliere);
	}
	
	/*---------------------------------------enclos standard---------------------------*/
	
	private void newEnclosStandard(){
		System.out.println("Choisi le nom de ton enclos.");
		String enclosName = null;
		try {
			enclosName = input.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Quelle est la superficie en m² de ton enclos ?");
		String superficieEnclosInput = null;
		float superficieEnclos;
		
		while (true) {
			try {
				superficieEnclosInput = input.readLine();
				
				superficieEnclos = Float.parseFloat(superficieEnclosInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer la superficie en chiffre.");
			}
		}
		
		System.out.println("Quel est le nombre maximum d'animaux que peut acceuillir cet enclos ?");
		String nbAnimauxInput = null;
		int nbAnimaux;
		
		while (true) {
			try {
				nbAnimauxInput = input.readLine();
				
				nbAnimaux = Integer.parseInt(nbAnimauxInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer le nombre d'animaux en chiffres.");
			}
		}
		
		EnclosStandard enclos = new EnclosStandard(enclosName, superficieEnclos, nbAnimaux);
		
		zoo.ajouterEnclos(enclos);
	}
	
	/**/
	private boolean selectEnclosure(final String input, boolean isReturn) {
		if (input.equals(RETURN)) {
			isReturn = true;
			return true;
		}
		else if (input.equals(ENCLOSURE_NEW)) {
			newEnclosure();
			return true;
		}
		for (AbstractEnclos enclos : zoo.getEnclos()) {
			if (enclos.getNomEnclos().equals(input)) {
				this.selectedEnclos = enclos;
				return true;
			}
		}
		return false;
	}
	
	private void displayAllEnclosures() {
		for (AbstractEnclos enclos : zoo.getEnclos()) {
			System.out.println(enclos);
		}
		System.out.println("Retour : " + RETURN);
		System.out.println("Nouvel enclos : " + ENCLOSURE_NEW);
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
	
	
}
