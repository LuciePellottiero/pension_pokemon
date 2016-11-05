package evenement;

import java.io.Serializable;

import zoo.Zoo;

public interface IEvenement extends Serializable{
	public void verifEvenement(Zoo zoo);
}
