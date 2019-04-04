<%@ include file="header.jsp" %>
<c:if test="${!empty propietario}">
    <h3>${messages["lista_inmuebles_propietario"]}</h3>
    <br>
</c:if>
<c:if test="${empty propietario}">
    <h3>${messages["lista_inmuebles"]}</h3>
    <br>
</c:if>

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
                <th scope="col">${messages["tipo"]}</th>
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
                <td>${inmu.getTipo()}</td>
                <td><a href="./infoInmueble?predial=${inmu.getPredial()}">ver mas</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
    
<br>
<h3>Buscador de inmuebles: </h3>
<br>
<form method="GET" action="./buscarInmuebles">
    <br>
    <div class="form-group">
        <select class="custom-select" name='busqueda' >
            <option value="buscarPorPredial">Buscar inmuebles por predial</option>
            <option value="buscarInmueblesEnCompraventa">Buscar inmuebles en venta</option>
            <option value="buscarInmueblesEnArriendo">Buscar inmuebles en arriendo</option>
            <option value="buscarPorCiudad">Buscar inmuebles por ciudad</option>
            <option value="buscarPorEstrato">Buscar inmuebles por estrato</option>
            <option value="buscarPorNumeroDeBanos">Buscar inmuebles por numero de banos</option>
            <option value="buscarPorNumeroDeCuartos">Buscar inmuebles por numero de cuartos</option>
            <option value="buscarPorArea">Buscar inmuebles por area</option>

        </select>
    </div>
    <div class="form-group">
        <input type="submit" class="btn btn-dark" value="busqueda">
    </div>
</form>

<%@ include file="footer.jsp" %>
