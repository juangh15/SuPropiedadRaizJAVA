<%@ include file="header.jsp" %>
<c:if test="${!empty propietario || !empty logeado}">

    <c:if test="${busqueda.equals('buscarPorPredial')}">

        <h3>Buscar por predial: </h3>
        <form method="POST" action="./buscarInmuebles">
            <br /><br />
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar Predial del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="predial" required class="form-control"/><br /><br />
                    <input type="text" name ="busqueda" hidden="true" value="buscarPorPredial"/>
                </div>
            </div>
            <input type="submit" class="btn btn-dark" value="Buscar" />

        </form>  
    </c:if>
    <c:if test="${busqueda.equals('buscarPorEstrato')}">

        <h3>Buscar por estrato: </h3>
        <form method="POST" action="./buscarInmuebles">
            <br /><br />
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar Estrato del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="estrato" required class="form-control"/><br /><br />
                    <input type="text" name ="busqueda" hidden="true" value="buscarPorEstrato"/>
                </div>
            </div>
            <input type="submit" class="btn btn-dark" value="Buscar" />

        </form>  
    </c:if>

    <c:if test="${busqueda.equals('buscarPorArea')}">

        <h3>Buscar por Area: </h3>
        <form method="POST" action="./buscarInmuebles">
            <br /><br />
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar area minima del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="area_minima" required class="form-control"/><br /><br />
                </div>
            </div>
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar area maxima del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="area_maxima" required class="form-control"/><br /><br />
                </div>
            </div>
            <input type="submit" name ="busqueda" class="btn btn-dark" value="buscarPorArea" />
            

        </form>
    </c:if>

    <c:if test="${busqueda.equals('buscarPorNumeroDeBanos')}">

        <h3>Buscar por numero de banos: </h3>
        <form method="POST" action="./buscarInmuebles">
            <br /><br />
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar banos minimos del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="banos_minima" required class="form-control"/><br /><br />
                </div>
            </div>
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar banos maximos del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="banos_maxima" required class="form-control"/><br /><br />
                </div>
            </div>
            <input type="submit" name ="busqueda" class="btn btn-dark" value="buscarPorNumeroDeBanos" />
        </form>
    </c:if>

    <c:if test="${busqueda.equals('buscarPorNumeroDeCuartos')}">

        <h3>Buscar por numero de cuartos: </h3>
        <form method="POST" action="./buscarInmuebles">
            <br /><br />
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar cuartos minimos del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="cuartos_minima" required class="form-control"/><br /><br />
                </div>
            </div>
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar cuartos maximos del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="cuartos_maxima" required class="form-control"/><br /><br />
                </div>
            </div>
            <input type="submit" name ="busqueda" class="btn btn-dark" value="buscarPorNumeroDeCuartos" />
        </form>
    </c:if>

    <c:if test="${busqueda.equals('buscarPorCiudad')}">

        <h3>Buscar por ciudad: </h3>
        <form method="POST" action="./buscarInmuebles">
            <br /><br />
            <div class="form-group row" >
                <label class="col-sm-2 col-form-label">Ingresar Ciudad del inmueble*:</label > 
                <div class="col-sm-7">
                    <input type="text" name="ciudad" required class="form-control"/><br /><br />
                </div>
            </div>
            <input type="submit" name ="busqueda" class="btn btn-dark" value="buscarPorCiudad" />

        </form>  
    </c:if>

</c:if>
<c:if test="${empty logeado && empty propietario}">
    <h3>Debe iniciar sesion para completar esta accion.</h3>
</c:if>



<%@ include file="footer.jsp" %>



