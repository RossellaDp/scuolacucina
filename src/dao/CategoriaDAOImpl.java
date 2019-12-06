package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Categoria;
import entity.Edizione;
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
	public void insert(String descrizione, int id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=conn.prepareStatement("insert into categoria(id_categoria,descrizione) values (?,?)");
		ps.setInt(1, id);
		ps.setString(2, descrizione);
		ps.executeUpdate();
	}
	/*
	 * modifica del nome di una categoria.
	 * la categoria viene individuata in base al idCategoria
	 * se la categoria non esiste si solleva una eccezione
	 */
	@Override
	public void update(Categoria c) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=conn.prepareStatement("update categoria set descrizione=? where id_categoria=?");
		ps.setString(1, c.getDescrizione());
		ps.setInt(2, c.getIdCategoria());
		int n=ps.executeUpdate();
		if (n==0) {throw new SQLException("categoria " + c.getIdCategoria() + " non presente");}
		
				
		
	}

	/*
	 * cancellazione di una singola categoria
	 * una categoria si può cancellare solo se non ci sono dati correlati
	 * se la categoria non esiste o non è cancellabile si solleva una eccezione
	 */
	@Override
	public void delete(int idCategoria) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareStatement("DELETE FROM categoria WHERE id_categoria=?");
		ps.setInt(1, idCategoria);	
		int n = ps.executeUpdate();
		if(n==0)
			throw new SQLException("categoria " + idCategoria + " non presente");
	}

	/*
	 * lettura di una singola categoria in base al suo id
	 * se la categoria non esiste si solleva una eccezione
	 */
	@Override
	public Categoria select(int idCategoria) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps= conn.prepareStatement("select * from categoria where id_categoria=?");
		ps.setInt(1, idCategoria);
		ResultSet rs=ps.executeQuery();
		Categoria cat=new Categoria();
		while (rs.next()) {
			cat.setIdCategoria(rs.getInt("id_categoria"));
			cat.setDescrizione(rs.getString("descrizione"));
		}
		if (cat.getIdCategoria()==0) {
			throw new SQLException("categoria " + idCategoria + " non presente");
			}
		return cat;
	}
	
	/*
	 * lettura di tutte le categorie
	 * se non vi sono categoria il metodo ritorna una lista vuota
	 */
	@Override
	public ArrayList<Categoria> select() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Categoria> categorie=new ArrayList<Categoria>();
		PreparedStatement ps=conn.prepareStatement("select * from categoria");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			Categoria cat=new Categoria();
			cat.setIdCategoria(rs.getInt("id_categoria"));
			cat.setDescrizione(rs.getString("descrizione"));
			categorie.add(cat);

		}
		return categorie;
	}

}
