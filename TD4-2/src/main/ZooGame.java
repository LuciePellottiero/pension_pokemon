package main;

import java.io.BufferedReader;
import java.io.IOException;

import IHM.Menu;
import IHM.MenuAction;
import animaux.AbstractAnimal;
import animaux.AbstractAnimal.Sexe;
import animaux.AnimalFactory;
import enclos.AbstractEnclos;
import enclos.Aquarium;
import enclos.EnclosStandard;
import enclos.Voliere;
import zoo.Zoo;

public class ZooGame {
	
	private final static int NB_ACTION_PER_TURN = 6;
	
	private final Zoo zoo;
	private final BufferedReader reader;
	private boolean gameOver = false;
	private static int nbAction;
	public static boolean quitter;
	private static Sexe animalSexe;
	
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
		
		menuPrincipal.addAction(new MenuAction("Afficher tous les animaux", "a") {
			
			@Override
			public boolean action() {
				System.out.println(zoo.getAnimauxStr());
				return false;
			}
		});
		
		while (!gameOver) {
			
			nbAction = 0;
			System.out.println("New turn");
			//TODO random events.
			while(!gameOver && nbAction < NB_ACTION_PER_TURN) {
				menuPrincipal.menu();
			}
		}
	}
	
	public static void useActionPoint() {
		++nbAction;
		System.out.println("Action effectuée (" + (NB_ACTION_PER_TURN - nbAction) + " actions restantes)");
	}
	
	/*--------------------------------MENU ENCLOS SELECTIONNE---------------------------*/
	
	private void enclosureAction(final AbstractEnclos selectedEnclos) {
		
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
				System.out.println(zoo.getEmploye().examinerEnclos(selectedEnclos));
				return false;
			}
		});
		
		enclosureMenu.addAction(new MenuAction("Nettoyer", "ne") {
			
			@Override
			public boolean action() {
				System.out.println(zoo.getEmploye().nettoyer(selectedEnclos));
				return false;
			}
		});
		
		enclosureMenu.addAction(new MenuAction("Nourrir les animaux de l'enclos", "no") {
			
			@Override
			public boolean action() {
				System.out.println(zoo.getEmploye().nourrir(selectedEnclos));
				return false;
			}
		});
		
		enclosureMenu.addAction(new MenuAction("Sélectionner des animaux", "a") {
			
			@Override
			public boolean action() {
				return animalMenu(selectedEnclos);
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
	
	private boolean animalMenu(final AbstractEnclos selectedEnclos) {
		Menu animalMenu = new Menu("Choix animal : ", reader);
		
		for (AbstractAnimal animal : selectedEnclos.getAnimaux()) {
			animalMenu.addAction(new MenuAction("selectionner " + animal.getNom(), animal.getNom()) {
				
				@Override
				public boolean action() {
					animalAction(animal, selectedEnclos);
					return true;
				}
			});
		}
		
		animalMenu.addAction(new MenuAction("Nouvel animal", "n") {
			
			@Override
			public boolean action() {
				quitter = newAnimal(selectedEnclos);
				return true;
			}
		});
		
		animalMenu.addAction(new MenuAction("Retour", "r") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		
		animalMenu.menu();
		return quitter;
	}
	
	/*------------------------------CREATION ANIMAL---------------------------*/
	
	//TODO choisir type d'animal et sexe avant son nom
	public class NewAnimalMenuAction extends MenuAction{
		
		private AbstractEnclos selectedEnclo;
		private final String name;
		private final Sexe sexe;
		
		public NewAnimalMenuAction(final String action, final String input, AbstractEnclos selectedEnclo, final String name, final Sexe sexe) {
			super(action, input);
			this.selectedEnclo = selectedEnclo;
			this.name = name;
			this.sexe = sexe;
		}

		@Override
		public boolean action() {

			try {
				AbstractAnimal newAnimal = AnimalFactory.createAnimal(this.getAction(), name, sexe);
				selectedEnclo.ajouterAnimal(newAnimal);
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
	
	private boolean newAnimal(AbstractEnclos selectedEnclo) {
				
		String name;
		while(true) {
			name = chooseName();
			for (AbstractAnimal animal : selectedEnclo.getAnimaux()) {
				if (animal.getNom().equals(name)) {
					System.err.println("Un autre animal de cet enclos porte déjà ce nom");
					continue;
				}
			}
			break;
		}
		
		Menu choixSexe = new Menu("Choix du sexe", reader);
		choixSexe.addAction(new MenuAction("Mâle", "m") {
			
			@Override
			public boolean action() {
				animalSexe = Sexe.MALE;
				return true;
			}
		});
		
		choixSexe.addAction(new MenuAction("Femmelle", "f") {
			
			@Override
			public boolean action() {
				animalSexe = Sexe.FEMELLE;
				return true;
			}
		});
		choixSexe.menu();
		
		Menu animalCreation = new Menu("Choisi la race d'animal", reader);
		
		animalCreation.addAction(new NewAnimalMenuAction("Aigle", "ai", selectedEnclo, name, animalSexe));
		animalCreation.addAction(new NewAnimalMenuAction("Baleine", "ba", selectedEnclo, name, animalSexe));
		animalCreation.addAction(new NewAnimalMenuAction("Loup", "lo", selectedEnclo, name, animalSexe));
		animalCreation.addAction(new NewAnimalMenuAction("Ours", "ou", selectedEnclo, name, animalSexe));
		animalCreation.addAction(new NewAnimalMenuAction("Pingouin", "pi", selectedEnclo, name, animalSexe));
		animalCreation.addAction(new NewAnimalMenuAction("Poisson rouge", "pr", selectedEnclo, name, animalSexe));
		animalCreation.addAction(new NewAnimalMenuAction("Requin", "re", selectedEnclo, name, animalSexe));
		animalCreation.addAction(new NewAnimalMenuAction("Tigre", "ti", selectedEnclo, name, animalSexe));
		
		animalCreation.addAction(new MenuAction("Retour", "r") {
			
			@Override
			public boolean action() {
				quitter = false;
				return true;
			}
		});
		
		animalCreation.menu();
		return quitter;
	}
	
	/*------------------------------MENU ANIMAL SELECTIONNE-------------------------------*/
	
	private void animalAction(AbstractAnimal selectedAnimal, AbstractEnclos selectedEnclos) {

		Menu animalMenu = new Menu("Menu de l'animal " + selectedAnimal.getNom(), reader);
		
		animalMenu.addAction(new MenuAction("Retour ", "r") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		animalMenu.addAction(new MenuAction("Infos", "i") {
			
			@Override
			public boolean action() {
				System.out.println(selectedAnimal.toString());
				return false;
			}
		});
		
		animalMenu.addAction(new MenuAction("Soigner", "s") {
			
			@Override
			public boolean action() {
				System.out.println(selectedAnimal.etreSoigne(1));
				return false;
			}
		});
		
		animalMenu.addAction(new MenuAction("Réveiller", "rev") {
			
			@Override
			public boolean action() {
				System.out.println(selectedAnimal.seReveiller());
				return false;
			}
		});
		
		animalMenu.addAction(new MenuAction("Transférer", "t") {
			
			@Override
			public boolean action() {
				transfererAnimal(selectedAnimal, selectedEnclos);
				return false;
			}
		});
		
	
		animalMenu.addAction(new MenuAction("Renommer l'animal", "re") {
			
			@Override
			public boolean action() {
				selectedAnimal.setNom(chooseName());
				return true;
			}
		});
		
		animalMenu.menu();
		return;
	}
	
	public void transfererAnimal(AbstractAnimal selectedAnimal, AbstractEnclos selectedEnclos){
		Menu transfereMenu = new Menu("Selectionner le nouvel enclos de l'animal " + selectedAnimal.getNom(), reader);
		transfereMenu.addAction(new MenuAction("Retour", "r") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		
		for(AbstractEnclos enclos : zoo.getEnclos()){
			transfereMenu.addAction(new MenuAction("Selectionner " + enclos.getNomEnclos(), enclos.getNomEnclos()) {
				
				@Override
				public boolean action() {
					try{
						System.out.println(zoo.getEmploye().transferer(selectedAnimal, selectedEnclos, enclos));
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
		
		newEnclosure.addAction(new MenuAction("Aquarium", "a") {
			
			@Override
			public boolean action() {
				Aquarium newAquarium = newAquarium();
				useActionPoint();
				// If there is no action point left, then go back to main menu
				if (nbAction < NB_ACTION_PER_TURN) {
					enclosureAction(newAquarium);
				}
				quitter = true;
				return true;
			}
		});
		
		newEnclosure.addAction(new MenuAction("Volière", "v") {
			
			@Override
			public boolean action() {
				Voliere newVoliere = newVoliere();
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
	
	/*--------------------------------aquarium--------------------------*/
	
	private Aquarium newAquarium(){
		String aquariumName = chooseName();
		
		float superficieAquarium = chooseNumber("Quelle est la superficie en m² de ton aquarium ?");
		
		int nbAnimaux = (int) chooseNumber("Quel est le nombre maximum d'animaux que peut acceuillir cet aquarium ?");

		float profondeur = chooseNumber("Quelle est la profondeur en m de ton aquarium ?");
		
		Aquarium aquarium = new Aquarium(aquariumName, superficieAquarium, nbAnimaux, profondeur);
		
		zoo.ajouterEnclos(aquarium);
		return aquarium;
	}
	
	/*------------------------------------voliere---------------------------------------*/
	
	private Voliere newVoliere(){

		String voliereName = chooseName();

		float superficieVoliere = chooseNumber("Quelle est la superficie en m² de ta voliere ?");
		
		int nbAnimaux = (int) chooseNumber("Quel est le nombre maximum d'animaux que peut acceuillir cette voliere ?");

		float hauteur = chooseNumber("Quelle est la hauteur en m de ta volière ?");
		
		Voliere voliere = new Voliere(voliereName, superficieVoliere, nbAnimaux, hauteur);
		
		zoo.ajouterEnclos(voliere);
		
		return voliere;
	}
	
	/*---------------------------------------enclos standard---------------------------*/
	
	private EnclosStandard newEnclosStandard(){
		String enclosName = chooseName();
		
		float superficieEnclos = chooseNumber("Quelle est la superficie en m² de ton enclos ?");

		int nbAnimaux = (int) chooseNumber("Quel est le nombre maximum d'animaux que peut acceuillir cet enclos ?");
		
		EnclosStandard enclos = new EnclosStandard(enclosName, superficieEnclos, nbAnimaux);
		
		zoo.ajouterEnclos(enclos);
		
		return enclos;
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
