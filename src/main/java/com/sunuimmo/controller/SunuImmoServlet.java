/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.controller;

import com.sunuimmo.model.Bien;
import com.sunuimmo.model.Client;
import com.sunuimmo.service.BailleurFacadeLocal;
import com.sunuimmo.service.BienFacadeLocal;
import com.sunuimmo.service.ClientFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author HP
 */
@WebServlet(name = "SunuImmoServlet", urlPatterns = {"/SunuImmo"})
public class SunuImmoServlet extends HttpServlet {
    @EJB
    private BienFacadeLocal propertyEJB;
    @EJB
    private ClientFacadeLocal clientEJB;
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SunuImmoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SunuImmoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param <error>
     * @param request servlet request
     * @param response servlet response
     * @return 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getParameter("action")!=null?request.getParameter("action"):"";
        switch(action){
            
            case "liste" :
                
                List<Bien> properties = propertyEJB.findAll();
                response.setContentType("application/json");
                JSONArray propertyArray = new JSONArray(properties);
                System.out.println(" type object:"+properties);
                String jsonProperties = propertyArray.toString();
                System.out.println(" json:"+jsonProperties);
                response.getWriter().println(jsonProperties);
            break;
            
           
                
            case "delete" :
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println(""+id);
                Bien p = new Bien();
                p.setIdB(id);
                propertyEJB.remove(propertyEJB.find(id));
            break;
            
        }
        
        
        
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
        
        String action = request.getParameter("action")!=null?request.getParameter("action"):"";
        switch(action){
            
            case "logon" :
                String login = request.getParameter("login");
                int pass = Integer.parseInt(request.getParameter("password"));
                Client c = clientEJB.getUser(login,pass);
                    response.setContentType("application/json");
                    JSONObject user = new JSONObject(c);
                    String jsonUser = user.toString();
                    System.out.println("json:"+jsonUser);
                    response.getWriter().println(jsonUser);
                break;                
            case "insert" :
                
                String name = request.getParameter("nom");
                int price =  Integer.parseInt(request.getParameter("prix"));
                int etat = 0;
                Bien p = new Bien();
                p.setNomB(name);
                p.setPrix(price);
                p.setEtat(etat);
                propertyEJB.create(p);
                
                response.setContentType("application/json");
                JSONObject property = new JSONObject(p);
                String jsonProperty = property.toString();
                System.out.println(" json:"+jsonProperty);
                response.getWriter().println(jsonProperty);
            break;
            
            case "delete" :
                System.out.println(""+action);
                break;
    }
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
