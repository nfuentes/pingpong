/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watea.pingpong.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author nicolas
 */


public class SessionManager {
    
    SessionFactory session;
    private static SessionManager instance=null;
    
    protected SessionManager(){
        
    }
    
    public static SessionManager getInstance(){
        if (instance==null)
            instance=new SessionManager();
        return instance;
    }
    
    public void startSession(){
        session=new Configuration().configure().buildSessionFactory();
        session.openSession();
    }
    
    public void saveOrUpdate(Object o){
        session.getCurrentSession().getTransaction().begin();
        session.getCurrentSession().saveOrUpdate(o);
        session.getCurrentSession().getTransaction().commit();
    }
    
    public void closeSession(){
        session.close();
    }
}
