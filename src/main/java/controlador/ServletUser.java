/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Manager.UserManager;
import model.vo.Usuario;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Utils;


/**
 *
 * @author esteban_lopez
 * Servlet del usuario PRUEBA PARA METODOS
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
        
        Usuario usuario =  new Usuario();        
        System.out.println("Registrar.doPost()");
        String s = utils.Utils.readParams(request);
        System.out.println("conexion correcta");
        
       
        //
        
        System.out.println("aaaaa");
        Gson gson = new Gson(); 
        System.out.println("bbbbbb");
        Utils util = new Utils();
        System.out.println("holi");
        
        //ACÁ SE ROMPE
        
        Utils.fromJson(s, Usuario.class);
        System.out.println("pasó");
        
        
    //ERRORR
        
    //usuario = gson.fromJson(s, Usuario.class);
        
       // System.out.println(usuario.getCorreo().toString()+" ++++");
        //
         JSONObject json = new JSONObject();
        try {
            json.put("login correcto", "muy bien");
            PrintWriter pw = response.getWriter();
            pw.write(json.toString());
            pw.print(json.toString());
        } catch (JSONException ex) {
            Logger.getLogger(ServletUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
