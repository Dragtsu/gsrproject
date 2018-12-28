/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.configurations;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author dragneel
 */
public class StaticData {
    
    
    public static final String JSPATH = "jsp/";

    public static final String TRABAJADOR = "worker";
    public static final String UNIDAD = "vehicle";
    public static final String TIPO_SERVICIO = "tServicios";

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
    
    
    public static final String TSERVICIO_OK = "Servicio agregado";
    public static final String TSERVICIO_EXIST = "Ya existe ese servicio.";
    public static final String TSERVICIO_FAIL = "Ocurrió un error al guardar los datos del servicio.";
    public static final String TSERVICIO_UDATE_OK = "Datos del tipo del servicio modificados correctamente";
    public static final String TSERVICIO_DEL_OK="Servicio eliminado correctamente.";
    public static final String TSERVICIO_DEL_FAIL="Ocurrio un error al eliminar los datos del servicio.";  
    
    
    
    
    public synchronized static void enviaJsonServerSide(HttpServletResponse response, JSONObject JSON) {

        PrintWriter out = null;
        try {
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            response.setContentType("text/x-json; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
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
    
     public synchronized static void enviaTextAjax(HttpServletResponse response, String str) {

        PrintWriter out = null;
        try {            
            response.setHeader("Cache-Control", "no-store");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            System.out.println(str);
            out.print(str);

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
