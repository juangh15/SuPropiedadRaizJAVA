<%@ include file="header.jsp" %>
<h5> * Por favor marque los cambios que va a realizar al Inmueble y luego rellene el campo correspondiente. * </h5>
<h5> * (Solo se reemplazaran los cambios marcados y no vacios)</h5>
<br>
<h3>Editar Inmueble:</h3>
<br>

<form method="POST" action="./editarContrato">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["predial"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="predial" class="form-control"/><br /><br />
        </div>
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_predial" value="check_predial" aria-label="...">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["disponible"]}*: </label>
        <div class="col-sm-1">
            <select class="custom-select" name='disponible' >
                <option value=true>Si</option>
                <option value=false>No</option>
            </select>
        </div>
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_disponible" value="check_disponible" aria-label="...">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["estrato"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="estrato" class="form-control"/><br /><br />
        </div>
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_estrato" value="check_estrato" aria-label="...">
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
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_vigilancia" value="check_vigilancia" aria-label="...">
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
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_ascensor" value="check_ascensor" aria-label="...">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["area"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="area"  class="form-control"/><br /><br />
        </div>
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_area" value="check_area" aria-label="...">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["banos"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="banos"  class="form-control"/><br /><br />
        </div>
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_banos" value="check_banos" aria-label="...">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["cuartos"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="cuartos" class="form-control"/><br /><br />
        </div>
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_cuartos" value="check_cuartos" aria-label="...">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["ciudad"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="ciudad"  class="form-control"/><br /><br />
        </div>
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_ciudad" value="check_ciudad" aria-label="...">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">${messages["antiguedad"]}*: </label>
        <div class="col-sm-2">
            <input type="text" name="antiguedad"  class="form-control"/><br /><br />
        </div>
        <div class="form-check">
            <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" name = "check_antiguedad" value="check_antiguedad" aria-label="...">
        </div>
    </div>
    <input type="submit" class="btn btn-dark" value="Guardar" name="boton" />
    <br>
    

</form>

<%@ include file="footer.jsp" %>
