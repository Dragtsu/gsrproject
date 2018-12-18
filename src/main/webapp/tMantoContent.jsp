<h2 id="Titulo">Trabajador</h2>
<div>
    <fieldset class="form-group">                        

        <form>
            <table>                                
                <tr><td></td><td><input type="text" name="id_tipo_mantenimiento"  value="TM" ></td></tr>
                <tr><td>Tipo Mantenimiento:</td><td><input type="text" name="tipo_mantenimiento" maxlength="25"></td></tr>
                <tr><td>Descripcion:</td><td><textarea name="sDescripcion" id="sDescripcion" maxlength="100"></textarea></td></tr>
                            </table>

            <div class="adjust">
                <fieldset>
                    <input type="hidden" name="table" value="tManto" id="tableShow">                                                                      
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
        <th>Id Matenimiento</th>
        <th>Tipo Mantenimiento</th>
        <th>Descripcion</th>        
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>
<script src="js/onLoad.js" type="text/javascript"></script>