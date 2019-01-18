<h2 id="Titulo">Unidad</h2>
<div  class="form-inline">
    <fieldset>               
        <form>
            <table>                                
                <tr><td>Id Unidad:</td><td><input type="text" name="id_unidad" class="input-number form-control"  maxlength="18"></td></tr>
                <tr><td>Nombre:</td><td><input type="text" name="sNombre" class="form-control" maxlength="25" ></td></tr>
                <tr><td>Descripci&oacute;n:</td><td><textarea rows="2" cols="50" maxlength="100" name="sDescripcion" id="sDescripcion"  class="form-control" ></textarea></td></tr>              
                <tr><td>Unidad disponible:</td>
                    <td>
                        <select name="unidad_disponible" id="unidad_disponible" class="form-control">
                            <option value="1">SI</option>
                            <option value="0">NO</option>
                        </select>
                    </td>
                </tr>
               </table>
            <div class="adjust">
                <fieldset>
                    <input type="hidden" name="table" value="vehicle" id="tableShow">   
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
            <input type="text"   id="sSearch" maxlength="15">
            <input type="button" class="btn btn-primary" value="Buscar" id="buscarBt">  
            <input type="button" class="btn btn-primary" value="Limpiar" id="limpiaBuscar">              
        </fieldset>
    </div>                    
    <table class="display dataTablex">
        <thead>
        <th>Id Unidad</th>
        <th>Nombre</th>
        <th>Descripcion</th>
        <th>Unidad disponible</th>        
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>

<script src="js/onLoad.js" type="text/javascript"></script>