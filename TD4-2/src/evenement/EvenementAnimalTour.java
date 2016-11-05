package evenement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

import animaux.AbstractAnimal;
import animaux.IAnimal;
import enclos.AbstractEnclos;
import zoo.Zoo;

public class EvenementAnimalTour extends EvenementTour{
	
	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = -2921241511488905808L;
	
	private final static int CHANCE_MALADE = 30;
	private final static int CHANCE_BEBE = 100;
	
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
		if(random <= CHANCE_BEBE && animal.getSexe() == IAnimal.Sexe.FEMELLE) {
			
			AbstractAnimal bebe = null;
			String name = "";
			
			for(AbstractEnclos enclos : zoo.getEnclos()) {
				if(enclos.getAnimaux().contains(animal)) {
					boolean hasMale = false;
					for (AbstractAnimal currentAnimal : enclos.getAnimaux()) {
						if(currentAnimal.getSexe() == IAnimal.Sexe.MALE) {
							hasMale = true;
							break;
						}
					}
					
					if (hasMale && enclos.getNbAnimaux() < enclos.getNbMaxAnimaux()) {
						
						
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						
						try {
							bebe = animal.seReproduire(name);
						} 
						catch (Exception e1) {
							e1.printStackTrace();
						}
						
						System.out.println(animal.getNom() + " a eu un bébé!");
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
						enclos.ajouterAnimal(bebe);
						break;
					}
				}
			}
		}
		
	}

}
