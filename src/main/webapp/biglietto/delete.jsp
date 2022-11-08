<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionebigliettiweb.model.Biglietto"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Visualizza Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">

			<div class='card'>
				<div class='card-header'>
					<h5>Visualizza dettaglio</h5>
				</div>
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Provenienza</dt>
							  <dd class="col-sm-9">${bigliettoDaInviareAPaginaDelete.provenienza}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Destinazione:</dt>
							  <dd class="col-sm-9">${bigliettoDaInviareAPaginaDelete.destinazione}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data:</dt>
							  <dd class="col-sm-9"><fmt:formatDate pattern="dd-MM-yyyy" value="${bigliettoDaInviareAPaginaDelete.data}"/></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9">${bigliettoDaInviareAPaginaDelete.prezzo}</dd>
					    	</dl>
					    	
					    </div>

				<div class='card-footer'>
				
					<form action="ExecuteDeleteBigliettiServlet" method="post">
						<button type="submit" name="submit" value="submit" id="submit" class="btn" style="background-color: #00cc00;">Conferma</button>
						<input type="hidden" name="idBiglietto" value="${bigliettoDaInviareAPaginaDelete.id}">
						<a href="${pageContext.request.contextPath }/ListBigliettiServlet" class='btn btn-outline-secondary' style='width: 80px'> 
							<i class='fa fa-chevron-left'></i> Back
						</a>
					</form>

				</div>
				<!-- end card -->
			</div>


			<!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>