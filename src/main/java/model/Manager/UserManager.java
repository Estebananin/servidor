/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Manager;

import model.dao.UserDao;
import model.vo.Usuario;
import utils.Utils;

/**
 *
 * @author esteban_lopez
 */
public class UserManager {
   // Usuario u = new Usuario();
    
    /**
     * Método para insertar objeto de usuario que recibe los parametros de correo y contraseña
     * @param correo
     * @param contrasena
     * @return Devuelve un JSON armado con los parametros del objeto ingresado
     */
    public String insertUser(Usuario u){        
        //u.setCorreo(correo);
        //u.setContrasena(contrasena);
        UserDao ud = new UserDao();
        ud.insertObject(u);
        return Utils.toJson(u); 
    }
        
    
    /**
     * Método para verificar existencia de objeto (VERSION 1 XDXD)
     * @param correo
     * @param contrasena
     * @return Devuelve un json con un valor de 1 si existe y 0 si no existe
     */
    public String VerifyUser(Usuario u){
        String answ;
       // u.setCorreo(correo);
       // u.setContrasena(contrasena);
        UserDao ud = new UserDao();
        if (ud.findEntity(u)== 1 ){
            answ = "1";
        }else{
            answ = "0";
        }

        return Utils.toJson(answ);
        
        
    }
}
