/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Manager;

import afu.org.checkerframework.checker.units.qual.Time;
import java.util.Date;
import model.dao.ActiviDao;
import model.dao.UserDao;
import model.vo.Actividad;
import model.vo.Usuario;
import utils.Utils;

/**
 *
 * @author pc
 */
public class ActivityManager {
    Actividad u = new Actividad();

    
    
    public String insertActivity(String nombre, Time hora, 
              Date fecha, String descripcion, String correo){
        
        u.setNombre(nombre);
        u.setHora((Date) hora);
        u.setFecha(fecha);
        u.setDescripcion(descripcion);
        
        ActiviDao ud = new ActiviDao();
        ud.insertActivity(u);
        return Utils.toJson(u);
      
    }
    
    
    
    
}
