package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COMPTECOURANT")
public class CompteCourant extends Comptes {

	private double decouvertMax;
	
	public CompteCourant() {

	}

	public double getDecouvertMax() {
		return decouvertMax;
	}

	public void setDecouvertMax(double decouvertMax) {
		this.decouvertMax = decouvertMax;
	}
	
	

}

