<header>
  <!-- Fixed navbar -->
 <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #00ff00;" aria-label="Eighth navbar example">
   <a class="navbar-brand" href="${pageContext.request.contextPath }/index.jsp">
    <img src="https://png2.cleanpng.com/sh/0f11ad7a46607e323069d1f52a0b2440/L0KzQYm3VsA2N6Z2kZH0aYP2gLBuTgRzaZpzReRqaXywhMPojwNxd6N5ReRqcHnnPcX5gf50caUye9H2cIX3dcO0ifNwdqQyjORqaX6wg7rujr02amI7UdRtOXS8RLftWL41QGc2T6U5M0G4Qom5UMg0PGY9UaI6LoDxd1==/kisspng-train-rail-transport-rapid-transit-computer-icons-train-sign-5b169bd9d94ff8.4861730315282083458901.png" width="40" height="40" alt="">
  </a>
    <div class="container">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample07">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/index.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active"  href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle active" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath }/ListBigliettiServlet">Lista Elementi</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath }/admin/PrepareInsertBigliettoServlet">Inserisci Nuovo</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath }/PrepareSearchBigliettoServlet">Cerca elemento</a></li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="col-md-3 text-end">
     	<p class="navbar-text">Utente: ${userInfo.username }(${userInfo.nome } ${userInfo.cognome })
        <a  class="btn" style="background-color: #00cc00;" href="${pageContext.request.contextPath }/LogoutServlet">Logout</a>
      </div>
    </div>
  </nav>

</header>