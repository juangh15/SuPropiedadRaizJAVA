<%@ include file="header.jsp" %>
<form method="POST" action="./index">
    <br />
    <input type="text" name="ficticios" hidden="true" value="agragar ficticios" class="form-control"/>
    <div class="form-group row" >
        <input type="submit" class="btn btn-dark" value="Agregar datos ficticios " name="accion" />
    </div>
    
</form>
<form method="POST" action="./index">
    <br />
    <input type="text" name="ficticios" hidden="true" value="agregar clientes desde txt" class="form-control"/>
    <div class="form-group row" >
        <input type="submit" class="btn btn-dark" value="Agregar clientes desde txt " name="accion" />
    </div>
    
</form>

<%@ include file="footer.jsp" %>
