package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CatalogoDAO;
import dao.CatalogoDAOImpl;
import dto.CorsoDTO;
import entity.Categoria;
import entity.Corso;
import entity.Feedback;
import exceptions.ConnessioneException;
import exceptions.DAOException;

public class CorsoServiceImpl implements CorsoService {

	//dichiarare qui tutti i dao di cui si ha bisogno
	private CatalogoDAO daoC;
	//... dichiarazione di altri DAO
	
	//costruire qui tutti i dao di cui si ha bisogno
	public  CorsoServiceImpl() throws ConnessioneException{
		daoC = new CatalogoDAOImpl();
		//... costruzione dei altri dao
	}
	
	/*
	 * il metodo mostra tutti i corsi offerti dalla scuola 
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public ArrayList<Corso> visualizzaCatalogoCorsi() throws DAOException {
		try {
			return daoC.select();
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
			
		}
	}

	/*
	 * il metodo mostra l'elenco dei corsi di una certa categorie
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale 
	 */
	@Override
	public ArrayList<Corso> visualizzaCorsiPerCategoria(int idCategoria) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * lettura di tutte le categorie
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale 
	 */
	@Override
	public ArrayList<Categoria> visualizzaCategorie() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * il metodo (invocabile solo da un amministratore) crea una nuova categoria
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public void creaNuovaCategoria(String descrizione) {
		// TODO Auto-generated method stub

	}

	/*
	 * ritorna un oggetto CorsoDTO con tutti i dati di un singolo corso 
	 * tutte le edizioni di quel corso con relativi feedbacks (classe EdizioneDTO)
	 * il corso è individuato tramite idCorso
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public CorsoDTO visualizzaSchedaCorso(int idCorso) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * ritorna una lista con tutti i feedbacks relativi ad un corso 
	 * il corso è individuato tramite idCorso
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public ArrayList<Feedback> visualizzaFeedbackCorso(int idCorso) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * modifica tutti i dati di un corso
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public void modificaDatiCorso(Corso corso) throws DAOException {
		// TODO Auto-generated method stub

	}

	/*
	 * inserisce un nuovo corso a catalogo (invocabile solo dall'amministratore)
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public void inserisciCorso(Corso corso) throws DAOException {
		// TODO Auto-generated method stub

	}

	/*
	 * cancella un singolo corso dal catalogo dei corsi
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale 
	 */ 
	@Override
	public void cancellaCorso(int codiceCorso) throws DAOException {
		// TODO Auto-generated method stub

	}

	/*
	 * legge i dati di un singolo corso (senza edizioni)
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public Corso visualizzaCorso(int codiceCorso) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
