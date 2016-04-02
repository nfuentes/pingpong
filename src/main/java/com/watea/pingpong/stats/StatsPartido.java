/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watea.pingpong.stats;


import com.watea.pingpong.db.DbManager;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author nicolas
 */
@Entity
public class StatsPartido {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private Integer TotalPartidos=0;

    private static StatsPartido instance=null;
    
    protected StatsPartido(){
        
    }
    
    public static StatsPartido getInstance(){
        if (instance==null)
            instance=new StatsPartido();
        return instance;
    }
    
    public void update(){
        this.setCount(this.getCount()+1);
    }
    
    public Integer getCount() {
        return this.TotalPartidos;
    }

    private void setCount(Integer Count) {
        this.TotalPartidos = Count;
    }
    
}
