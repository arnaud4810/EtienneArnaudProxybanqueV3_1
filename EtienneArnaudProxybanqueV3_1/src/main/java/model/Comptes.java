package model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="COMPTE_TYPE" )
public abstract class Comptes {

	@Id
	@GeneratedValue
	private int numero;

	private double solde;
	private String dateOuverture;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "")
	private Customer client;

	/**
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 * @param client
	 */
	public Comptes(int numero, double solde, String dateOuverture, Customer client) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client = client;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}

	public Comptes() {

	}

}
