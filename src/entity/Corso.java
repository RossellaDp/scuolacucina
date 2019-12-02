package entity;

public class Corso {
	
	private int codice;
	private String titolo;
	private int idCategoria;
	private int maxPartecipanti;
	private double costo;
	private String descrizione;
	
	public Corso() {}

	public Corso(String titolo, int idCategoria,
			int maxPartecipanti, double costo, String descrizione) {
		
		this.titolo = titolo;
		this.idCategoria = idCategoria;
		this.maxPartecipanti = maxPartecipanti;
		this.costo = costo;
		this.descrizione = descrizione;
	}

	public int getCodice() {
		return this.codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}

	public void setMaxPartecipanti(int maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Corso [codice=" + codice + ", titolo=" + titolo + ", idCategoria=" + idCategoria + ", maxPartecipanti="
				+ maxPartecipanti + ", costo=" + costo + ", descrizione=" + descrizione + "]";
	}
	
}
