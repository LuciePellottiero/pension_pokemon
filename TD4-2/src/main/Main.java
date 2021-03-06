package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import IHM.Menu;
import IHM.MenuAction;
import animaux.IAnimal;
import employe.Employe;
import zoo.Zoo;

public abstract class Main {
	
	public static BufferedReader bReader;
	
	private static final int NB_MAX_ENCLOS = 10;
	
	private static IAnimal.Sexe employeSexe;
	private static String chosenSave;
	public static final String SAVE_FOLDER = "save" + File.separatorChar;
	private static boolean quitter;

	//initialisation
	private static void intialisation() {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		
		File saveFolder = new File(SAVE_FOLDER);
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		
		System.out.println("Bienvenue dans Zoo!" + System.lineSeparator()); 
	}
	
	private static float chooseNumber(final String question) {
		float inputFinal;
		String input;
		
		while (true) {
			System.out.println(question);
			try {
				input = bReader.readLine();
				
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
	
	//nouvelle partie (creation du joueur)
	private static void nouvellePartie() {
		System.out.println("C'est parti!");
		
		System.out.println("Commence par écrire ton nom.");
		String employeName = null;
		try {
			employeName = bReader.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		int employeAge = (int) chooseNumber("Entre ton âge");
		
		Menu choixSexe = new Menu("Choix du sexe", bReader);
		choixSexe.addAction(new MenuAction("Homme", "h") {
			
			@Override
			public boolean action() {
				employeSexe = IAnimal.Sexe.MALE;
				return true;
			}
		});
		
		choixSexe.addAction(new MenuAction("Femme", "f") {
			
			@Override
			public boolean action() {
				employeSexe = IAnimal.Sexe.FEMELLE;
				return true;
			}
		});
		
		choixSexe.menu();
		
		Employe employe = new Employe(employeName, employeSexe, employeAge);
		
		System.out.println("Dernière chose, écrit le nom de ton zoo.");
		String zooName = null;
		try {
			zooName = bReader.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Zoo zoo = new Zoo(zooName, employe, NB_MAX_ENCLOS);
		
		ZooGame game = new ZooGame(zoo, bReader);
		game.play();
	}
	
	private static void fin() {
		System.out.println("Merci et a+");
		try {
			bReader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean chooseGame() {
		Menu menu = new Menu("Choisissez la sauvegarde", bReader);
		
		menu.addAction(new MenuAction("Retour", "r") {
			@Override
			public boolean action() {
				quitter = false;
				return true;
			}
		});
		
		File saveFolder = new File(SAVE_FOLDER);
		
		for (File fileEntry : saveFolder.listFiles()) {
		    if (fileEntry.isDirectory()) {
		        continue;
		    } 
		    else {
		        menu.addAction(new MenuAction(fileEntry.getName(), fileEntry.getName()) {
					
					@Override
					public boolean action() {
						chosenSave = fileEntry.getAbsolutePath();
						quitter = true;
						return true;
					}
				});
		    }
		}; 
		
		menu.menu();
		
		return quitter;
	}
	
	public static boolean loadGame() {
		ZooGame game = null;
		
		if (!chooseGame()) {
			return false;
		}
		
	    try {
	       FileInputStream fileIn = new FileInputStream(chosenSave);
	       ObjectInputStream in = new ObjectInputStream(fileIn);
	       game = (ZooGame) in.readObject();
	       in.close();
	       fileIn.close();
	    }
	    catch(IOException i) {
	       i.printStackTrace();
	       return false;
	    }
	    catch(ClassNotFoundException c) {
	       c.printStackTrace();
	       return false;
	    }
	    
	    game.play();
	    
		return true;
	}

	public static void main(String[] args) {

		intialisation();	

		Menu mainMenu = new Menu("Menu principal", bReader);
		mainMenu.addAction(new MenuAction("Nouvelle partie", "n") {
			
			@Override
			public boolean action() {
				nouvellePartie();
				return true;
			}
		});
		
		mainMenu.addAction(new MenuAction("Charger partie", "c") {
			
			@Override
			public boolean action() {
				return loadGame();
			}
		});
		
		mainMenu.addAction(new MenuAction("Quitter", "q") {
			
			@Override
			public boolean action() {
				return true;
			}
		});
		
		mainMenu.menu();
		fin();

		/*Employe philipe = new Employe("Philipe", Sexe.MALE, 42);

		Zoo zoo = new Zoo("Zoo tycoon", philipe, 4);

		AbstractEnclos enclosStandard = new EnclosStandard("La cage de Gaspard", 20, 2);		
		AbstractEnclos aquarium = new Aquarium("L'aquarium de Winry", 200, 1, 8);
		AbstractEnclos voliere = new Voliere("L'enclo de Klaus", 10, 3, 5);

		zoo.ajouterEnclos(enclosStandard);
		zoo.ajouterEnclos(voliere);
		zoo.ajouterEnclos(aquarium);

		AbstractAnimal pingouin = new Pingouin("Klaus", Sexe.MALE, 18, 1, 9);

		System.out.println(pingouin.emettreSon());
		System.out.println(pingouin.manger());
		System.out.println(pingouin);

		voliere.ajouterAnimal(pingouin);

		System.out.println(voliere);

		System.out.println(philipe.nourrir(voliere));

		AbstractAnimal baleine = new Baleine("Winry", Sexe.FEMELLE, 6000, 20, 20);

		System.out.println(baleine.emettreSon());
		System.out.println(baleine.manger());
		System.out.println(baleine.sendormir(1));
		System.out.println(baleine);

		aquarium.ajouterAnimal(baleine);
		System.out.println(aquarium);

		((Mammifere) baleine).MettreBas();

		AbstractAnimal tigre = new Tigre("Gaspard", Sexe.MALE, 20, 1, 5);
		System.out.println(tigre);

		enclosStandard.ajouterAnimal(tigre);

		((Mammifere) tigre).MettreBas();

		System.out.println(enclosStandard);

		System.out.println(zoo.getAnimauxStr());*/
	}

}
