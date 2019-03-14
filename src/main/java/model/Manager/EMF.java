/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author esteban_lopez
 */

public final class EMF {
	
	private static EntityManagerFactory emfInstance;
        private static final String Tiempo = "Tiempo";
	
	public static EntityManagerFactory get() {
            if (emfInstance == null) {
                emfInstance = Persistence.createEntityManagerFactory(Tiempo);
            }
            
            return emfInstance;
	}

        public static void shutdown(){
            if (emfInstance != null) {
                emfInstance.close();
            }
        }
        
        
}