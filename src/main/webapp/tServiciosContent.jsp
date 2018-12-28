<h2 id="Titulo">Listado de Servicios</h2>
<div>
    <fieldset class="form-group">                        

        <form>
            <table>                                
                <tr><td>Id Servicio:</td><td><input type="text" class="tm" name="id_servicio"  value="SM" readOnly></td></tr>
                <tr><td>Nombre del Servicio:</td><td><input type="text" name="nombre_servicio" maxlength="30"></td></tr>
                <tr><td>Descripcion:</td><td><textarea name="sDescripcion" id="sDescripcion" maxlength="100"></textarea></td></tr>
                 <tr><td>Costo del Servicio:</td><td><input  type="text" name="nCostoServicio" class="input-money" maxlength="8"></td></tr>
            </table>

            <div class="adjust">
                <fieldset>
                    <input type="hidden" name="table" value="tServicios" id="tableShow">  
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
        <th>Id Servicio</th>
        <th>Nombre del Servicio</th>
        <th>Descripcion</th>  
        <th>Costo del Servicio</th>    
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>

<script src="js/onLoad.js" type="text/javascript"></script>