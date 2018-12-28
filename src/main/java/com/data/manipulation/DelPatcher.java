/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.manipulation;

import static com.data.configurations.StaticData.*;
import com.data.models.TbServicios;
import com.data.models.TbTrabajador;
import com.data.models.TbUnidad;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author dragneel
 */
@WebServlet(name = "DelPatcher", urlPatterns = {"/api/del"})
public class DelPatcher extends HttpServlet {

    

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

        String paramTable= request.getParameter("table");

        System.out.println("Orden a eliminaar .. " + paramTable);

        if (paramTable.equals(TRABAJADOR)) {

            enviaJsonServerSide(response, toDelWorker(request));
        }
        else if (paramTable.equals(UNIDAD)) {

            enviaJsonServerSide(response, toDelVehicle(request));
        }
        else if (paramTable.equals(TIPO_SERVICIO)) {

            enviaJsonServerSide(response, toDelServicio(request));
        }
    }

    private JSONObject toDelWorker(HttpServletRequest request) {

        TbTrabajador tb = new TbTrabajador();        
        tb.setNum_Celular(request.getParameter("value"));     

        JSONObject js = new JSONObject();

        int status = new DataAcces().delete(tb,"TbTrabajador");        

        if (status == OPERACION_EXITOSA) 
            js.put("mensaje", WORKER_DEL_OK);
        else 
            js.put("mensaje", WORKER_DEL_FAIL);

        return js;
    }
    
    private JSONObject toDelServicio(HttpServletRequest request) {
System.out.println("To del Servicios"+request.getParameter("value"));
        TbServicios tb = new TbServicios();        
        tb.setId_servicio(request.getParameter("value"));     

        JSONObject js = new JSONObject();

        int status = new DataAcces().delete(tb,"TbServicios");        

        if (status == OPERACION_EXITOSA) 
            js.put("mensaje", TSERVICIO_DEL_OK);
        else 
            js.put("mensaje", TSERVICIO_DEL_FAIL);        

        return js;
    }
    
    private JSONObject toDelVehicle(HttpServletRequest request) {

        TbUnidad tb = new TbUnidad();        
        tb.setId_unidad(request.getParameter("value"));     

        JSONObject js = new JSONObject();

        int status = new DataAcces().delete(tb,"TbUnidad");        

        if (status == OPERACION_EXITOSA) 
            js.put("mensaje", VEHICLE_DEL_OK);
        else 
            js.put("mensaje", VEHICLE_DEL_FAIL);        

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
