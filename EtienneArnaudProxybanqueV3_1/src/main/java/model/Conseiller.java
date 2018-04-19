package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conseiller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idConseiller;
	
	@Column(name = "Nom_Conseiller")
	private String nom;
	@Column(name = "Prenom_Conseiller")
	private String prenom;
	@Column(name = "Login_Conseiller")
	private String login;
	@Column(name = "Password_Conseiller")
	private String password;
		
	/**
	 * 
	 */
	public Conseiller() {
	
	}
	
	/**
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
	
	
}
