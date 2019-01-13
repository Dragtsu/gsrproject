/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.manipulation;

import com.data.configurations.StaticData;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author dragneel
 */
@WebServlet(name = "Datatable", urlPatterns = {"/GetCatalog"})
public class Datatable extends HttpServlet {

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

        response.setContentType("text/html;charset=UTF-8");
        String tablaConsultar = request.getParameter("table");

        System.out.println("********************** Tabla a consultar para el catalogo: " + tablaConsultar);

        JSONObject js = new JSONObject();
        
        js.put("table", getHtml(tablaConsultar));
        js.put("input", "<input type=\"hidden\" id=\"" + tablaConsultar + "\" class=\"catalogModal\">");
        js.put("script","<script src=\"js/catalogModal.js\" type=\"text/javascript\"></script>");
        StaticData.enviaJsonServerSide(response, js);

    }
    
    /*
    Se extrae la table del crud de la tabla, se da por hecho que el id de la entidad
    es la primer columna de la tabla.   
    */

    public String getHtml(String jsp) {

        File input = new File(getServletContext().getRealPath("/") + jsp + "Content.jsp");
        Document doc = null;

        try {

            doc = Jsoup.parse(input, "UTF-8");

        } catch (IOException ex) {
            Logger.getLogger(Datatable.class.getName()).log(Level.SEVERE, null, ex);
        }

        Element link = doc.select("table.dataTablex").first();

        return " <table id=\"tableCatalog\" class=\"display\">" + link.html() + "</table>";

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
