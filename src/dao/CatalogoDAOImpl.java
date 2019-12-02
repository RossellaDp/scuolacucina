package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Categoria;
import entity.Corso;
import entity.Feedback;
import exceptions.ConnessioneException;

public class CatalogoDAOImpl implements CatalogoDAO {

	private Connection conn;

	public CatalogoDAOImpl() throws ConnessioneException{
		conn = SingletonConnection.getInstance();
	}
	
	/*
	 * registrazione di un nuovo corso nel catalogo dei corsi
	 */
	@Override
	public void insert(Corso corso) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * modifica di tutti i dati di un corso nel catalogo dei corsi
	 * il corso viene individuato in base al idCorso
	 * se il corso non esiste si solleva una eccezione
	 */
	@Override
	public void update(Corso corso) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * cancellazione di un nuovo corso nel catalogo dei corsi
	 * questo potrà essere cancellato solo se non vi sono edizioni di quel corso o qualsiasi altro legame con gli altri dati 
	 * Se il corso non esiste si solleva una eccezione
	 * Se non è cancellabile si solleva una eccezione
	 */
	@Override
	public void delete(int idCorso) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * lettura di tutti i corsi dal catalogo
	 * se non ci sono corsi nel catalogo il metodo torna una lista vuota
	 */
	@Override
	public ArrayList<Corso> select() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * lettura di un singolo corso dal catalogo dei corsi
	 * se il corso non è presente si solleva una eccezione
	 */
	@Override
	public Corso select(int idCorso) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
