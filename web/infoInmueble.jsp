<%@ include file="header.jsp" %>

    <h3>${messages["inmueble_actual"]}</h3>

<c:if test="${!empty inmueble_actual}">
    <table class="table table-bordered table-dark"
           <thead class="thead-dark">
            <tr>
                <th scope="col">Atributos</th>
                <th scope="col">Datos</th>
            </tr>
        </thead>

        <tr>
            <td>Predial: </td>
            <td>${inmueble_actual.getPredial()}</td>
        </tr>

        <tr>
            <td>Estrato: </td>
            <td>${inmueble_actual.getEstrato()}</td>
        </tr>

        <tr>
            <td>Area: </td>
            <td>${inmueble_actual.getArea()}</td>
        </tr>

        <tr>
            <td>Numero de Banos: </td>
            <td>${inmueble_actual.getBanos()}</td>
        </tr>

        <tr>
            <td>Numero de Cuartos: </td>
            <td>${inmueble_actual.getCuartos()}</td>
        </tr>

        <tr>
            <td>Ciudad: </td>
            <td>${inmueble_actual.getCiudad()}</td>
        </tr>

        <tr>
            <td>Estado actual: </td>
            <td>${inmueble_actual.getTipo()}</td>
        </tr>
    </table>
    <h3>Informacion adicional: </h3>
    <br>
    <c:if test="${!empty contrato_actual}">
        <table class="table table-bordered table-dark"
               <thead class="thead-dark">
                <tr>
                    <th scope="col">Atributos</th>
                    <th scope="col">Datos</th>
                </tr>
            </thead>

            <tr>
                <td>Fecha: </td>
                <td>${contrato_actual.getFecha()}</td>
            </tr>

            <tr>
                <td>Valor: </td>
                <td>${contrato_actual.getValor()}</td>
            </tr>

            <tr>
                <td>Disponible: </td>
                <td>${contrato_actual.getDisponible()}</td>
            </tr>

            <c:if test="${inmueble_actual.getTipo()=='enArriendo'}">
                <tr>
                    <td>Agencia: </td>
                    <td>${contrato_actual.getAgencia()}</td>
                </tr>
            </c:if>
        </table>



    </c:if>

    <c:if test="${!empty propietario}">
        <h3>Editar:</h3>
        <form method="GET" action="./editarContrato">
            <br />
            <input type="text" name="editar_contrato" hidden="true" value="editar contrato" class="form-control"/>
            <div class="form-group row" >
                <input type="submit" class="btn btn-dark" value="Editar solo el inmueble" name="accion" />
            </div>

        </form>
        <form method="POST" action="./editarContrato">
            <br />
            <div class="form-group row" >
                <input type="submit" class="btn btn-dark" value="Nuevo contrato de venta" name="boton" />
            </div>
            <br>
            <div class="form-group row" >
                <input type="submit" class="btn btn-dark" value="Nuevo contrato de arriendo" name="boton" />
            </div>
            

        </form>
    </c:if>

    <c:if test="${!empty logeado}">
        <h3>¿Desea aplicar a este inmueble?</h3>
        <form method="POST" action="./aplicarContrato">
            <br />
            <input type="text" name="aplicar_contrato" hidden="true" value="aplicar contrato" class="form-control"/>
            <div class="form-group row" >
                <input type="submit" class="btn btn-primary" value="Aplicar" name="accion" />
            </div>

        </form>
    </c:if>


</c:if>


<%@ include file="footer.jsp" %>
