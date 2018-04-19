package model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;

	private String nom;
	private String prenom;
	private String telephone;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "idAdresse", unique = true)
	private Adresse adresse;
	
	/**
	 * @param CascasdeType.PERSIST et CascadeType.REMOVE permettent de persister et supprimer l'adresse en meme temps que le customer
	 *
	 * @param Adresse
	 *            La table client possède la clef étrangère pour la table adresse
	 */

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "idConseiller")
	private Conseiller conseiller;
	
	@OneToMany(mappedBy="customer", cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Comptes> customerAssociatedComptes = new HashSet<>();
	
	

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

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Set<Comptes> getCustomerAssociatedComptes() {
		return customerAssociatedComptes;
	}

	public void setCustomerAssociatedComptes(Set<Comptes> customerAssociatedComptes) {
		this.customerAssociatedComptes = customerAssociatedComptes;
	}
	
	

}
