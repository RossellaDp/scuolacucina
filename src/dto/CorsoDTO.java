package dto;

import java.util.List;

import entity.Corso;

public class CorsoDTO {
	private Corso corso;
	private List<EdizioneDTO> listaEdizioni;
	
	public CorsoDTO(){}
	
	public CorsoDTO(Corso corso, List<EdizioneDTO> listaEdizioni) {
		this.corso = corso;
		this.listaEdizioni = listaEdizioni;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public List<EdizioneDTO> getListaEdizioni() {
		return listaEdizioni;
	}

	public void setListaEdizioni(List<EdizioneDTO> listaEdizioni) {
		this.listaEdizioni = listaEdizioni;
	}

	@Override
	public String toString() {
		return "CorsoDTO [corso=" + corso + ", listaEdizioni=" + listaEdizioni + "]";
	}

}
