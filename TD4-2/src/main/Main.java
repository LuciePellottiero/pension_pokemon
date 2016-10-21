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
import pokemon.Pikachu;
import pokemon.Poichigeon;
import pokemon.Raichu;
import pokemon.Reptincel;
import pokemon.Salameche;
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

		/*intialisation();

		gestionMenu();
		
		fin();*/
		
		

		Joueur philipe = new Joueur("Philipe", Sexe.MALE, 42);

		Pension pension = new Pension("Pension tycoon", philipe, 4);

		AbstractEnclos enclosStandard = new EnclosStandard("La cage de Gaspard", 20, 2);		
		AbstractEnclos aquarium = new Aquarium("L'aquarium de Winry", 200, 1, 8);
		AbstractEnclos voliere = new Voliere("L'enclo de Klaus", 10, 3, 5);

		pension.ajouterEnclos(enclosStandard);
		pension.ajouterEnclos(voliere);
		pension.ajouterEnclos(aquarium);

		AbstractPokemon poichigeon = new Poichigeon("GlouGlou", Sexe.MALE, 18, 1, 9);

		System.out.println(poichigeon.emettreSon());
		System.out.println(poichigeon.manger());
		System.out.println(poichigeon);

		voliere.ajouterPokemon(poichigeon);

		System.out.println(voliere);

		System.out.println(philipe.nourrir(voliere));

		/*AbstractPokemon pikachu = new Pikachu("Pikachu", Sexe.FEMELLE, 6000, 20, 20);

		System.out.println(pikachu.emettreSon());
		System.out.println(pikachu.manger());
		System.out.println(pikachu.sendormir(1));
		System.out.println(pikachu);

		aquarium.ajouterPokemon(pikachu);
		System.out.println(aquarium);

		(pikachu).MettreBas();

		AbstractPokemon salameche = new Salameche("Gaspard", Sexe.MALE, 20, 1, 5);
		System.out.println(salameche);

		enclosStandard.ajouterPokemon(salameche);

		(salameche).MettreBas();*/

		System.out.println(enclosStandard);

		System.out.println(pension.getPokemonStr());
	}

}
