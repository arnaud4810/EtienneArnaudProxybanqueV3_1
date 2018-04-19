package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;
	
	private String nom;
	private String prenom;
	private Adresse adresse;
	private String telephone;
	private Conseiller conseiller;
	

	/**
	 * @param idClient
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param telephone
	 */

	public Customer(int idClient, String nom, String prenom, Adresse adresse, String telephone, Conseiller conseiller) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.conseiller = conseiller;
	}
	
	

	/**
	 * 
	 */
	public Customer() {
		
	}



	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
	
}
