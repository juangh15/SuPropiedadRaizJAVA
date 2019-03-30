<%@ include file="header.jsp" %>
<h3>${messages["nuevo_inmueble"]}</h3>
<form method="POST" action="./nuevoInmueble">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["predial"]}*: </label>
        <div class="col-sm-7">
            <input type="text" name="predial" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["estrato"]}*: </label>
        <div class="col-sm-7">
            <input type="text" name="estrato" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["vigilancia"]}: </label>
        <div class="col-sm-1">
            <select class="custom-select" name='vigilancia' >
                <option value=true>Si</option>
                <option value=false>No</option>
            </select>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["ascensor"]}: </label>
        <div class="col-sm-1">
            <select class="custom-select" name='ascensor' >
                <option value=true>Si</option>
                <option value=false>No</option>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["area"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="area" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["banos"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="banos" required="true" class="form-control"/><br /><br />
        </div>
    </div>
        <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["cuartos"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="cuartos" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["tipo"]}: </label>
        <div class="col-sm-4">
            <select class="custom-select" name='tipo' >
                <option value=enVenta>${messages["venta"]}</option>
                <option value=enArriendo>${messages["arriendo"]}</option>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["ciudad"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="ciudad" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["antiguedad"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="antiguedad" required="true" class="form-control"/><br /><br />
        </div>
    </div>
    <input type="submit" class="btn btn-dark" value="Guardar" />

</form>

<%@ include file="footer.jsp" %>
