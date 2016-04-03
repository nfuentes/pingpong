/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watea.pingpong.homes;

import com.watea.pingpong.db.DbManager;
import com.watea.pingpong.domain.Jugador;

/**
 *
 * @author nicolas
 */
public class JugadorHome {
    
    static JugadorHome instance;
    
    protected JugadorHome(){
        
    }
    
    public static JugadorHome getInstance(){
        if (instance==null)
            instance=new JugadorHome();
        return instance;
    }
    
    public void saveUpdatePlayer(Jugador jugador){
        DbManager.getInstance().saveOrUpdate(jugador);
    }
    
}
