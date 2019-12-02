package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.Edizione;
import entity.Utente;

public interface IscrizioneUtenteDAO {

	void iscriviUtente(int idEdizione, String idUtente) throws SQLException;
	void cancellaIscrizioneUtente(int idEdizione, String idUtente) throws SQLException;
	ArrayList<Edizione> selectIscrizioniUtente(String idUtente) throws SQLException;
	ArrayList<Utente> selectUtentiPerEdizione(int idEdizione) throws SQLException;
	int getNumeroIscritti(int idEdizione) throws SQLException;
}