package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.AmministratoreDAO;
import dao.CatalogoDAO;
import dao.CatalogoDAOImpl;
import dao.CategoriaDAO;
import dao.FeedbackDAO;
import dto.CorsoDTO;
import dto.EdizioneDTO;
import entity.Categoria;
import entity.Corso;
import entity.Feedback;
import exceptions.ConnessioneException;
import exceptions.DAOException;

public class CorsoServiceImpl implements CorsoService {

	//dichiarare qui tutti i dao di cui si ha bisogno
	private CatalogoDAO daoC;
	private CategoriaDAO daoCategoria;
	private CorsoDTO corsoDTO;
	private FeedbackDAO feedbackDao;
	
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
		ArrayList<Corso> listaCorsi= new ArrayList<Corso>();
		try {
			listaCorsi = daoC.visualizzaCorsiPerCategoria(idCategoria);
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
		}
		return listaCorsi;
	}
	
	/*
	 * lettura di tutte le categorie
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale 
	 */
	@Override
	public ArrayList<Categoria> visualizzaCategorie() throws DAOException {
		ArrayList<Categoria> listaCategorie = new ArrayList <Categoria> ();
		
		try {
			return listaCategorie = daoCategoria.select();
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
		}
	}
		
	
	
	/*
	 * il metodo (invocabile solo da un amministratore) crea una nuova categoria
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public void creaNuovaCategoria(String descrizione) throws DAOException {
		try {
		
			daoCategoria.insert(descrizione);
			
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
		}

	}

	/*
	 * ritorna un oggetto CorsoDTO con tutti i dati di un singolo corso 
	 * tutte le edizioni di quel corso con relativi feedbacks (classe EdizioneDTO)
	 * il corso è individuato tramite idCorso
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public CorsoDTO visualizzaSchedaCorso(int idCorso) throws DAOException {
		CorsoDTO corsoScheda = new CorsoDTO ();
		try {
			
			Corso corso = daoC.select(idCorso);
		    corsoDTO.setCorso(corso);
		    corsoDTO.getCorso();
		    
		 		  //EdizioneDTO edizione = edizione. non capisco come utilizzare il DTO
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return corsoScheda;
	}

	/*
	 * ritorna una lista con tutti i feedbacks relativi ad un corso 
	 * il corso è individuato tramite idCorso
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public ArrayList<Feedback> visualizzaFeedbackCorso(int idCorso) throws DAOException {
      ArrayList<Feedback> listaFeedback = new ArrayList <Feedback> ();
		
		try {
		 listaFeedback = feedbackDao.selectFeedbackPerCorso(idCorso);
		 return listaFeedback;
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
		}
	}
	/*
	 * modifica tutti i dati di un corso
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public void modificaDatiCorso(Corso corso) throws DAOException {
		try {
			daoC.update(corso);
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
		}

	}

	/*
	 * inserisce un nuovo corso a catalogo (invocabile solo dall'amministratore)
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public void inserisciCorso(Corso corso) throws DAOException {
		try {
			daoC.insert(corso);
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
		}

	}

	/*
	 * cancella un singolo corso dal catalogo dei corsi
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale 
	 */ 
	@Override
	public void cancellaCorso(int codiceCorso) throws DAOException {
		try {
			daoC.delete(codiceCorso);
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
		}

	}

	/*
	 * legge i dati di un singolo corso (senza edizioni)
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public Corso visualizzaCorso(int codiceCorso) throws DAOException {
		try {
			Corso corso = daoC.select(codiceCorso);
			return corso;
		} catch (SQLException e) {
			throw new DAOException("errore nel recuperare o leggere i dati", e);
		}
		
		
	}

}
