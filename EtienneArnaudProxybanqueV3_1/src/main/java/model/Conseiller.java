package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conseiller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idConseiller;

	private String nom;
	private String prenom;
	private String login;
	private String password;

	@OneToMany(mappedBy = "conseiller", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Customer> conseillerAssociatedCustomer = new HashSet<>();

	/**
	 * @param constructeur
	 *            par défaut du conseiller.
	 */
	public Conseiller() {

	}

	/**
	 * @param constructeur
	 *            du conseiller avec les paramètres.
	 * @param idConseiller
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param password
	 */

	public Conseiller(int idConseiller, String nom, String prenom, String login, String password) {
		super();
		this.idConseiller = idConseiller;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Customer> getConseillerAssociatedCustomer() {
		return conseillerAssociatedCustomer;
	}

	public void setConseillerAssociatedCustomer(Set<Customer> conseillerAssociatedCustomer) {
		this.conseillerAssociatedCustomer = conseillerAssociatedCustomer;
	}

}
