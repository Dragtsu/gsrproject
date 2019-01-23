<div class="title">  <h4>Programacion de Mantenimientos y Servicios</h4></div>
<div>
    <fieldset class="form-inline">    
        <form>                       
        <table> 
            <tr><td>Id Programacion Servicio:</td><td><input type="text" class="form-control" name="id_programacion_servicio" default="PS"  value="PS" readOnly></td></tr>
            <tr><td>Id unidad:</td>
                <td>
                    <input type="text" id="id_unidad" class="form-control" name="id_unidad" readOnly >              
                    <button type="button" id="Unidad" input-target="id_unidad" class="btn btn-primary bt-catalogo" data-toggle="modal" >...</button>                       
                </td>
            </tr>
            <tr><td>Tipo Servicio:</td>
                <td>
                    <input type="text"  id="id_servicio" class="form-control" name="id_servicio" readOnly>                                     
                    <button type="button" id="Servicios" input-target="id_servicio" class="btn btn-primary bt-catalogo" data-toggle="modal" >...</button>
                </td>
            </tr>
            <tr><td>Descripcion:</td><td><textarea name="sDescripcion" class="form-control" id="sDescripcion" maxlength="100"></textarea></td></tr>
            <tr><td>Fecha programada Mantenimiento:</td><td><input type="text" name="fProgramadaServicio"  maxlength="10"  class="datepicker form-control" readOnly></td></tr>
            <tr><td>Costo total:</td><td><input type="text" name="nCostoServicioProgramado" class="input-money form-control" maxlength="9"></td></tr>
            <tr><td>Realizado:</td>
                <td>                    
                    <select name="mantoRealizado" id="unidad_disponible" class="form-control">
                            <option value="1">SI</option>
                            <option value="0" selected >NO</option>
                    </select>
                </td></tr>
        </table>
        <div class="adjust">
            <fieldset>
                <input type="hidden" name="table" value="ProgramacionServicios" id="tableShow">  
                <input type="hidden" name="action" value="save" id="action"> 
                <input type="button" class="btn btn-primary" id="save" value="Guardar"/>
                <input type="button" class="btn btn-primary" id="limpiar" value="Limpiar"/>
                <input type="button" class="btn btn-primary" value="Cancelar" id="cancelarBt" style="display:none;">                           
            </fieldset>
        </div>
        </form>
    </fieldset>
</div> 
<fieldset>
    <div class="adjust">
        <fieldset>
            <input type="button" class="btn btn-primary" value="Eliminar" id="deleteBt">     
            <input type="button" class="btn btn-primary" value="Modificar" id="updateBt">     
            <input type="text"   id="sSearch" maxlength="10">
            <input type="button" class="btn btn-primary" value="Buscar" id="buscarBt">  
            <input type="button" class="btn btn-primary" value="Limpiar" id="limpiaBuscar"> 
        </fieldset>
    </div>                    
    <table class="display dataTablex">
        <thead>
        <th>Id programacion servicio</th>
        <th>Unidad</th>
        <th>Nombre Unidad</th>
        <th>Servicio</th>
        <th>Nombre Servicio</th> 
        <th>Descripcion programa</th>
        <th>Fecha programada</th>  
        <th>Costo total</th>  
        <th>Realizado</th>  
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>
<script src="js/onLoad.js" type="text/javascript"></script>
