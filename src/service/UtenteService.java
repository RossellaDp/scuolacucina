package service;

import java.util.ArrayList;
import entity.Feedback;
import entity.Utente;
import exceptions.DAOException;


public interface UtenteService {

	void registrazioneUtente(Utente u) throws DAOException; 
	Utente checkCredenziali(String idUtente,String psw) throws DAOException; 
	void cancellaRegistrazioneUtente(String idUtente) throws DAOException;
	void modificaDatiUtente(Utente u) throws DAOException;
	ArrayList<Utente> visualizzaUtentiRegistrati() throws DAOException;
	void inserisciFeedback(Feedback f) throws DAOException;
	void modificaFeedback(Feedback feedback) throws DAOException;
	void cancellaFeedback(int idFeedback)throws DAOException;
	
}
