package entity;

public class Categoria {
	
	private int idCategoria;
	private String descrizione;
	
	public Categoria() {}
	
	public Categoria(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Categoria(int idCategoria, String descrizione) {
		this.idCategoria = idCategoria;
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", descrizione=" + descrizione + "]";
	}

}
