package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Categoria;
import exceptions.ConnessioneException;

public class CategoriaDAOImpl implements CategoriaDAO {

	private Connection conn;

	public CategoriaDAOImpl() throws ConnessioneException{
		conn = SingletonConnection.getInstance();
	}
	
	/*
	 * inserimento di una nuova categoria
	 * 
	 */
	@Override
	public void insert(String descrizione) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	/*
	 * modifica del nome di una categoria.
	 * la categoria viene individuata in base al idCategoria
	 * se la categoria non esiste si solleva una eccezione
	 */
	@Override
	public void update(Categoria c) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * cancellazione di una singola categoria
	 * una categoria si può cancellare solo se non ci sono dati correlati
	 * se la categoria non esiste o non è cancellabile si solleva una eccezione
	 */
	@Override
	public void delete(int idCategoria) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * lettura di una singola categoria in base al suo id
	 * se la categoria non esiste si solleva una eccezione
	 */
	@Override
	public Categoria select(int idCategoria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * lettura di tutte le categorie
	 * se non vi sono categoria il metodo ritorna una lista vuota
	 */
	@Override
	public ArrayList<Categoria> select() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
