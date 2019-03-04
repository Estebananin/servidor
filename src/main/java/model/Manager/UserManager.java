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
 * @author pc
 */
public class UserManager {
    Usuario u = new Usuario();
    
    public String insertUser(String correo, String contrasena){
        
        u.setCorreo(correo);
        u.setContrasena(contrasena);
        UserDao ud = new UserDao();
        ud.insertObject(u);
        return Utils.toJson(u);
      
    }
        
    
}
