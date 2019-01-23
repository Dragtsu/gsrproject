package com.data.manipulation;

import com.data.models.TbTrabajador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import static com.data.configurations.StaticData.*;
import com.data.models.TbProgramacionServicios;
import com.data.models.TbServicios;
import com.data.models.TbUnidad;

/**
 *
 * @author dragneel
 */
@WebServlet(name = "SavePatcher", urlPatterns = {"/api/save"})
public class SaveUpdateDistPatcher extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paramValue = request.getParameter("table");
        System.out.println("***************** ACTION ************* >>>  "+request.getParameter("action"));
        boolean save = request.getParameter("action").equals("save");

        if (paramValue.equals(TRABAJADOR)) {

            enviaJsonServerSide(response, guardaTrabajador(request,save));
        } else if (paramValue.equals(UNIDAD)) {

            enviaJsonServerSide(response, guardaUnidad(request,save));
        }
         else if (paramValue.equals(TIPO_SERVICIO)) {

            enviaJsonServerSide(response, guardaServicio(request,save));
        }
         else if (paramValue.equals(PROGRAMACION_SERVICIO)) {

            enviaJsonServerSide(response, guardaServicioProgramado(request,save));
        }
    }

    private JSONObject guardaTrabajador(HttpServletRequest request, boolean save) {

        TbTrabajador tb = new TbTrabajador();

        tb.setNombre(request.getParameter("Nombre"));
        tb.setNum_Celular(request.getParameter("Num_Celular"));
        tb.setApellido_Materno(request.getParameter("Apellido_Materno"));
        tb.setApellido_Paterno(request.getParameter("Apellido_Paterno"));
        tb.setVigencia_Licencia(request.getParameter("Vigencia_Licencia"));

        JSONObject js = new JSONObject();

        int status;        

        if (save) {
            status = new DataAcces().insert(tb, "TbTrabajador");
        } else {
            status = new DataAcces().update(tb, "TbTrabajador");
        }

        if (status == OPERACION_EXITOSA && save) {
            js.put("mensaje", WORKER_OK);
        } else if (status == OPERACION_EXITOSA) {
            js.put("mensaje", WORKER_UDATE_OK);
        } else if (status == REGISTRO_EXISTE) {
            js.put("mensaje", WORK_EXIST);
        } else if (status == ERROR_GENERAL) {
            js.put("mensaje", WORKER_FAIL);
        }

        return js;
    }

    private JSONObject guardaUnidad(HttpServletRequest request, boolean save) {

        TbUnidad tb = new TbUnidad();

        tb.setId_unidad(request.getParameter("id_unidad"));
        tb.setsDescripcion(request.getParameter("sDescripcion"));
        tb.setsNombre(request.getParameter("sNombre"));
        tb.setUnidad_disponible(Integer.parseInt(request.getParameter("unidad_disponible")));
       

        JSONObject js = new JSONObject();

        int status;

        if (request.getParameter("action").equals("save")) {
            status = new DataAcces().insert(tb, "TbUnidad");
        } else {
            status = new DataAcces().update(tb, "TbUnidad");
        }

        if (status == OPERACION_EXITOSA && save) {
            js.put("mensaje", UNIDAD_OK);
        } else if (status == OPERACION_EXITOSA) {
            js.put("mensaje", UNIDAD_UPDATE_OK);
        } else if (status == REGISTRO_EXISTE) {
            js.put("mensaje", UNIDAD_EXIST);
        } else if (status == ERROR_GENERAL) {
            js.put("mensaje", UNIDAD_FAIL);
        }

        return js;
    }
    
    private JSONObject guardaServicio(HttpServletRequest request, boolean save) {

        TbServicios tb = new TbServicios();

        tb.setNombre_servicio(request.getParameter("nombre_servicio"));
        tb.setnCostoServicio(Double.parseDouble(request.getParameter("nCostoServicio")));
        tb.setsDescripcion(request.getParameter("sDescripcion"));

        JSONObject js = new JSONObject();

        int status;

        if (request.getParameter("action").equals("save")) {
            status = new DataAcces().insert(tb, "TbServicios");
        } else {
            tb.setId_servicio(request.getParameter("id_servicio"));
            status = new DataAcces().update(tb, "TbServicios");
        }

        if (status == OPERACION_EXITOSA && save) {
            js.put("mensaje", TSERVICIO_OK);
        } else if (status == OPERACION_EXITOSA) {
            js.put("mensaje", TSERVICIO_UDATE_OK);
        } else if (status == REGISTRO_EXISTE) {
            js.put("mensaje", TSERVICIO_EXIST);
        } else if (status == ERROR_GENERAL) {
            js.put("mensaje", TSERVICIO_FAIL);
        }

        return js;
    }
    
    private JSONObject guardaServicioProgramado(HttpServletRequest request, boolean save) {

        TbProgramacionServicios tbps = new TbProgramacionServicios();

       // tbps.setId_programacion_servicio(Integer.parseInt(request.getParameter("id_programacion_servicio")));
        tbps.setId_servicio(request.getParameter("id_servicio"));
        tbps.setId_unidad(request.getParameter("id_unidad"));
        tbps.setbRealizado(Integer.parseInt(request.getParameter("mantoRealizado")));
        tbps.setdFecha_programada(request.getParameter("fProgramadaServicio"));
        tbps.setnCostoServicio(Double.parseDouble(request.getParameter("nCostoServicioProgramado")));
        tbps.setsDescripcion_programacion(request.getParameter("sDescripcion"));
        

        JSONObject js = new JSONObject();

        int status;

        if (request.getParameter("action").equals("save")) {
            status = new DataAcces().insert(tbps, "TbProgramacionServicios");
        } else {
           tbps.setId_programacion_servicio(request.getParameter("id_programacion_servicio"));
            status = new DataAcces().update(tbps, "TbProgramacionServicios");
        }

        if (status == OPERACION_EXITOSA && save) {
            js.put("mensaje", TSERVICIO_PROGRAMADO_OK);
        } else if (status == OPERACION_EXITOSA) {
            js.put("mensaje", TSERVICIO_PROGRAMADO_UDATE_OK);
        } else if (status == REGISTRO_EXISTE) {
            js.put("mensaje", TSERVICIO_PROGRAMADO_EXIST);
        } else if (status == ERROR_GENERAL) {
            js.put("mensaje", TSERVICIO_PROGRAMADO_FAIL);
        }

        return js;
    }


  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
