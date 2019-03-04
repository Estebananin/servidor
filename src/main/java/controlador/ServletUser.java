/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Manager.UserManager;

/**
 *
 * @author esteban_lopez
 * Servlet del usuario
 */


public class ServletUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
        public ServletUser(){
            super();
           
        }
    
        /**
         * 
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException 
         */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
       
        
    }

 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         PrintWriter out = response.getWriter();
        
        UserManager un = new UserManager();
        String a = "esteban.lopez@correo.usa.edu.co";
        String b = "12345678";
        out.println(un.insertUser(a,b));
        /*ACA DEBO RECIBIR Y LAS PETICIONES 3HP PERO NO SÉ DE DONDE COGER SIQUIERA**/
    }

    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
