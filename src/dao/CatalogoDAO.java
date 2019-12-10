package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.Categoria;
import entity.Corso;
import entity.Feedback;
import exceptions.DAOException;

public interface CatalogoDAO {

	void insert(Corso corso) throws SQLException;
	void update(Corso corso) throws SQLException;
	void delete(int idCorso) throws SQLException;
	ArrayList<Corso> select() throws SQLException;
	ArrayList<Corso> visualizzaCorsiPerCategoria(int idCategoria) throws SQLException;
	Corso select(int idCorso) throws SQLException;

}