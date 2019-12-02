package entity;

import java.util.Date;

public class Edizione {
	
	private int idEdizione; 
	private int idCorso;
	private Corso corso;
	private Date dataInizio;
	private int durata;
	private String aula;
	private String docente;
	private boolean terminata = false;
	
	public Edizione() {}
	
	public Edizione(int idEdizione, int idCorso, Date dataInizio, int durata, String aula, String docente) {	
		this.idEdizione = idEdizione;
		this.idCorso=idCorso;
		this.dataInizio = dataInizio;
		this.durata = durata;
		this.aula = aula;
		this.docente = docente;
	}
	
	public Edizione(int idCorso, Date dataInizio, int durata, String aula, String docente) {	
		this.idCorso=idCorso;
		this.dataInizio = dataInizio;
		this.durata = durata;
		this.aula = aula;
		this.docente = docente;
	}
	
	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public int getIdCorso(){
		return idCorso;
	}
	public int getCodice() {
		return idEdizione;
	}
	public void setCodice(int idEdizione) {
		this.idEdizione = idEdizione;
	}
	
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public boolean isTerminata() {
		return terminata;
	}

	public void setTerminata(boolean terminata) {
		this.terminata = terminata;
	}	
	
	public boolean isIniziata() {
		Date datainizioed = this.getDataInizio();
		return datainizioed.before(new Date());
	}

	@Override
	public String toString() {
		return "Edizione [codice=" + idEdizione + ", idCorso=" + idCorso + ", corso=" + corso + ", dataInizio=" + dataInizio
				+ ", durata=" + durata + ", aula=" + aula + ", docente=" + docente + ", terminata=" + terminata + "]";
	}
	
}
