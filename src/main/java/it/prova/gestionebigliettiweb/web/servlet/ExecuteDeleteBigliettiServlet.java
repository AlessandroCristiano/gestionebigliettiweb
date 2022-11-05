package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.service.MyServiceFactory;


/**
 * Servlet implementation class ExecuteDeleteBigliettiServlet
 */
@WebServlet("/ExecuteDeleteBigliettiServlet")
public class ExecuteDeleteBigliettiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdDellBigliettoDaEliminare = request.getParameter("idBiglietto");
		try {
			MyServiceFactory.getBigliettoServiceInstance().rimuovi(Long.parseLong(parametroIdDellBigliettoDaEliminare));
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().listAll());
		}catch(Exception e) {
			//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		// andiamo ai risultati
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
	}
}