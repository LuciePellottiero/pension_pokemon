package main;

import java.io.BufferedReader;
import java.io.IOException;

import IHM.Menu;
import IHM.MenuAction;
import enclos.AbstractEnclos;
import enclos.Aquarium;
import enclos.EnclosStandard;
import enclos.Voliere;
import zoo.Zoo;

public class ZooGame {
	
	private final static int NB_ACTION_PER_TURN = 6;
	
	private final static String RETURN = "r";
	
	private final static String ENCLOSURE_DISPLAY = "i";
	private final static String ENCLOSURE_ANIMALS = "a";

	private final static String AQUARIUM = "a";
	private final static String VOLIERE = "v";
	private final static String ENCLOS_STANDARD = "e";
	
	private final Zoo zoo;
	private final BufferedReader reader;
	private boolean gameOver = false;
	private int nbAction;
	private static boolean quitter;
	
	public ZooGame(final Zoo zoo, final BufferedReader input) {
		this.zoo = zoo;
		this.reader = input;
	}
	
	private boolean menuQuitter() {
		Menu menu = new Menu("Menu", reader);
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
		
		Menu menuPrincipal = new Menu("Actions possibles", reader);
		
		menuPrincipal.addAction(new MenuAction("Menu", "m") {
			
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
		
		menuPrincipal.addAction(new MenuAction("Afficher tous les animaux", "a") {
			
			@Override
			public boolean action() {
				System.out.println(zoo.getAnimauxStr());
				return false;
			}
		});
		
		while (!gameOver) {
			
			//TODO random events.
			
			nbAction = 0;
			while(!gameOver && nbAction < NB_ACTION_PER_TURN) {
								
				menuPrincipal.menu();
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
	
	private void enclosureAction(final AbstractEnclos selectedEnclo) {
		
		/*switch(input) {
			case RETURN:
				return true;
			case ENCLOSURE_DISPLAY:
				System.out.println(selectedEnclo);
				return false;
			case ENCLOSURE_ANIMALS:
				for (AbstractAnimal animal : selectedEnclo.getAnimaux()) {
					System.out.println(animal);
				}
				return false;
		}*/
		return;
	}
	
	/*------------------------------CREATION D'ENCLOS-------------------------*/
	
	private String chooseEnclosureName() {
		String name = "";
		
		while(name.length() < 2) {
			System.out.println("Entrez nom de l'enclo (au moins deux charactères) : ");
			
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
	
	private boolean newEnclosure() {
		
		Menu newEnclosure = new Menu("Nouvel enclos", reader);
		
		newEnclosure.addAction(new MenuAction("Aquarium", "a") {
			
			@Override
			public boolean action() {
				Aquarium newAquarium = newAquarium();
				enclosureAction(newAquarium);
				quitter = true;
				return true;
			}
		});
		
		newEnclosure.addAction(new MenuAction("Volière", "v") {
			
			@Override
			public boolean action() {
				newVoliere();
				quitter = true;
				return true;
			}
		});
		
		newEnclosure.addAction(new MenuAction("Enclos standard", "e") {
			
			@Override
			public boolean action() {
				newEnclosStandard();
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
	
	/*--------------------------------aquarium--------------------------*/
	
	private Aquarium newAquarium(){
		String aquariumName = chooseEnclosureName();
		
		float superficieAquarium = chooseNumber("Quelle est la superficie en m² de ton aquarium ?");
		
		int nbAnimaux = (int) chooseNumber("Quel est le nombre maximum d'animaux que peut acceuillir cet aquarium ?");

		float profondeur = chooseNumber("Quelle est la profondeur en m de ton aquarium ?");
		
		Aquarium aquarium = new Aquarium(aquariumName, superficieAquarium, nbAnimaux, profondeur);
		
		zoo.ajouterEnclos(aquarium);
		return aquarium;
	}
	
	/*------------------------------------voliere---------------------------------------*/
	
	private void newVoliere(){

		String voliereName = chooseEnclosureName();

		float superficieVoliere = chooseNumber("Quelle est la superficie en m² de ta voliere ?");
		
		int nbAnimaux = (int) chooseNumber("Quel est le nombre maximum d'animaux que peut acceuillir cette voliere ?");

		float hauteur = chooseNumber("Quelle est la hauteur en m de ta volière ?");
		
		Voliere voliere = new Voliere(voliereName, superficieVoliere, nbAnimaux, hauteur);
		
		zoo.ajouterEnclos(voliere);
	}
	
	/*---------------------------------------enclos standard---------------------------*/
	
	private void newEnclosStandard(){
		String enclosName = chooseEnclosureName();
		
		float superficieEnclos = chooseNumber("Quelle est la superficie en m² de ton enclos ?");

		int nbAnimaux = (int) chooseNumber("Quel est le nombre maximum d'animaux que peut acceuillir cet enclos ?");
		
		EnclosStandard enclos = new EnclosStandard(enclosName, superficieEnclos, nbAnimaux);
		
		zoo.ajouterEnclos(enclos);
	}
	
	private void menuEnclosPrinc() {
		
		Menu enclosMenu = new Menu("Choix enclos : ", reader);
		
		for (AbstractEnclos enclos : zoo.getEnclos()) {
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
