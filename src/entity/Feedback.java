package entity;

public class Feedback {
	
	private int idFeedback;
	private String descrizione;
	private int voto;
	private int idEdizione;
	private String idUtente;
	
	public Feedback(){}
	
	public Feedback(int idEdizione, String idUtente, String descrizione, int voto) {
		this.descrizione = descrizione;
		this.voto = voto;
		this.idEdizione=idEdizione;
		this.idUtente=idUtente;
	}
	
	public Feedback(String idUtente, String descrizione, int voto) {
		this.descrizione = descrizione;
		this.voto = voto;
		this.idUtente=idUtente;
	}
	public int getIdEdizione() {
		return idEdizione;
	}

	public void setIdEdizione(int idEdizione) {
		this.idEdizione = idEdizione;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdFeedback() {
		return idFeedback;
	}

	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getVoto() {
		return voto;
	}
	
	public void setVoto(int voto) {
		this.voto = voto;
	}

	@Override
	public String toString() {
		return "Feedback [idFeedback=" + idFeedback + ", descrizione=" + descrizione + ", voto=" + voto
				+ ", idEdizione=" + idEdizione + ", idUtente=" + idUtente + "]";
	}
}
