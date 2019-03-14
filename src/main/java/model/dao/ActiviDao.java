/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import model.Manager.EMF;
import model.vo.Actividad;
import model.vo.Usuario;

/**
 *
 * @author esteban_lopez
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
    
    /**
     * Verifica la persistencia del objeto p en la base.
     * @param p
     * @return Devuelve 0 si no, devuelve 1 si sí persiste
     */
    public int findEntity(Actividad p){
        int resp;
        
        try{
            EntityManager entityManager = EMF.get().createEntityManager();
        entityManager.getTransaction().begin();
        Actividad actividad = entityManager.find(Actividad.class, p);
        System.out.println("actividad nombe :: " + actividad.getNombre());
        System.out.println("actividad descripcion :: " + actividad.getDescripcion());
        entityManager.getTransaction().commit();
        entityManager.close();   
        resp = 1;
        return resp;
        }catch(Exception e){
            e.printStackTrace();
            resp = 0;
            return resp;
        }
      
    }
    
    /**
     * Es un segundo método para verificar la existencia del objeto p 
     * @param p
     * @return Si el método find es diferente de null devuelve 1, de lo contrario 
     * devuelve 0
     */
    public int findEntity2(Actividad p){
        int resp = 0;
        Actividad actividad;
        actividad = em.find(Actividad.class, p);
        if (actividad != null) {
            resp = 1;
        }
        return resp;
    }
    
    /**
     * Tercer método de verificación pero con booleanos
     * @param p
     * @return true si lo contiene, falso si no lo contiene
     */
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
