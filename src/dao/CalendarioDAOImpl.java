package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Edizione;
import exceptions.ConnessioneException;
import exceptions.DAOException;



public class CalendarioDAOImpl implements CalendarioDAO {

	private Connection conn;

	public CalendarioDAOImpl() throws ConnessioneException{
		conn = SingletonConnection.getInstance();
	}

	/*
	 * registrazione di una nuova edizione nel calendario dei corsi
	 */
	@Override
	public void insert(Edizione ed) throws SQLException{

			PreparedStatement ps=conn.prepareStatement("insert into calendario(id_corso,dataInizio,durata,aula,docente) values (?,?,?,?,?)");

			ps.setInt(1, ed.getIdCorso());
			ps.setDate(2, new java.sql.Date(ed.getDataInizio().getTime()));
			ps.setInt(3, ed.getDurata());
			ps.setString(4, ed.getAula());
			ps.setString(5, ed.getDocente());
			ps.executeUpdate();

	}


	/*
	 * cancellazione di una edizione presente nel calendario dei corsi
	 * per cancellare una edizione è necessario prima cancellare le eventuali iscrizioni degli utenti e i feedbacks  
	 * l'edizione viene individuata in base a idEdizione
	 * se l'edizione non è presente si solleva una eccezione
	 */
	@Override
	public void delete(int idEdizione) throws SQLException{
		// TODO Auto-generated method stub
				
	}


	/*
	 * modifica di tutti i dati di una edizione presente nel calendario dei corsi
	 * l'edizione viene individuata in base al idEdizione
	 * se l'edizione non è presente si solleva una eccezione
	 */
	@Override
	public void update(Edizione ed) throws SQLException{
			PreparedStatement ps=conn.prepareStatement("update calendario set dataInizio=?, durata=?, aula=?, docente=? where id_edizione= ?");

			ps.setDate(1,new java.sql.Date(ed.getDataInizio().getTime()));
			ps.setInt(2,ed.getDurata());
			ps.setString(3,ed.getAula());
			ps.setString(4,ed.getDocente());
			ps.setInt(5, ed.getCodice());

			int n = ps.executeUpdate();
			if(n==0) throw new SQLException("edizione " + ed.getCodice() + " non presente");

	}


	/*
	 * lettura di tutte le edizioni di una certa categoria, presenti nel calendario dei corsi
	 * le edizioni vengono individuate in base al idCategoria
	 * se non vi sono edizioni per quella categoria o la categoria non esiste viene ritornata una lista vuota
	 */
	@Override
	public ArrayList<Edizione> select(int idCategoria) throws SQLException{
			ArrayList<Edizione> edizioni=new ArrayList<Edizione>();
			PreparedStatement ps=conn.prepareStatement("select * from calendario, catalogo where calendario.id_corso = catalogo.id_corso and id_categoria=?");

			ps.setInt(1, idCategoria);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int idEdizione=rs.getInt("id_Edizione");
				int idCorso=rs.getInt("id_corso");
				Date dataInizio=rs.getDate("dataInizio");
				int durata=rs.getInt("durata");
				String aula=rs.getString("aula");
				String docente=rs.getString("docente");

				Edizione e=new Edizione(idCorso,dataInizio,durata,aula,docente);
				e.setCodice(idEdizione);

				long dataM = dataInizio.getTime();
				long durataM= durata*86400000L;
				Date dataFine = new Date(dataM+durataM);
			

				if (dataFine.before(new java.util.Date()))
					e.setTerminata(true);	

				edizioni.add(e);

			}

