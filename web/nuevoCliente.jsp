<%@ include file="header.jsp" %>
<h3>${messages["nuevo_cliente"]}</h3>
<form method="POST" action="./nuevoCliente">
    <br /><br />
    <div class="form-group row" >
        <label class="col-sm-2 col-form-label">${messages["cedula"]}*:</label > 
        <div class="col-sm-7">
            <input type="text" name="cedula" required class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["nombre"]}*:</label> 
        <div class="col-sm-7">
            <input type="text" name="nombre" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["contrasena"]}*: </label>
        <div class="col-sm-7">
            <input type="password" name="contrasena" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["correo"]}*: </label>
        <div class="col-sm-7">
            <input type="text" name="correo" required="true"  class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["direccion"]}*: </label>
        <div class="col-sm-7">
            <input type="text" name="direccion" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <input type="submit" class="btn btn-dark" value="Guardar" />

</form>

<%@ include file="footer.jsp" %>