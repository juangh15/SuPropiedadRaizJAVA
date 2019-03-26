<%@ include file="header.jsp" %>

<h3>${messages["lista_clientes"]}</h3>
<c:if test="${!empty Clientes}">
    <table class="table table-bordered table-dark"
    <thead class="thead-dark">
           <tr>
        <th scope="col">${messages["cedula"]}</th>
        <th scope="col">${messages["nombre"]}</th>
        <th scope="col">${messages["correo"]}</th>
    </tr>
        </thead>
    <c:forEach items="${Clientes}" var="cli">
        <tr>
            <td>${cli.getCedula()}</td>
            <td>${cli.getNombre()}</td>
            <td>${cli.getCorreo()}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>


<%@ include file="footer.jsp" %>