			return edizioni;

	}


	/*
	 * lettura dei dati di una edizione presente nel calendario dei corsi
	 * l'edizione viene individuata in base al idEdizione
	 * se l'edizione non è presente si solleva una eccezione
	 */
	@Override
	public Edizione selectEdizione(int idEdizione) throws SQLException{
	  
		PreparedStatement ps=conn.prepareStatement("select * from calendario where id_edizione = ?");
		ps.setInt(1, idEdizione);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()){
			int idCorso=rs.getInt("id_corso");
			Date dataInizio=rs.getDate("dataInizio");
			int durata=rs.getInt("durata");
			String aula=rs.getString("aula");
			String docente=rs.getString("docente");

			Edizione ed = new Edizione(idCorso,dataInizio,durata,aula,docente);
			ed.setCodice(idEdizione);

			long dataM = dataInizio.getTime();
			long durataM= durata*86400000L;
			Date dataFine = new Date(dataM+durataM);

			if (dataFine.before(new java.util.Date()))
				ed.setTerminata(true);
			return ed;
		} else 
			throw new SQLException("edizione " + idEdizione + " non presente");
	  
	  
	}

	/*
	 * lettura di tutte le edizioni presenti nel calendario dei corsi
	 * se non vi sono edizioni registrate viene ritornata una lista vuota
	 */
	@Override
	public ArrayList<Edizione> select()throws SQLException{
	  
		ArrayList<Edizione> edizioni=new ArrayList<Edizione>();
		PreparedStatement ps=conn.prepareStatement("select * from calendario");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			int idEdizione=rs.getInt("id_Edizione");
			int idCorso=rs.getInt("id_corso");
			Date dataInizio=rs.getDate("dataInizio");
			int durata=rs.getInt("durata");
			String aula=rs.getString("aula");
			String docente=rs.getString("docente");

			Edizione ed = new Edizione(idCorso,dataInizio,durata,aula,docente);
			ed.setCodice(idEdizione);

			long dataM = dataInizio.getTime();
			long durataM= durata*86400000L;
			Date dataFine = new Date(dataM+durataM);

			if (dataFine.before(new java.util.Date()))
				ed.setTerminata(true);
			
			edizioni.add(ed);
		}
		return edizioni;
	  

		
	}

	
	/*
	 * lettura di tutte le edizioni a cui un certo utente è iscritto o è stato iscritto in passato (vale a dire tutte), presenti nel calendario dei corsi
	 * le edizioni vengono individuate in base al idUtente dell'utente
	 * se non vi sono edizioni per quell'utente o l'utente non esiste viene ritornata una lista vuota
	 */
	@Override
	public ArrayList<Edizione> select(String idUtente) throws SQLException{

			ArrayList<Edizione> edizioni=new ArrayList<Edizione>();
			PreparedStatement ps=conn.prepareStatement("select calendario.id_edizione,id_corso,id_utente,dataInizio,durata,aula,docente from calendario,iscritti where calendario.id_edizione=iscritti.id_edizione and iscritti.id_utente=?");

			ps.setString(1, idUtente);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				int idEdizione=rs.getInt("id_Edizione");
				int idCorso=rs.getInt("id_corso");
				Date dataInizio=rs.getDate("dataInizio");
				int durata=rs.getInt("durata");
				String aula=rs.getString("aula");
				String docente=rs.getString("docente");

				Edizione e=new Edizione(idCorso,dataInizio,durata,aula,docente);
				e.setCodice(idEdizione);

				long dataM = dataInizio.getTime();
				long durataM= durata*86400000L;
				Date dataFine = new Date(dataM+durataM);
				java.util.Date d =  new java.util.Date();

				if (dataFine.before(d) )
					e.setTerminata(true);	
				
				edizioni.add(e);
			}

			return edizioni;
	}
	
	/*
	 * leggere tutte le edizioni presenti nel calendario nel range delle date da, a (inclusi)
	 * se non vi sono edizioni in quel range di date viene ritornata una lista vuota
	 */
	@Override
	public ArrayList<Edizione> select(java.util.Date da, java.util.Date a) throws SQLException {
		
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * lettura di tutte le edizioni di una certa categoria, presenti nel calendario dei corsi
	 * se future = true, le edizioni lette devono essere solo quelle a partire dalla data in odierna e dell'anno corrente 
	 * se future = false devono essere lette tutte le edizioni
	 * le edizioni vengono individuate in base al idCategoria
	 * se non vi sono edizioni per quella categoria o la categoria non esiste viene ritornata una lista vuota
	 */
	@Override
	public ArrayList<Edizione> select(int idCategoria, boolean future) throws SQLException {
		ArrayList<Edizione> edizioniCalendario =new ArrayList<Edizione>();
		PreparedStatement ps=conn.prepareStatement("select * from calendario,catalogo where calendario.id_corso=catalogo.id_corso and catalogo.id_categoria=?;");

		ps.setInt(1, idCategoria);
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
			int idEdizione=rs.getInt("id_Edizione");
			int idCorso=rs.getInt("id_corso");
			Date dataInizio=rs.getDate("dataInizio");
			int durata=rs.getInt("durata");
			String aula=rs.getString("aula");
			String docente=rs.getString("docente");
			Edizione ed = new Edizione(idCorso,dataInizio,durata,aula,docente);
			

			
			
			
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * lettura di tutte le edizioni presenti nel calendario dei corsi
	 * se future = true, le edizioni lette devono essere solo quelle a partire dalla data in odierna e dell'anno corrente 
	 * se future = false devono essere lette tutte le edizioni
	 * se non vi sono edizioni viene ritornata una lista vuota
	 */
	@Override
	public ArrayList<Edizione> select(boolean future) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * lettura di tutte le edizioni a cui è iscritto una certo utente, presenti nel calendario dei corsi
	 * se future = true, le edizioni lette devono essere solo quelle a partire dalla data in odierna e dell'anno corrente 
	 * se future = false devono essere lette tutte le edizioni
	 * le edizioni vengono individuate in base al idUtente
	 * se non vi sono edizioni per quella categoria o la categoria non esiste viene ritornata una lista vuota
	 */
	@Override
	public ArrayList<Edizione> select(String idUtente, boolean future) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
