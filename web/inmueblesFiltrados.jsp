<%@ include file="header.jsp" %>
<c:if test="${!empty propietario || !empty logeado}">
    <c:if test="${!empty busqueda}">
        <c:if test="${busqueda.equals('buscarPorPredial')}">
            <h3>Inmuebles filtrados por predial</h3>
        </c:if>
        <c:if test="${busqueda.equals('buscarPorEstrato')}">
            <h3>Inmuebles filtrados por estrato</h3>
        </c:if>
        <c:if test="${busqueda.equals('buscarPorCiudad')}">
            <h3>Inmuebles filtrados por ciudad</h3>
        </c:if>
        <c:if test="${busqueda.equals('buscarPorNumeroDeBanos')}">
            <h3>Inmuebles filtrados por numero de banos</h3>
        </c:if>
        <c:if test="${busqueda.equals('buscarPorNumeroDeCuartos')}">
            <h3>Inmuebles filtrados por numero de cuartos</h3>
        </c:if>
        <c:if test="${busqueda.equals('buscarPorArea')}">
            <h3>Inmuebles filtrados por area</h3>
        </c:if>
        <c:if test="${busqueda.equals('buscarInmueblesEnCompraventa')}">
            <h3>Inmuebles en compraventa</h3>
        </c:if>
        <c:if test="${busqueda.equals('buscarInmueblesEnArriendo')}">
            <h3>Inmuebles en arriendo</h3>
        </c:if>



    </c:if>

    <c:if test="${empty filtrados}"><h3>No se han encontrado Inmuebles con estas caracteristicas</h3></c:if>

    <c:if test="${!empty filtrados}">
        <table class="table table-bordered table-dark"
               <thead class="thead-dark">
                <tr>
                    <th scope="col">${messages["predial"]}</th>
                    <th scope="col">${messages["estrato"]}</th>
                    <th scope="col">${messages["area"]}</th>
                    <th scope="col">${messages["banos"]}</th>
                    <th scope="col">${messages["cuartos"]}</th>
                    <th scope="col">${messages["ciudad"]}</th>
                    <th scope="col">${messages["tipo"]}</th>
                </tr>
            </thead>
            <c:forEach items="${filtrados}" var="inmu">
                <tr>
                    <td>${inmu.getPredial()}</td>
                    <td>${inmu.getEstrato()}</td>
                    <td>${inmu.getArea()}</td>
                    <td>${inmu.getBanos()}</td>
                    <td>${inmu.getCuartos()}</td>
                    <td>${inmu.getCiudad()}</td>
                    <td>${inmu.getTipo()}</td>
                    <td><a href="./infoInmueble?predial=${inmu.getPredial()}">ver mas</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</c:if>
<c:if test="${empty propietario && empty logeado}">
    <h3>Debe iniciar sesion para completar esta accion.</h3>
</c:if>
<%@ include file="footer.jsp" %>
