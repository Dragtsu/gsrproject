/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.manipulation;

import com.data.manipulation.DataAcces;
import com.data.models.TbTrabajador;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UpdatePatcher", urlPatterns = {"/api/update"})
public class UpdatePatcher extends HttpServlet {

    public final static int OPERACION_EXITOSA = 0;
    public final static int REGISTRO_EXISTE = 1;
    public final static int ERROR_GENERAL = 2;

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

        System.out.println("Orden a guardar .. " + paramValue);

        if (paramValue.equals("worker")) {

            enviaJsonServerSide(response, toUpdateWorker(request));
        }
    }

    private JSONObject toUpdateWorker(HttpServletRequest request) {

        TbTrabajador tb = new TbTrabajador();

        tb.setNombre(request.getParameter("Nombre"));
        tb.setNum_Celular(request.getParameter("Num_Celular"));
        tb.setApellido_Materno(request.getParameter("Apellido_Materno"));
        tb.setApellido_Paterno(request.getParameter("Apellido_Paterno"));
        tb.setVigencia_Licencia(request.getParameter("Vigencia_Licencia"));

        JSONObject js = new JSONObject();

        int status = new DataAcces().update(tb,"TbTrabajador");        

        if (status == OPERACION_EXITOSA) {
            js.put("mensaje", "Datos del trabajador modificado correctamente.");
        } else if (status == REGISTRO_EXISTE) {
            js.put("mensaje", "Ya existe un trabajador con ese número de celular.");
        } else if (status == ERROR_GENERAL) {
            js.put("mensaje", "Ocurrió un error al modificar los datos del trabajador.");
        }

        return js;
    }

    private void enviaJsonServerSide(HttpServletResponse response, JSONObject JSON) {

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
