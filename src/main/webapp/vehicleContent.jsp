<h2 id="Titulo">Unidad</h2>
<div  class="form-group">
    <fieldset>                        

        <form>
            <table>                                
                <tr><td>Id Vehiculo:</td><td><input type="text" name="id_vehiculo" class="readOnly input-number" maxlength="18"></td></tr>
                <tr><td>Descripcion:</td><td><textarea rows="2" cols="50" name="sDescripcion" id="sDescripcion"  class="form-control" ></textarea></td></tr>
                <tr><td>Fecha Mantenimiento:</td><td><input type="text" name="fMantenimiento" maxlength="10"  class="datepicker"></td></tr>
                <tr><td>Fecha Verificacion:</td><td><input type="text" name="fVerificacion" maxlength="10"  class="datepicker"></td></tr>
                <tr><td>Fecha Seguro:</td><td><input type="text" name="fSeguro" maxlength="10"  class="datepicker"></td></tr>
                <tr><td>Costo del Servicio:</td><td><input  type="text" name="nCostoServicio" class="input-money" maxlength="8"></td></tr>
            </table>

            <div class="adjust">
                <fieldset>
                    <input type="hidden" name="table" value="vehicle" id="tableShow">   
                    <input type="hidden" name="action" value="save" id="action"> 
                    <input type="button" id="save" value="Guardar"/>
                    <input type="button" id="limpiar" value="Limpiar"/>
                    <input type="button" value="Cancelar" id="cancelarBt" style="display:none;">                           
                </fieldset>
            </div>
        </form>
    </fieldset>
</div> 
<fieldset>
    <div class="adjust">
        <fieldset>
            <input type="button" value="Eliminar" id="deleteBt">     
            <input type="button" value="Modificar" id="updateBt">     
            <input type="text"   id="sSearch" maxlength="15">
            <input type="button" value="Buscar" id="buscarBt">  
            <input type="button" value="Limpiar" id="limpiaBuscar"> 

        </fieldset>
    </div>                    
    <table class="display dataTablex">
        <thead>
        <th>Id Vehiculo</th>
        <th>Descripcion</th>
        <th>Fecha Mantenimiento</th>
        <th>Fecha Verificacion</th>
        <th>Fecha Seguro</th>
        <th>Costo del Servicio</th>
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>

<script src="js/onLoad.js" type="text/javascript"></script>