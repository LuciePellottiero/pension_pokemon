package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import enclos.AbstractEnclos;
import enclos.Aquarium;
import enclos.EnclosStandard;
import enclos.Voliere;
import joueur.Joueur;
import pension.Pension;
import pokemon.AbstractPokemon;
import pokemon.Bulbizarre;
import pokemon.Raichu;
import pokemon.Reptincel;
import pokemon.AbstractPokemon.Sexe;

public abstract class Main {
	
	private static BufferedReader bReader;
	
	private static final int NB_MAX_ENCLOS = 10;
	
	public static final String NOUVELLE_PARTIE = "n";
	public static final String QUITTER = "q";

	private static void intialisation() {
		bReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Bienvenue à la pension Pokemon !" + System.lineSeparator()); 
	}
	
	private static void fin() {
		try {
			bReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Merci et a+!");
	}

	private static void afficherMenu() {
		System.out.println("Menu : ");
		System.out.println("Nouvelle partie : " + NOUVELLE_PARTIE);
		System.out.println("Quitter : " + QUITTER);
	}
	
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
		
		System.out.println("Maintenant ton age.");
		String employeAgeInput = null;
		int employeAge;
		
		while (true) {
			try {
				employeAgeInput = bReader.readLine();
				
				employeAge = Integer.parseInt(employeAgeInput);
				break;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("Tu dois indiquer ton age en chiffre.");
			}
		}
		
		System.out.println("Enfin ton sexe : \"h\" pour homme et \"f\" pour femme.");
		AbstractPokemon.Sexe employeSexe;
		String employeSexeInput;
		while (true) {
			try {
				employeSexeInput = bReader.readLine();
				
				if (employeSexeInput.equals("h")) {
					employeSexe = Sexe.MALE;
					break;
				}
				else if (employeSexeInput.equals("f")) {
					employeSexe = Sexe.FEMELLE;
					break;
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Tu dois indiquer \"h\" pour homme et \"f\" pour femme");
		}
		
		Joueur employe = new Joueur(employeName, employeSexe, employeAge);
		
		System.out.println("Dernière chose, écrit le nom de ta pension.");
		String pensionName = null;
		try {
			pensionName = bReader.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Pension pension = new Pension(pensionName, employe, NB_MAX_ENCLOS);
		
		PensionGame game = new PensionGame(pension, bReader);
		game.play();
	}
	
	private static boolean actionMenu(String input) {
		switch (input) {
			case NOUVELLE_PARTIE :
				nouvellePartie();
				return false;
			case QUITTER :
				return true;
		}
		
		return false;
	}
	
	private static void gestionMenu() {
		
		String choix = "";
		
		while (!actionMenu(choix)) {
			afficherMenu();
			
			try {
				choix = bReader.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		intialisation();

		gestionMenu();
		
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
