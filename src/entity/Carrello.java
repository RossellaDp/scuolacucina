package entity;

import java.util.ArrayList;

/*
 * rappresenta il carrello di acquisto da parte di un utente 
 * L'utente può acquistare una o più partecipazioni ad una edizione di un corso
 */
public class Carrello {

	
	private ArrayList<Edizione> edizioniAcquistate=new ArrayList<Edizione>();

	/*
	 * aggiunge una edizione nel carrello
	 * se l'edizione già è presente nel carrello questa non va aggiuta
	 */
	public void aggiungiEdizione (Edizione e){
		// TODO Auto-generated method stub
	}

	/*
	 * elimina una edizione nel carrello
	 * se l'edizione non è presente nel carrello NON si sollava una eccezione
	 */
	public void rimuoviEdizione(Edizione e){
		// TODO Auto-generated method stub
	}
	
	/*
	 * legge una edizione presente nel carrello in base ad idEdizione
	 * se l'edizione non esiste il metodo torna null
	 */
	public Edizione getEdizione(int idEdizione){
		// TODO Auto-generated method stub
		
		return null;
	}
	

	/*
	 * recupera tutte le edizioni presente nel carrello
	 */
	public ArrayList<Edizione> getEdizioniAcquistate() {
		// TODO Auto-generated method stub
		
		return null;
	}

	/*
	 * recupera il numero di edizioni presente nel carrello
	 */
	public int getSize(){
		// TODO Auto-generated method stub
		
		return 0;
	}

	/*
	 * il metodo ritorna il costo totale delle edizioni presenti nel carrello 
	 */
	public double getCostoTotale(){
		// TODO Auto-generated method stub
		
		return 0.0;
	}
	@Override
	public String toString() {
		return "Carrello [edizioniAcquistate=" + edizioniAcquistate + "]";
	}
	
}
	
	
	

