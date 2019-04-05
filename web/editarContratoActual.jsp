<%@ include file="header.jsp" %>

<h3>Contrato nuevo para el inmueble de predial: ${inmueble_actual.getPredial()} </h3>

<c:if test="${!empty inmueble_actual}">
    <form method="POST" action="./editarContrato">

        <table class="table table-bordered table-dark"
               <thead class="thead-dark">
                <tr>
                    <th scope="col">Atributos</th>
                    <th scope="col">Datos</th>
                </tr>
            </thead>

            <tr>
                <td>Fecha creacion de contrato: </td>
                <td><label name="fecha" class="form-control"><script>
                           var f = new Date();
                           document.write(f.getDate() + '/' + (f.getMonth() +1) + '/' + f.getFullYear());
                    </script>
                    </label></td>
            </tr>

            <tr>
                <td>Valor*: </td>
                <td><input type="text" name="valor" required="true" class="form-control"/></td>

            </tr>

            <tr>
                <td>Disponible: </td>
                <td><select class="form-control" name='disponible' >
                        <option value=true>Si</option>
                        <option value=false>No</option>
                </td>
                </select>   
            </tr>

            <c:if test="${tipo_contrato=='Nuevo contrato de venta'}">
                <tr>
                    <td>Agencia: </td>
                    <td><select class="form-control" name='agencia' >
                            <option value="si">Si</option>
                            <option value="no">No</option>
                    </td>
                </tr>
                <tr>
                    <td>Tipo de pago: </td>
                    <td><select class="form-control" name='tipo_pago' >
                            <option value="A cuotas">A cuotas</option>
                            <option value="A credito">A credito</option>
                    </td>
                </tr>
            </c:if>
            <c:if test="${tipo_contrato=='Nuevo contrato de arriendo'}">
                <tr>
                    <td>Medio de pago: </td>
                    <td><select class="form-control" name='medio_pago' >
                            <option value="efectivo">Efectivo</option>
                            <option value="tarjeta">Tarjeta</option>
                    </td>
                </tr>
            </c:if>
        </table>






        <div class="form-group row" >
            <input type="submit" class="btn btn-primary" value="Guardar contrato" name="boton" />
        </div>

    </form>




</c:if>


<%@ include file="footer.jsp" %>

