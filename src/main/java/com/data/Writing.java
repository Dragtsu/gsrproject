/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.data.configurations.MyBatisConnectionFactory;
import com.data.models.TbTrabajador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author dragneel
 */
@WebServlet(name = "Writing", urlPatterns = {"/Writing"})
public class Writing extends HttpServlet {

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
 SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();         
          
 try {
            List<TbTrabajador> list = session.selectList("TbTrabajador.getAll");
            for (TbTrabajador tbTrabajador : list) {
            System.out.println(tbTrabajador.getNum_Celular() + "t" + tbTrabajador.getNombre());
        }
            
        } finally {
            session.close();
        }
    }
          
          
          /*
           Connection conn = null;
try {
 
    Context ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/sqlite");
    conn = ds.getConnection();
    Statement statement = conn.createStatement();

ResultSet rs = statement.executeQuery("select * from pruebas");
while (rs.next()) 
System.out.println("id = " + rs.getInt(1));



} catch (Exception e) {
    System.out.println(e.getMessage());
} finally {
    try {
        if (conn != null) conn.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
}*/
       
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

   

