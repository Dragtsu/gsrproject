<h2 id="Titulo">Programacion de salida a campo</h2>
<div>
    <fieldset class="form-group">                        

        <form>
            <table>                                
                <tr><td>Id unidad:</td><td><input type="text" name="id_unidad" readOnly ></td><td><input type="button" id="cat_id_unidad" value="Seleccionar"/></td></tr>
                <tr><td>Id Trabajador:</td><td><input type="text" name="id_tipo_mantenimiento" maxlength="25"></td><td><input type="button" id="cat_id_unidad" value="Seleccionar"/></td></tr>
                <tr><td>Descripcion:</td><td><textarea name="sDescripcion" id="sDescripcion" maxlength="100"></textarea></td><td></td></tr>
                <tr><td>Fecha programada salida:</td><td><input type="text" name="fMantenimiento" id="sDescripcion" maxlength="10" readOnly class="datepicker"></td><td></td></tr>
                <tr><td>Checklist Realizado</td><td><input type="checkbox" name="mantoRealizado" ></td><td></td></tr>

            </table>

            <div class="adjust">
                <fieldset>
                    <input type="hidden" name="table" value="Mantenimiento" id="tableShow">  
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
            <input type="text"   id="sSearch" maxlength="10">
            <input type="button" value="Buscar" id="buscarBt">  
            <input type="button" value="Limpiar" id="limpiaBuscar"> 

        </fieldset>
    </div>                    
    <table class="display dataTablex">
        <thead>
        <th>Id unidad</th>
        <th>Id Trabajador</th>
        <th>Descripcion</th>  
        <th>Fecha programada salida</th>  
        <th>CheckList Realizado</th>          
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>
<script src="js/onLoad.js" type="text/javascript"></script>