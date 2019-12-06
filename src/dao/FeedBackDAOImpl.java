package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Feedback;
import entity.Utente;
import exceptions.ConnessioneException;

public class FeedBackDAOImpl implements FeedbackDAO {

	private Connection conn;

	public FeedBackDAOImpl() throws ConnessioneException{
		conn = SingletonConnection.getInstance();
	}
	
	/*
	 * inserimento di un singolo feedbak relativo ad una edizione di un corso da parte di un utente
	 * se un utente ha già inserito un feedback per una certa edizione si solleva una eccezione
	 */
	@Override
	public void insert(Feedback feedback) throws SQLException {
		
		PreparedStatement ps=conn.prepareStatement("INSERT INTO feekback (id_feedback,id_edizione,id_utente,descrizione,voto) VALUES (?,?,?,?,?)");
		ps.setInt(1, feedback.getIdFeedback());
		ps.setInt(2, feedback.getIdEdizione());
		ps.setString(3, feedback.getIdUtente());
		ps.setString(4, feedback.getDescrizione());
		ps.setInt(5, feedback.getVoto());
		
	if(this.selectSingoloFeedback(feedback.getIdUtente(), feedback.getIdEdizione()) != null) {
		 ps.executeUpdate();
		throw new SQLException("feedback dell'utente: " + feedback.getIdUtente() + " già presente");

	}
	}

	

	

	/*
	 * modifica di tutti i dati di un singolo feedback
	 * un feedback viene individuato attraverso l'idFeedback
	 * se il feedback non esiste si solleva una eccezione
	 */
	@Override
	public void update(Feedback feedback) throws SQLException {
    PreparedStatement ps=conn.prepareStatement("UPDATE feedback SET id_edizione=?, id_utente=?, descrizione=?, voto=? where id_feedback=?");
			ps.setInt(1, feedback.getIdEdizione());
			ps.setString(2, feedback.getIdUtente());
			ps.setString(3, feedback.getDescrizione());
			ps.setInt(4, feedback.getVoto());
			ps.setInt(5, feedback.getIdFeedback());
		
			int n = ps.executeUpdate();
			if(n==0)
				throw new SQLException("feedback dell'utente: " + feedback.getIdUtente() + " non presente");

		}

		

	

	/*
	 * cancellazione di un feedback
	 * se il feedback non esiste si solleva una eccezione
	 */
	@Override
	public void delete(int idFeedback) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM feedback WHERE id_feedback=?");
		ps.setInt(1, idFeedback);
		int n = ps.executeUpdate();
		if(n==0)
			throw new SQLException("feedback " + idFeedback + " non presente");

	}

	
	
	/*
	 * lettura di un singolo feedback scritto da un utente per una certa edizione 
	 * se il feedback non esiste si solleva una eccezione
	 */
	@Override
	public Feedback selectSingoloFeedback(String idUtente, int idEdizione) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from feedback where id_utente=? and id_edizione=?");
		ps.setString(1, idUtente);
		ps.setInt(2, idEdizione);
		ResultSet rs = ps.executeQuery();
		Feedback feedbackSingle =null;
		if(rs.next()) {
			feedbackSingle= new Feedback();
			feedbackSingle.setIdFeedback(rs.getInt("id_feedback"));
			feedbackSingle.setVoto(rs.getInt("voto"));
			feedbackSingle.setDescrizione(rs.getString("descrizione"));
			feedbackSingle.setIdUtente(rs.getString("id_utente"));
			feedbackSingle.setIdEdizione(rs.getInt("id_edizione"));
			return feedbackSingle;
			
			
		}else {
			throw new SQLException ("feedback dell'utente: " + idUtente + " non presente");
			
		}
	}

	/*
	 * lettura di tutti i feedback di una certa edizione
	 * se non ci sono feedback o l'edizione non esiste si torna una lista vuota
	 */
	@Override
	public ArrayList<Feedback> selectPerEdizione(int idEdizione) throws SQLException {
		ArrayList<Feedback> feedback = new ArrayList<Feedback> ();
		PreparedStatement ps=conn.prepareStatement("select * from feedback where id_edizione=?");
		ps.setInt(1, idEdizione);
		ResultSet rs = ps.executeQuery();
		Feedback feedbackSingle =null;
		if (rs.next()) {
			feedbackSingle = new Feedback ();
			feedbackSingle.setIdFeedback(rs.getInt("id_feedback"));
			feedbackSingle.setIdUtente(rs.getString("id_utente"));
			feedbackSingle.setVoto(rs.getInt("voto"));
			feedbackSingle.setDescrizione(rs.getString("descrizione"));
			feedbackSingle.setIdEdizione(rs.getInt("id_edizione"));
			feedback.add(feedbackSingle);
			
			
		}else {
			throw new SQLException("feedback edizione" + idEdizione + " non presente");
		
		
		
		
	}
		return feedback;
	}

	/*
	 * lettura di tutti i feedback scritti da un certo utente
	 * se non ci sono feedback o l'utente non esiste si torna una lista vuota
	 */
	@Override
	public ArrayList<Feedback> selectPerUtente(String idUtente) throws SQLException {
		ArrayList<Feedback> feedback = new ArrayList<Feedback> ();
		PreparedStatement ps=conn.prepareStatement("select * from feedback where id_utente=?");
		ps.setString(1, idUtente);
		ResultSet rs = ps.executeQuery();
		Feedback feedbackSingle =null;
		if (rs.next()) {
			feedbackSingle = new Feedback ();
			feedbackSingle.setIdFeedback(rs.getInt("id_feedback"));
			feedbackSingle.setIdUtente(rs.getString("id_edizione"));
			feedbackSingle.setVoto(rs.getInt("voto"));
			feedbackSingle.setDescrizione(rs.getString("descrizione"));
			feedbackSingle.setIdEdizione(rs.getInt("id_utente"));
			feedback.add(feedbackSingle);
			
			
		}else {
			throw new SQLException("feedback utente" + idUtente + " non presente");
		
		
		
		
	}
		return feedback;
	}

	/*
	 * lettura di tutti i feedback scritti per un certo corso (nota: non edizione ma corso)
	 * se non ci sono feedback o il corso non esiste si torna una lista vuota
	 */
	@Override
	public ArrayList<Feedback> selectFeedbackPerCorso(int idCorso) throws SQLException {
		
		ArrayList<Feedback> feedback = new ArrayList<Feedback> ();
		PreparedStatement ps=conn.prepareStatement("SELECT feedback.id_utente,feedback.voto,feedback.id_feedback,feedback.id_edizione, feedback.descrizione from feedback,calendario,catalogo where catalogo.id_corso=calendario.id_corso and calendario.id_edizione= feedback.id_edizione and catalogo.id_corso=?");
		ps.setInt(1, idCorso);
		ResultSet rs = ps.executeQuery();
		Feedback feedbackSingle =null;
		if (rs.next()) {
			feedbackSingle = new Feedback ();
//			
			feedbackSingle.setIdEdizione(rs.getInt("id_utente"));
			feedbackSingle.setVoto(rs.getInt("voto"));
			feedbackSingle.setIdFeedback(rs.getInt("id_feedback"));
			feedbackSingle.setIdUtente(rs.getString("id_edizione"));
			feedbackSingle.setDescrizione(rs.getString("descrizione"));
			feedback.add(feedbackSingle);
			
		
		}else {
			throw new SQLException("feedback o corso" + feedback + " non presente");
		
		
		
		
	}
		return feedback;
	}


	

}
