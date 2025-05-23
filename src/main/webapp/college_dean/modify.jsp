<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="model.collegedean.Persone" %>
<%@ page import="model.collegedean.User" %>
<%@ page import="model.collegedean.Departement_Dean" %>
<%@ page import="model.collegedean.deplome" %>
<%@ page import="service.collegedean.Managment_Class" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>


<%
    request.setCharacterEncoding("UTF-8");
    Managment_Class manager = new Managment_Class();
    boolean showRestOfForm = false;
    String email = request.getParameter("email");
    Persone person_info = null; 
    String old_password = "";
    String old_department = "";
    List<String> departmentNames = manager.getdepartemenname();
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        if (email != null && request.getParameter("Name") == null) {
            if(!manager.emailExists(email)) {
                out.println("<p style='color:red;'>Email does not exist!</p>");
            } else {
                showRestOfForm = true;
                person_info = manager.getPersonByEmail(email) ; 
                old_password = manager.getPassword(email) ; 
                old_department = manager.getDepartement(manager.getDD_ID(person_info.getId()));
                System.out.println("die" + old_department);
            }
        } else if (email != null) {
            String name = request.getParameter("Name");
            String date = request.getParameter("date");
            int deplomeId = Integer.parseInt(request.getParameter("deplome"));
            String phone = request.getParameter("phone");
            String password = request.getParameter("PASSWORD");
            String selectedDepartment = request.getParameter("departmentChoice");
            Persone person = new Persone(name, phone, email, LocalDate.parse(date), deplomeId);
            User user = new User(password, 2, person.getId());
            Departement_Dean dean = new Departement_Dean();
            dean.setPersonel_info(person.getId());
            dean.setUser_id(user.getId());
            manager.updateDepartementdean(person,user,dean);
            System.out.println("die" + selectedDepartment);
            if(selectedDepartment.equals("Ingenieur")){
                  manager.setdepratment(dean.getId(),0);
              }
              else if(selectedDepartment.equals("Tronc commun")){
                  manager.setdepratment(dean.getId(),1);
              }
              else if(selectedDepartment.equals("Tlsi")){
                  manager.setdepratment(dean.getId(),2);
              }
              else if(selectedDepartment.equals("ifa")){
                  manager.setdepratment(dean.getId(),3);
              }
            out.println("<p style='color:green;'>Account information changed successfully!</p>");
            out.println("<p style='color:green;'>"+"</p>");
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Department Dean Account</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/modify.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <button class="button home-button" onclick="goToLink('/fac_dean')">
  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
    <path stroke-linecap="round" stroke-linejoin="round" d="M4.5 12h15m0 0l-6.75-6.75M19.5 12l-6.75 6.75"></path>
  </svg>

  
  <div class="text">
    Main
  </div>

</button>
    <h2 class="cinzel">Modify Department Dean Account</h2>

<section class="section_form">
    <form id="consultation-form" class="feed-form" action="" method="post">
    <input name="email" required placeholder="email" type="email" 
      value="<%= email != null ? email : "" %>" <%= showRestOfForm ? "readonly" : "" %> >
      
      <% if (showRestOfForm && person_info != null ) { %>
        <input name="Name" placeholder="Full Name" type="text" id="name" value="<%= person_info.getNome() %>">
        <input name="date" required placeholder="Date of birth" type="date" value="<%= person_info.getBithday() %>">
        <input name="phone" required placeholder="Contact Number" type="tel" value="<%= person_info.getPhone() %>">
        <select name="deplome" id="deplome" style="height: 54px;">
          <% List<deplome> diplomas = manager.getalldeplomes(); %>
          <% for(deplome dep : diplomas) { %>
          <% if(dep.getId() == person_info.getDeplome_id()){%>
            <option value="<%= dep.getId() %>" selected><%= dep.getName() %></option>
          <% }else{%>
              <option value="<%= dep.getId() %>"><%= dep.getName() %></option>
          <% } %>
          <% }%>
        </select>
        <input name="PASSWORD" required placeholder="PASSWORD for Department dean account" type="password" value="<%=old_password%>">
        <div class="radio-inputs">
        <% for(String deptName : departmentNames) { 
          boolean isChecked = deptName.equals(old_department);
          %>
          <label class="radio">
              <input type="radio" name="departmentChoice" value="<%= deptName %>" <%= isChecked ? "checked" : "" %>>            <span class="name" ><%= deptName %></span>
          </label>
        <% } %>
      </div>
        <button type="submit" class="submit-btn"> SAVE</button>
      <% } else { %>
        <button type="submit" class="submit-btn">CHECK EMAIL</button>
      <% } %>
    </form>

  </section>
  
</body>
<script>
function goToLink(url) {
  window.location.href = url;
}
</script>
</html>
