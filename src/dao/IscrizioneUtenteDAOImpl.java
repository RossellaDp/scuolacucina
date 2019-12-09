package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import dto.EdizioneDTO;
import entity.Edizione;
import entity.Feedback;
import entity.Utente;
import exceptions.ConnessioneException;

public class IscrizioneUtenteDAOImpl implements IscrizioneUtenteDAO {

	private Connection conn;

	public IscrizioneUtenteDAOImpl() throws ConnessioneException{
		conn = SingletonConnection.getInstance();
	}
	
	/*
	 * iscrizione di un certo utente ad una certa edizione di un corso.
	 * sia l'utente che l'edizione devono già essere stati registrati in precedenza
	 * se l'utente e/o l'edizione non esistono o l'utente è già iscritto a quella edizione si solleva una eccezione
	 */
	@Override
	public void iscriviUtente(int idEdizione, String idUtente) throws SQLException {
//		EdizioneDTO utentiIscritti = new EdizioneDTO ();
//		CalendarioDAOImpl edizione;
//		try {
//			edizione = new CalendarioDAOImpl ();
//		Edizione ed1 = edizione.selectEdizione(idEdizione);
//		utentiIscritti.setEdizione(ed1);
//		
//		FeedBackDAOImpl feedback = new FeedBackDAOImpl ();
//		ArrayList <Feedback> listaFeedback = feedback.selectPerEdizione(idEdizione);
//		utentiIscritti.setFeedbacks(listaFeedback);
//		
		

		
		CalendarioDAOImpl utentiIscritti = null;
		try {
			utentiIscritti = new CalendarioDAOImpl ();
		} catch (ConnessioneException e) {
			
			e.printStackTrace();
		}
		ArrayList <Edizione> edizioniPerUtente = utentiIscritti.select(idUtente);
		
		for (Edizione edizione : edizioniPerUtente) {
			int idEdizione1 =edizione.getCodice();
			if (idEdizione1==idEdizione) {
				throw new SQLException("utente " + idUtente + " già iscritto al corso");
				
			}
		}
			
	///
		PreparedStatement ps = conn.prepareStatement("INSERT INTO iscritti (id_edizione,id_utente) values (?,?)");
		ps.setInt(1, idEdizione);
		ps.setString(2, idUtente);
		int n = ps.executeUpdate();
		if(n==0) {
			throw new SQLException("utente " + idUtente + "edizione" + idEdizione + " non presenti nel database");	
		
		}

		

	}

	/*
	 * cancellazione di una iscrizione ad una edizione
	 * nota: quando si cancella l'iscrizione, sia l'utente che l'edizione non devono essere cancellati
	 * se l'utente e/o l'edizione non esistono si solleva una eccezione
	 */
	@Override
	public void cancellaIscrizioneUtente(int idEdizione, String idUtente) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * lettura di tutte le edizioni a cui è iscritto un utente
	 * se l'utente non esiste o non è iscritto a nessuna edizione si torna una lista vuota
	 */
	@Override
	public ArrayList<Edizione> selectIscrizioniUtente(String idUtente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * lettura di tutti gli utenti iscritti ad una certa edizione
	 * se l'edizione non esiste o non vi sono utenti iscritti si torna una lista vuota
	 */
	@Override
	public ArrayList<Utente> selectUtentiPerEdizione(int idEdizione) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * ritorna il numero di utenti iscritti ad una certa edizione
	 */
	@Override
	public int getNumeroIscritti(int idEdizione) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
