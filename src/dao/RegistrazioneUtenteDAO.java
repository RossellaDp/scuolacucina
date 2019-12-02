package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.Utente;

public interface RegistrazioneUtenteDAO {

	void insert(Utente u) throws SQLException;
	void update(Utente u) throws SQLException;
	void delete(String idUtente) throws SQLException;
	ArrayList<Utente> select() throws SQLException;
	Utente select(String idUtente) throws SQLException;

}