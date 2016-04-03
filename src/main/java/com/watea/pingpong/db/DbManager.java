/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watea.pingpong.db;

import com.watea.pingpong.domain.Jugador;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 *
 * @author nicolas
 */


public class DbManager {
    
    SessionFactory session;

    
    private static DbManager instance=null;
    
    protected DbManager(){
        
    }
    
    public static DbManager getInstance(){
        if (instance==null)
            instance=new DbManager();
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
    
    public SessionFactory getSession() {
        return session;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
