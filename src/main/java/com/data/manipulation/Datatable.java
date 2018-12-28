/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.manipulation;

import com.data.configurations.StaticData;
import static com.data.configurations.StaticData.TIPO_SERVICIO;
import static com.data.configurations.StaticData.TRABAJADOR;
import static com.data.configurations.StaticData.UNIDAD;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        
        System.out.println("********************** Tabla a consultar para el catalogo: "+tablaConsultar);

        switch (tablaConsultar) {
            case TRABAJADOR:
                tablaConsultar = "TbTrabajador";
                break;
            case UNIDAD:
                //tablaConsultar = "TbUnidad";                
                break;
            case TIPO_SERVICIO:
                tablaConsultar = "TbServicios";
                break;
            default:
                break;
        }

        StaticData.enviaTextAjax(response, getHtml(tablaConsultar));

        System.out.println("****************************Get html*****************************");

    }

    public String getHtml(String jsp) {

        File input = new File( getServletContext().getRealPath("/") + jsp + "Content.jsp");
        Document doc = null;

        try {

            doc = Jsoup.parse(input, "UTF-8");

        } catch (IOException ex) {
            Logger.getLogger(Datatable.class.getName()).log(Level.SEVERE, null, ex);
        }

        Element link = doc.select("table.dataTablex").first();

        return " <table class=\"display dataTablex\">" + link.html() + "</table>";

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
