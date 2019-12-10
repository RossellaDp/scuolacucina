package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.CorsoDTO;
import entity.Categoria;
import entity.Corso;
import entity.Feedback;
import exceptions.DAOException;


public interface CorsoService {

	ArrayList<Corso> visualizzaCatalogoCorsi() throws DAOException;
	ArrayList<Corso> visualizzaCorsiPerCategoria(int idCategoria) throws DAOException;
	
	ArrayList<Categoria> visualizzaCategorie() throws DAOException;
	void creaNuovaCategoria(String descrizione) throws DAOException;
	CorsoDTO visualizzaSchedaCorso(int idCorso) throws DAOException;
	ArrayList<Feedback> visualizzaFeedbackCorso(int idCorso) throws DAOException;
	Corso visualizzaCorso(int idCorso) throws DAOException;
	void modificaDatiCorso(Corso corso) throws DAOException;
	void inserisciCorso(Corso corso) throws DAOException;
	void cancellaCorso(int idCorso) throws DAOException;
}
