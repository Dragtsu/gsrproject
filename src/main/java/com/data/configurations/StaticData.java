/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.configurations;

import com.data.models.TbTrabajador;
import com.data.models.TbUnidad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author dragneel
 */
public class StaticData {

    public static final String TRABAJADOR = "worker";
    public static final String UNIDAD = "vehicle";
    public static final String TIPO_MANTENIMIENTO = "tManto";

    public final static int OPERACION_EXITOSA = 0;
    public final static int REGISTRO_EXISTE = 1;
    public final static int ERROR_GENERAL = 2;

    public static final String WORKER_OK = "Trabajador agregado";
    public static final String WORK_EXIST = "Ya existe un trabajador con ese número de celular.";
    public static final String WORKER_FAIL = "Ocurrió un error al guardar los datos del trabajador.";
    public static final String WORKER_UDATE_OK = "Datos del trabajador modificados correctamente";
    public static final String WORKER_DEL_OK="Trabajador eliminado correctamente.";
    public static final String WORKER_DEL_FAIL="Ocurrio un error al eliminar los datos del trabajador.";  
    
    public static final String UNIDAD_OK = "Unidad agregada";
    public static final String UNIDAD_EXIST = "Ya existe una Unidad con ese identificador";
    public static final String UNIDAD_FAIL = "Ocurrió un error al guaradar los datos de la unidad";
    public static final String UNIDAD_UPDATE_OK = "Datos de unidad modificados correctamente";
    public static final String VEHICLE_DEL_OK="Datos del vehiculo eliminados correctamente.";
    public static final String VEHICLE_DEL_FAIL="Ocurrio un error al eliminar los datos del vehiculo.";
    
    
    public static final String TMANTTO_OK = "Tipo de mantenimiento agregado";
    public static final String TMANTTO_EXIST = "Ya existe ese tipo de mantenimiento.";
    public static final String TMANTTO_FAIL = "Ocurrió un error al guardar los datos del tipo de mantenimiento.";
    public static final String TMANTTO_UDATE_OK = "Datos del tipo de mantenimiento modificados correctamente";
    public static final String TMANTTO_DEL_OK="Tipo de mantenimiento eliminado correctamente.";
    public static final String TMANTTO_DEL_FAIL="Ocurrio un error al eliminar los datos del tipo de mantenimiento.";  
    
    
    
    
    public synchronized static void enviaJsonServerSide(HttpServletResponse response, JSONObject JSON) {

        PrintWriter out = null;
        try {
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            response.setContentType("text/x-json; charset=ISO-8859-1");
            out = response.getWriter();
            System.out.println(JSON);
            out.print(JSON);

        } catch (IOException IO) {
            System.out.println(IO);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }

        }
    }

}
