package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Utente;
import exceptions.ConnessioneException;
import exceptions.DAOException;
import service.UtenteService;
import service.UtenteServiceImpl;
import validator.ErroreValidazione;
import validator.Validatore;


@WebServlet("/regUtente")
public class RegistrazioneUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//invocazione al validatore per il controllo dei campi
		List<ErroreValidazione> lista = Validatore.validazioneUtente(request);
		if(lista.size()!=0){
			request.setAttribute("lista", lista );
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/registraUtente.jsp").forward(request, response);
		}

		UtenteService serviceU;
		try {
			serviceU = new UtenteServiceImpl();

			Utente u = this.getUtenteFromQueryString(request);


			serviceU.registrazioneUtente(u);
			request.setAttribute("user", u);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/registrazioneUtenteOk.jsp").forward(request, response);

		} catch (DAOException | ConnessioneException e) {
			e.printStackTrace();
			request.setAttribute("errore", e);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/erroreGenerico.jsp").forward(request, response);
		}

	}

	private Utente getUtenteFromQueryString(HttpServletRequest request){

		String idUtente = request.getParameter("idUtente");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String giorno = request.getParameter("giorno");
		String mese = request.getParameter("mese");
		String anno = request.getParameter("anno");
		LocalDate l = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno));
		Date d = java.util.Date.from(l.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		boolean adm = false;

		return new Utente(idUtente, password, nome, cognome, d, email, telefono, adm);



	}

}
