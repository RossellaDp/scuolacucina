package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.CorsoDTO;
import entity.Categoria;
import exceptions.DAOException;


public interface CategoriaDAO {
	void insert(String descrizione, int id) throws SQLException;
	void insert (String descrizione) throws SQLException;
	void update(Categoria c) throws SQLException;
	void delete(int idCategoria) throws SQLException;
	
	Categoria select(int idCategoria) throws SQLException;
	ArrayList<Categoria> select() throws SQLException;
}