package evenement;

import java.util.concurrent.ThreadLocalRandom;

import animaux.AbstractAnimal;
import zoo.Zoo;

public class EvenementAnimalAction extends EvenementAction {

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 7978513932511704772L;
	
	private AbstractAnimal animal;
	private final static int CHANCE_DODO = 20;
	private final static int CHANCE_REVEIL = 75;
	private final static int CHANCE_FAIM = 20;
	
	public EvenementAnimalAction(AbstractAnimal animal){
		this.animal = animal;	
	}
	
	@Override
	public void verifEvenement(Zoo zoo) {
		
		int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		if(animal.isDodo()){
			if(random <= CHANCE_REVEIL){
				System.out.println(animal.emettreSon());
				System.out.println(animal.seReveiller());
			}
			
		}
		else{
			if (random <= CHANCE_DODO) {
				System.out.println(animal.sendormir());
			}
		}
		
		random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		if(!animal.isFaim()){
			if(random <= CHANCE_FAIM){
				System.out.println(animal.emettreSon());
				System.out.println(animal.aFaim());
			}
		}	
	}

}
