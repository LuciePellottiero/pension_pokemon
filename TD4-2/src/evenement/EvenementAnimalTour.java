package evenement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

import animaux.AbstractAnimal;
import animaux.AbstractAnimal.Sexe;
import enclos.AbstractEnclos;
import zoo.Zoo;

public class EvenementAnimalTour extends EvenementTour{
	
	private final static int CHANCE_MALADE = 30;
	private final static int CHANCE_BEBE = 10;
	
	private final AbstractAnimal animal;
	
	public EvenementAnimalTour(final AbstractAnimal animal) {
		this.animal = animal;
	}

	@Override
	public void verifEvenement(Zoo zoo) {
		int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		
		if(!animal.isMalade()){
			if(random <= CHANCE_MALADE){
				System.out.println(animal.emettreSon());
				System.out.println(animal.tombeMalade());
			}
		}
		
		random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		if(random <= CHANCE_BEBE && animal.getSexe() == Sexe.FEMELLE) {
			for(AbstractEnclos enclos : zoo.getEnclos()) {
				if(enclos.getAnimaux().contains(animal)) {
					boolean hasMale = false;
					for (AbstractAnimal currentAnimal : enclos.getAnimaux()) {
						if(currentAnimal.getSexe() == Sexe.MALE) {
							hasMale = true;
							break;
						}
					}
					
					if (hasMale && enclos.getNbAnimaux() < enclos.getNbMaxAnimaux()) {
						
						String name = "";
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						System.out.println(animal.getNom() + " va avoir un bébé!");
						while(true) {
							while(name.length() < 2) {
								System.out.println("Entrez le nom du bébé (au moins deux charactères) : ");
								
								try {
									name = reader.readLine();
								} 
								catch (IOException e) {
									e.printStackTrace();
								}
								
							}
							for (AbstractAnimal animal : enclos.getAnimaux()) {
								if (animal.getNom().equals(name)) {
									System.err.println("Un autre animal de cet enclos porte déjà ce nom");
									continue;
								}
							}
							break;
						}
						
						AbstractAnimal bebe;
						try {
							bebe = animal.seReproduire(name);
							enclos.ajouterAnimal(bebe);
						} 
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}

}
