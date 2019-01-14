<h2 id="Titulo">Programas de Mantenimiento</h2>
<div>
    <fieldset class="form-group">                        
        <table>                                
            <tr><td>Id unidad:</td><td><input type="text" id="id_unidad" name="id_unidad" readOnly ></td>
                <td>
                    <button type="button" id="vehicle" input-target="id_unidad" class="btn btn-primary bt-catalogo" data-toggle="modal" >...</button>                       
                </td>
            </tr>
            <tr><td>Tipo Servicio:</td><td><input type="text"  id="id_servicio" name="id_servicio" readOnly></td>
                <td>                      
                    <button type="button" id="tServicios" input-target="id_servicio" class="btn btn-primary bt-catalogo" data-toggle="modal" >...</button>
                </td>
            </tr>
            <tr><td>Descripcion:</td><td><textarea name="sDescripcion" id="sDescripcion" maxlength="100"></textarea></td><td></td></tr>
            <tr><td>Fecha programada Mantenimiento:</td><td><input type="text" name="fMantenimiento" id="sDescripcion" maxlength="10" readOnly class="datepicker"></td><td></td></tr>
            <tr><td>Costo total:</td><td><input name="nCosto"></td><td></td></tr>
            <tr><td>Realizado:</td><td><input type="checkbox" name="mantoRealizado" ></td><td></td></tr>
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