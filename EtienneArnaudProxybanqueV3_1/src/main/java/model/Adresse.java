package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAdresse;
	/**
	 * @param idAdresse
	 * Solution pour avoir une clef primaire générée automatiquement.
	 */
	
	private int numero;
	private String typeVoie;
	private String nomVoie;
	private String codePostal;
	private String ville;
	
	/**
	 * @param Customer
	 * Customer est propriétaire de l'adresse.
	 */
	
	@OneToOne(mappedBy = "adresse")
	private Customer customer;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTypeVoie() {
		return typeVoie;
	}

	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Adresse(int numero, String typeVoie, String nomVoie, String codePostal, String ville) {
		super();
		this.numero = numero;
		this.typeVoie = typeVoie;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse() {

	}

}
