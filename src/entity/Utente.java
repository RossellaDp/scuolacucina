package entity;

import java.util.Date;

public class Utente {
	
	private String idUtente;
	private String password;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String email;
	private String telefono;
	private boolean admin; 
	
	public Utente (){}

	public Utente(String idUtente, String password, String nome, String cognome,
			Date dataNascita, String email, String telefono, boolean admin) {
		
		this.idUtente = idUtente;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.telefono = telefono;
		this.admin = admin;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
		
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String toString(){
		return "idUtente: " + this.idUtente + "\nPassword: " + this.password + "\nNome: " + this.nome + "\nCognome: " + this.cognome + "\nData di Nascita: " + this.dataNascita + "\nEmail: " + this.email + "\nTelefono: " + this.telefono + "\nAmministratore? " + this.admin;
	}
}
