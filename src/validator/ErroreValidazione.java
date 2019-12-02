package validator;

public class ErroreValidazione {
	private String campoValidato;
	private String descrizioneErrore;
	
	public ErroreValidazione(){}
	
	public ErroreValidazione(String campoValidato, String descrizioneErrore) {
		this.campoValidato = campoValidato;
		this.descrizioneErrore = descrizioneErrore;
	}

	public String getCampoValidato() {
		return campoValidato;
	}

	public void setCampoValidato(String campoValidato) {
		this.campoValidato = campoValidato;
	}

	public String getDescrizioneErrore() {
		return descrizioneErrore;
	}

	public void setDescrizioneErrore(String descrizioneErrore) {
		this.descrizioneErrore = descrizioneErrore;
	}

	@Override
	public String toString() {
		return "ErroreValidazione [campoValidato=" + campoValidato + ", descrizioneErrore=" + descrizioneErrore + "]";
	}
	
}
