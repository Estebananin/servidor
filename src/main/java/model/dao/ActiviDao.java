/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import model.Manager.EMF;
import model.vo.Actividad;

/**
 *
 * @author pc
 */
public class ActiviDao {
    
    public EntityManager em = null;
    
    public boolean insertActivity(Actividad p){
        
        try{
            em = EMF.get().createEntityManager();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            em.refresh(p);
            em.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) 
              em.close();  
            
            
        }
    }
    
    public boolean exists(Actividad p){
        boolean a = false;
        try{
            em = EMF.get().createEntityManager();
            em.getTransaction().begin();
           
            
            if (em.contains(p) == true) {
                a = true;
              
            }else{
                a = false;
            }
            em.persist(p);
            em.getTransaction().commit();
            em.refresh(p);
            em.close();
            
        }catch(Exception e){
             e.printStackTrace();
            a = false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return a;
    }
    
}
