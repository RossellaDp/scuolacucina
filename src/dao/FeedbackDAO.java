package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.Feedback;


public interface FeedbackDAO {
	
	void insert(Feedback feedback) throws SQLException;
	void update(Feedback feedback) throws SQLException;
	void delete(int idFeedback) throws SQLException;
//
	ArrayList<Feedback> selectPerEdizione(int idEdizione) throws SQLException;
	ArrayList<Feedback> selectPerUtente(String idUtente) throws SQLException;
	ArrayList<Feedback> selectFeedbackPerCorso(int idCorso) throws SQLException;
	Feedback selectSingoloFeedback(String idUtente, int idEdizione) throws SQLException;

}