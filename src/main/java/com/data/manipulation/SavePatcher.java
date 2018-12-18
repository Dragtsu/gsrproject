/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.manipulation;

import com.data.models.TbTrabajador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import static com.data.configurations.StaticData.*;
import com.data.models.TbUnidad;

/**
 *
 * @author dragneel
 */
@WebServlet(name = "SavePatcher", urlPatterns = {"/api/save"})
public class SavePatcher extends HttpServlet {

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
        boolean save = request.getParameter("action").equals("save");

        if (paramValue.equals(TRABAJADOR)) {

            enviaJsonServerSide(response, toSaveWorker(request,save));
        } else if (paramValue.equals(UNIDAD)) {

            enviaJsonServerSide(response, toSaveVehicle(request,save));
        }
    }

    private JSONObject toSaveWorker(HttpServletRequest request, boolean save) {

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

    private JSONObject toSaveVehicle(HttpServletRequest request, boolean save) {

        TbUnidad tb = new TbUnidad();

        tb.setId_vehiculo(request.getParameter("id_vehiculo"));
        tb.setsDescripcion(request.getParameter("sDescripcion"));
        tb.setfMantenimiento(request.getParameter("fMantenimiento"));
        tb.setfVerificacion(request.getParameter("fVerificacion"));
        tb.setfSeguro(request.getParameter("fSeguro"));
        tb.setnCostoServicio(Double.parseDouble(request.getParameter("nCostoServicio")));

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
