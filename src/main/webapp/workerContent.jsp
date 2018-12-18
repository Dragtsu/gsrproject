<h2 id="Titulo">Trabajador</h2>
<div>
    <fieldset class="form-group">                        

        <form>
            <table>                                
                <tr><td>Numero Celular:</td><td><input type="text" name="Num_Celular" class="readOnly input-number" maxlength="10"></td></tr>
                <tr><td>Nombre:</td><td><input type="text" name="Nombre" maxlength="25"></td></tr>
                <tr><td>Apellido Paterno:</td><td><input type="text" name="Apellido_Paterno" maxlength="15"></td></tr>
                <tr><td>Apellido Materno:</td><td><input type="text" name="Apellido_Materno" maxlength="15"></td></tr>
                <tr><td>Fecha Vencimiento Licencia:</td><td><input  type="text" name="Vigencia_Licencia" id="datepicker" readOnly maxlength="10"></td></tr>
            </table>

            <div class="adjust">
                <fieldset>
                    <input type="hidden" name="table" value="worker" id="tableShow">                                                                      
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
        <th>Numero Celular</th>
        <th>Nombre</th>
        <th>Apellido Paterno</th>
        <th>Apellido Materno</th>
        <th>Fecha Vencimiento Licencia</th>
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>
<script src="js/onLoad.js" type="text/javascript"></script>