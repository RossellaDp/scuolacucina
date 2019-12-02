package validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;


public class Validatore{

	private static ResourceBundle bundle = ResourceBundle.getBundle("risorse/info");
	
	/*
	 * regole di validazione per la registrazione dell'utente
	 */
	public static List<ErroreValidazione> validazioneUtente(HttpServletRequest request){
		List<ErroreValidazione> lista = new ArrayList<>();
		
		String idUtente = request.getParameter("idUtente");
		if(idUtente == null || idUtente.length()==0)
			lista.add(new ErroreValidazione("idUtente", "idUtente " + bundle.getString("error.required")));

		String password = request.getParameter("password");
		if(password == null || password.length()==0)
			lista.add(new ErroreValidazione("password", "password " + bundle.getString("error.required")));
		else if(password.length()<8)
				//il controllo viene fatto solo se la password è stata inserita
				lista.add(new ErroreValidazione("password", bundle.getString("error.minlength") + " 8"));
		
		//TODO: continuare con gli eventuali controlli di validità che si ritiene necessari
		
		return lista;
	}

	//TODO: aggiungere tutti i controlli per le diverse form del sito
	
}
