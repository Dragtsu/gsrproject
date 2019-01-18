<h2 id="Titulo">Programacion de Servicios</h2>
<div>
    <fieldset class="form-inline">    
        <form>                       
        <table>                                
            <tr><td>Id unidad:</td>
                <td>
                    <input type="text" id="id_unidad" class="form-control" name="id_unidad" readOnly >              
                    <button type="button" id="vehicle" input-target="id_unidad" class="btn btn-primary bt-catalogo" data-toggle="modal" >...</button>                       
                </td>
            </tr>
            <tr><td>Tipo Servicio:</td>
                <td>
                    <input type="text"  id="id_servicio" class="form-control" name="id_servicio" readOnly>                                     
                    <button type="button" id="tServicios" input-target="id_servicio" class="btn btn-primary bt-catalogo" data-toggle="modal" >...</button>
                </td>
            </tr>
            <tr><td>Descripcion:</td><td><textarea name="sDescripcion" class="form-control" id="sDescripcion" maxlength="100"></textarea></td></tr>
            <tr><td>Fecha programada Mantenimiento:</td><td><input type="text" class="form-control" name="fMantenimiento"  maxlength="10"  class="datepicker"></td></tr>
            <tr><td>Costo total:</td><td><input name="nCosto" class="form-control"></td></tr>
            <tr><td>Realizado:</td><td><input type="checkbox" class="form-control" name="mantoRealizado" ></td></tr>
        </table>
        <div class="adjust">
            <fieldset>
                <input type="hidden" name="table" value="Mantenimiento" id="tableShow">  
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
        <th>Id unidad</th>
        <th>Tipo Mantenimiento</th>
        <th>Descripcion</th>  
        <th>Fecha programada Mantenimiento</th>  
        <th>Costo total</th>  
        <th>Realizado</th>  
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>

<script src="js/onLoad.js" type="text/javascript"></script>