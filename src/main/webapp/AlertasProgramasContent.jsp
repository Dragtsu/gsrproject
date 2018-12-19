<style>
    
    .foo {
  float: left;
  width: 20px;
  height: 20px;
  margin: 5px;
  border: 1px solid rgba(0, 0, 0, .2);
}

.yellow {
  background: yellow;
}

.red {
  background: red;
}

    
    
</style>
<h2 id="Titulo">Alertas de programas</h2>
<div>
    <fieldset class="form-group">         
        <legend>Color de alerta:</legend>
        <table>
            <tr><td><div class="foo yellow"></div></td> <td>Proximo a caducar</td></tr>
            <tr><td><div class="foo red"></div></td><td> Caducado</td></tr>
        </table>

    </fieldset>
</div> 
<fieldset>                   
    <table class="display dataTablex">
        <thead>
        <th>Tipo de programa</th>
        <th>Id Unidad o Trabajador</th>
        <th>Descripcion</th>  
        <th>Fecha programada de realizacion</th>        
        </thead>               
        <tbody></tbody>
    </table>                    
</fieldset>
<script src="js/onLoad.js" type="text/javascript"></script>