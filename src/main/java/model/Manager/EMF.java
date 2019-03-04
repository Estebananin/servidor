/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
	
	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("Tiempo");
	
	private EMF() {}
	
	public static EntityManagerFactory get() {
		return emfInstance;
	}

}