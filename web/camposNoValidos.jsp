<%-- 
    Document   : camposNoValidos
    Created on : 4/04/2019, 09:20:02 PM
    Author     : pedrcabu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% out.print( session.getAttribute("error")); %></h1>
        <% String url = session.getAttribute("urlAnterior").toString(); %>
        <a href= "<%=url%>"> regresar al formulario </a>
    </body>
</html>
