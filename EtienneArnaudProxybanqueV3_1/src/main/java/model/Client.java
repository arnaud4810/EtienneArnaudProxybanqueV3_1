package model;

public class Client {
private int idClient;
private String nom;
private String prenom;
private String adresse;
private String codePostal;
private String ville;
private String telephone;


public Client(int idClient, String nom, String prenom, String adresse, String codePostal, String ville,
		String telephone) {
	super();
	this.idClient = idClient;
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.codePostal = codePostal;
	this.ville = ville;
	this.telephone = telephone;
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

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
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

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}


}
