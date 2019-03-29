<%@ include file="header.jsp" %>
<c:if test="${empty logeado and empty propietario}">
    <form method="POST" action="./login">
        <br /><br />
        <div class="form-group row" >
            <label class="col-sm-2 col-form-label">${messages["cedula"]}*:</label > 
            <div class="col-sm-7">
                <input type="text" name="cedula" required class="form-control"/><br /><br />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">${messages["contrasena"]}*:</label> 
            <div class="col-sm-7">
                <input type="password" name="contrasena" required="true" class="form-control"/><br /><br />
            </div>
        </div>
        <input type="submit" class="btn btn-dark" value="Ingresar" />

    </form>
</c:if>
<c:if test="${!empty logeado}">
    <h3>
        logeado
        ${logeado.getNombre()}
        <form method="POST" action="./logout">
            <br />
            <div class="form-group row" >
                <input  type="submit" class="btn btn-dark" value="Cerrar sesion" name="accion" />
            </div>
        </form>

    </h3>
</c:if >
<c:if test="${!empty propietario}">
    <h3>
        Bienvenido propietario: 
        ${propietario.getNombre()}
        <form method="POST" action="./logout">
            <br />
            <div class="form-group row" >
                <input  type="submit" class="btn btn-dark" value="Cerrar sesion" name="accion" />
            </div>
        </form>

    </h3>
</c:if >

<%@ include file="footer.jsp" %>