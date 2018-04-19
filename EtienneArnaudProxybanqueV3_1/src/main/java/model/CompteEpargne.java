package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COMPTEDEPARGNE")
public class CompteEpargne extends Comptes {

	private double tauxRemuneration;
		
	public CompteEpargne() {
		// TODO Auto-generated constructor stub
	}

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	
	
	
}
