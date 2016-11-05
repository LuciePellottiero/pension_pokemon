package evenement;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import enclos.AbstractEnclos;
import enclos.Proprete;
import zoo.Zoo;

public class EvenementEnclos extends EvenementTour{

	/**
	 * @see Serializable
	 */
	private static final long serialVersionUID = 3187678995873192467L;
	
	private AbstractEnclos enclos;
	private final static int CHANCE_SALISURE = 25;
	
	public EvenementEnclos(AbstractEnclos enclos){
		this.enclos = enclos;	
	}
	
	@Override
	public void verifEvenement(Zoo zoo) {
		int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		if(random < CHANCE_SALISURE){
			random = ThreadLocalRandom.current().nextInt(0, enclos.getPropretes().size() - 1);
			Iterator<Proprete> propreteIter = enclos.getPropretes().iterator();
			for(int i = 0; i < random; ++i){
				propreteIter.next();
			}
			
			System.out.println(propreteIter.next().deteriore());
		}
		
	}

}
