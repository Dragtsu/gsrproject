/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.manipulation;

import com.data.models.TbTrabajador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import static com.data.configurations.StaticData.*;
import com.data.models.TbServicios;
import com.data.models.TbUnidad;

/**
 *
 * @author dragneel
 */
@WebServlet(name = "ListPatcher", urlPatterns = {"/api/data"})
public class ListPatcher extends HttpServlet {

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

        String tablaConsultar = request.getParameter("table");

        System.out.println("Buscando datos de: .. " + tablaConsultar);

        /* System.out.println("iDisplayStart.. " + request.getParameter("iDisplayStart"));
        System.out.println("iTotalDisplayRecords.. " + request.getParameter("iTotalDisplayRecords"));
        System.out.println("iTotalRecords.. " + request.getParameter("iTotalRecords"));
        System.out.println("iDisplayLength.. " + request.getParameter("iDisplayLength"));*/
        switch (tablaConsultar) {
            case TRABAJADOR:
                tablaConsultar="TbTrabajador";
                break;
            case UNIDAD:
                tablaConsultar="TbUnidad";
                break;
            case TIPO_SERVICIO:
                System.out.println("********** Consultando table tipo TIPO_SERVICIO");
                tablaConsultar="TbServicios";
                break;
            default:
                break;
        }

            enviaJsonServerSide(response, getTableJson(
                    Integer.parseInt(request.getParameter("iDisplayStart")),
                    Integer.parseInt(request.getParameter("iDisplayLength")),
                    request.getParameter("sSearch"),
                    tablaConsultar
            ));
        
    }
    
    private String [] cast(String table, Object obj){
        String [] Return=null;
        
        if(table.equals("TbTrabajador"))
            Return=((TbTrabajador)obj).toArray();
        else if(table.equals("TbUnidad"))
            Return=((TbUnidad)obj).toArray();
        else if(table.equals("TbServicios"))
            Return=((TbServicios)obj).toArray(); 
        
        return Return;
    }

    private JSONObject getTableJson(int iDisplayStart, int iDisplayLength, String like , String tablaConsultar) {
               

        ArrayList<Object> tb = new DataAcces().read(like,tablaConsultar);
      
        JSONArray array = new JSONArray();
        int limit = (iDisplayStart+iDisplayLength>tb.size())? tb.size():iDisplayStart+iDisplayLength;
        
        for (int i = iDisplayStart; i < limit; i++) {
            array.put( Arrays.asList( cast(tablaConsultar, tb.get(i)) ));
        }

        return new JSONObject()
                .put("aaData", array)
                .put("iDisplayStart", 0)
                .put("iTotalDisplayRecords", tb.size())
                .put("iTotalRecords", tb.size())
                .put("iDisplayLength", tb.size());

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
