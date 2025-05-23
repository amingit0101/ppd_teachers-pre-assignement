<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="model.collegedean.Persone" %>
<%@ page import="model.collegedean.User" %>
<%@ page import="model.collegedean.Departement_Dean" %>
<%@ page import="model.collegedean.deplome" %>
<%@ page import="service.collegedean.Managment_Class" %>
<%@ page import="java.util.List" %>
<%
    String status = null;
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        Managment_Class manager = new Managment_Class();
        status = request.getParameter("status");
        if (status != null) {
            if(status.equals("OPEN")) {
                manager.updatestatus(1);
            } else if (status.equals("CLOSE")) {
                manager.updatestatus(0);
            }
            out.println("<p style='color:green;'>Status selected: " + status + "</p>");
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assignements open or close</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/open.css">
</head>
<body style="height: 648px;">
    <button class="buttonn home-button" onclick="goToLink('/fac_dean')">
  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
    <path stroke-linecap="round" stroke-linejoin="round" d="M4.5 12h15m0 0l-6.75-6.75M19.5 12l-6.75 6.75"></path>
  </svg>

  
  <div class="text">
    Main
  </div>

</button>
    <form id="consultation-form" class="feed-form" action="" method="post">
        <H3 class="cinzel">Assignements open or close</H3>        
        <div class="body">
            <div class="tabs">
            <input
                checked=""
                value="OPEN"
                name="status"
                id="open"
                type="radio"
                class="input"
            />
            <label for="open" class="label">OPEN</label>
            <input
                value="CLOSE"
                name="status"
                id="close"
                type="radio"
                class="input"
            />
            <label for="close" class="label">CLOSE</label>
            </div>
            <div style="height: 50px;"></div>
            <button type="submit" class="submit-btn"> SUBMIT
            </button>
        </div>
    </form>  
</body>
<script>
function goToLink(url) {
  window.location.href = url;
}
</script>
</html>