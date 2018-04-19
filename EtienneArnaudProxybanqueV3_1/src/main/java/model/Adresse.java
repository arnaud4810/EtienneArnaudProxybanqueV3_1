package model;

<<<<<<< HEAD
public class Adresse {

	
=======

public class Adresse {

	
	private int numero;
	private String typeVoie;
	private String nomVoie;
	private String codePostal;
	private String ville;
	
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
	
	
	
	
	
>>>>>>> 4bf8de8b7d2c68ab748f38e6249440b8c6107974
}
