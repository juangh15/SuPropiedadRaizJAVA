<%@ include file="header.jsp" %>

<h3>${messages["lista_inmuebles"]}</h3>
<c:if test="${!empty Inmuebles}">
    <table class="table table-bordered table-dark"
    <thead class="thead-dark">
           <tr>
        <th scope="col">${messages["predial"]}</th>
        <th scope="col">${messages["estrato"]}</th>
        <th scope="col">${messages["area"]}</th>
        <th scope="col">${messages["banos"]}</th>
        <th scope="col">${messages["cuartos"]}</th>
        <th scope="col">${messages["ciudad"]}</th>
    </tr>
        </thead>
    <c:forEach items="${Inmuebles}" var="inmu">
        <tr>
            <td>${inmu.getPredial()}</td>
            <td>${inmu.getEstrato()}</td>
            <td>${inmu.getArea()}</td>
            <td>${inmu.getBanos()}</td>
            <td>${inmu.getCuartos()}</td>
            <td>${inmu.getCiudad()}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>


<%@ include file="footer.jsp" %>
