package service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;


import dao.CalendarioDAO;
import dao.CalendarioDAOImpl;
import dao.CatalogoDAO;
import dao.CatalogoDAOImpl;
import dao.IscrizioneUtenteDAO;
import dao.IscrizioneUtenteDAOImpl;
import dto.CorsoDTO;
import dto.EdizioneDTO;
import entity.Corso;
import entity.Edizione;
import entity.Utente;
import exceptions.ConnessioneException;
import exceptions.DAOException;

public class EdizioneServiceImpl implements EdizioneService{

	//dichiarare qui tutti i dao di cui si ha bisogno
	private CalendarioDAO daoC;
	private IscrizioneUtenteDAO daoIscrizione;
	private EdizioneDTO edizioneDTO;
	private CatalogoDAO catalogoDAO;
	//... dichiarazione di altri DAO
	
	//costruire qui tutti i dao di cui si ha bisogno
	public  EdizioneServiceImpl() throws ConnessioneException{
		daoC = new CalendarioDAOImpl();
		daoIscrizione = new IscrizioneUtenteDAOImpl ();
		edizioneDTO= new EdizioneDTO ();
		catalogoDAO = new CatalogoDAOImpl();
		//... costruzione di altri DAO
	}
	
	/*
	 * inserisce una nuova edizione 
	 */
	@Override
	public void inserisciEdizione(Edizione e) throws DAOException {
		try {
			daoC.insert(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	
	/*
	 * modifica tutti i dati di una edizione esistente 
	 */
	@Override
	public void modificaEdizione(Edizione e) throws DAOException {
		try {
			daoC.update(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	/*
	 * cancella una edizione esistente.
	 * E' possibile cancellare una edizione soltanto se la data di inizio è antecedente a quella odierna
	 * Nel caso l'edizione sia cancellabile, è necessario cancellare l'iscrizione a tutti gli utenti iscritti
	 */
	@Override
	public void cancellaEdizione(int idEdizione) throws DAOException {
		LocalDate dataAntecedente = LocalDate.now();
		 Edizione edizione = new Edizione ();
		 edizione.setCodice(idEdizione);
		Date dataEdizione = (Date) edizione.getDataInizio();
		 
		 if (dataAntecedente.isBefore(dataEdizione.toLocalDate())) {
			 try {
				 daoC.delete(idEdizione);
				 edizioneDTO.setEdizione(edizione);
				ArrayList <Utente>listaUtenti = (ArrayList<Utente>) edizioneDTO.getUtentiIscritti();
				for (Utente utente: listaUtenti) {
					String idUtente = utente.getIdUtente();
					daoIscrizione.cancellaIscrizioneUtente(idEdizione, idUtente);
				}
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		
	}

	/*
	 * iscrive un utente ad una edizione 
	 * un utente si può iscrivere solo se ci sono ancora posti disponibili considerato che ogni corso a un numero massimo di partecipanti
	 */
	@Override
	public void iscriviUtente(int idEdizione, String idUtente) throws DAOException {
		try {
			daoIscrizione.getNumeroIscritti(idEdizione);
			
			CorsoDTO  corso = new CorsoDTO ();
	      corso.getCorso().getMaxPartecipanti();
	      
			
			daoIscrizione.iscriviUtente(idEdizione, idUtente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * cancella l'iscrizione ad un utente
	 */
	@Override
	public void cancellaIscrizioneUtente(int idEdizione, String idUtente) throws DAOException {
		try {
			daoIscrizione.cancellaIscrizioneUtente(idEdizione, idUtente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * il metodo ritorna tutte le edizioni con relativi utenti e feedback dei corsi in calendario nel mese indicato dell'anno corrente
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public ArrayList<EdizioneDTO> visualizzaEdizioniPerMese(int mese) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * il metodo ritorna tutte le edizioni con relativi utenti e feedback dei corsi in calendario nel mese indicato dell'anno corrente
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public ArrayList<EdizioneDTO> visualizzaEdizioniPerAnno(int anno) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * il metodo ritorna tutte le edizioni con relativi utenti e feedback del corso specificato presenti in calendario nell'anno corrente a partire dalla data odierna
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public ArrayList<EdizioneDTO> visualizzaEdizioniPerCorso(int idCorso) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * il metodo ritorna tutte le edizioni dei corsi e relativi utenti e feedbacks in calendario dell'anno corrente a partire dalla data odierna
	 * se il metodi del/dei DAO invocati sollevano una eccezione, il metodo deve tornare una DAOException con all'interno l'exception originale
	 */
	@Override
	public EdizioneDTO visualizzaEdizione(int idEdizione) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


}
