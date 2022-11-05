package it.prova.gestionebigliettiweb.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebigliettiweb.model.Biglietto;
import it.prova.gestionebigliettiweb.service.MyServiceFactory;
import it.prova.gestionebigliettiweb.utility.UtilityBigliettoForm;

/**
 * Servlet implementation class ExecuteSearchBigliettoServlet
 */
@WebServlet("/ExecuteSearchBigliettoServlet")
public class ExecuteSearchBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// estraggo input
		String provenienzaInputParam=request.getParameter("provenienza");
		String destinazioneInputParam=request.getParameter("destinazione");
		String dataInputParam=request.getParameter("data");
		String prezzoInputStringParam=request.getParameter("prezzo");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Biglietto bigliettoInstance = UtilityBigliettoForm.createBigliettoFromParams(provenienzaInputParam,
				destinazioneInputParam, dataInputParam, prezzoInputStringParam);
		
		try {				
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().findByExample(bigliettoInstance));
		}catch(Exception e) {
			//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
		}
		
		// andiamo ai risultati
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
	}
}
