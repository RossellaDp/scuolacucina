package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Edizione;
import entity.Utente;
import exceptions.ConnessioneException;

public class RegistrazioneUtenteDAOImpl implements RegistrazioneUtenteDAO {

	private Connection conn;

	public RegistrazioneUtenteDAOImpl() throws ConnessioneException{
		conn = SingletonConnection.getInstance();
	}
	
	/*
	 * registrazione di un nuovo utente alla scuola di formazione 
	 * se l'utente già esiste si solleva una eccezione
	 */
	@Override
	public void insert(Utente u) throws SQLException {
		// TODO Auto-generated method stub
		Utente utemp=select(u.getIdUtente());
		if (utemp.getCognome()!=null) {
			throw new SQLException("utente " + u.getIdUtente() + " già presente nel database");	
		}
		else {
		PreparedStatement ps= conn.prepareStatement("INSERT INTO `registrati` (`id_utente`, `password`, `nome`, `cognome`, `dataNascita`, `email`, `telefono`) VALUES(?,?, ?, ?, ?, ?, ?)");
		ps.setString(1, u.getIdUtente());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getNome());
		ps.setString(4, u.getCognome());
		java.sql.Date date= new java.sql.Date(u.getDataNascita().getTime());
		ps.setDate(5, date);
		ps.setString(6, u.getEmail());
		ps.setString(7, u.getTelefono());
		ps.executeUpdate();
		}
	}

	/*
	 * modifica di tutti i dati di un utente
	 * l'utente viene individuato dal suo idUtente
	 * se l'utente non esiste si solleva una exception
	 */
	@Override
	public void update(Utente u) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=conn.prepareStatement("update registrati set password=?, nome=?, cognome=?, dataNascita=?, email=?, telefono=? where id_utente= ?");

		ps.setString(7, u.getIdUtente());
		ps.setString(1, u.getPassword());
		ps.setString(2, u.getNome());
		ps.setString(3, u.getCognome());
		java.sql.Date date= new java.sql.Date(u.getDataNascita().getTime());
		ps.setDate(4, date);
		ps.setString(5, u.getEmail());
		ps.setString(6, u.getTelefono());
		

		int n = ps.executeUpdate();
		if(n==0) throw new SQLException("utente " + u.getIdUtente() + " non presente");

	}

	/*
	 * cancellazione di un singolo utente
	 * l'utente si può cancellare solo se non è correlato ad altri dati
	 * se l'utente non esiste o non è cancellabile si solleva una eccezione
	 */
	@Override
	public void delete(String idUtente) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareStatement("DELETE FROM registrati WHERE id_utente=?");
		ps.setString(1, idUtente);	
		int n = ps.executeUpdate();
		if(n==0)
			throw new SQLException("utente " + idUtente + " non presente");
		

	}
	
	/*
	 * lettura di tutti gli utenti registrati
	 * se non ci sono utenti registrati il metodo ritorna una lista vuota
	 */
	@Override
	public ArrayList<Utente> select() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Utente> utenti= new ArrayList<Utente>();
		PreparedStatement ps=conn.prepareStatement("select * from registrati");
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()){
			Utente u= new Utente();
			u.setAdmin(false);
			u.setCognome(rs.getString("cognome"));
			u.setEmail(rs.getString("email"));
			u.setIdUtente(rs.getString("id_utente"));
			u.setNome(rs.getString("nome"));
			u.setPassword(rs.getString("password"));
			u.setTelefono(rs.getString("telefono"));
			u.setDataNascita(rs.getTimestamp("dataNascita"));

			utenti.add(u);
		};
	  
		return utenti;
	}

	
	/*
	 * lettura dei dati di un singolo utente
	 * se l'utente non esiste si solleva una eccezione
	 */
	@Override
	public Utente select(String idUtente) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select * from registrati where id_utente= ?");
		ps.setString(1, idUtente);
		ResultSet rs=ps.executeQuery();
		Utente u=new Utente();
		if(rs.next()){
			u.setAdmin(false);
			u.setCognome(rs.getString("cognome"));
			u.setEmail(rs.getString("email"));
			u.setIdUtente(rs.getString("id_utente"));
			u.setNome(rs.getString("nome"));
			u.setPassword(rs.getString("password"));
			u.setTelefono(rs.getString("telefono"));
			u.setDataNascita(rs.getTimestamp("dataNascita"));

			
			return u;
		} else 
			throw new SQLException("utente " + idUtente + " non presente");
	}

}
