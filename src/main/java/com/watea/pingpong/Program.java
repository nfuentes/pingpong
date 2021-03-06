/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watea.pingpong;

import com.watea.pingpong.db.DbManager;
import com.watea.pingpong.domain.Jugador;
import com.watea.pingpong.domain.Partido;
import com.watea.pingpong.homes.JugadorHome;
import com.watea.pingpong.stats.StatsPartido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;


public class Program {
    public static void main(String[] args){

         DbManager.getInstance().startSession();
         Jugador jugador1 = new Jugador().nombre("Nicolas").apellido("Fuentes");
         Jugador jugador2 = new Jugador().nombre("Emiliano").apellido("Di Pierro");
         Partido partido=new Partido();
         partido.registrarDatos(jugador1, jugador2, 21, 19);
         DbManager.getInstance().saveOrUpdate(StatsPartido.getInstance());
         DbManager.getInstance().saveOrUpdate(partido);    
         JugadorHome.getInstance().saveUpdatePlayer(jugador1);
         JugadorHome.getInstance().saveUpdatePlayer(jugador2);
         //DbManager.getInstance().saveOrUpdate(jugador1);
         //DbManager.getInstance().saveOrUpdate(jugador2);
         
         System.out.println("El partido salio "+partido.getPuntosJ1()+" a "+partido.getPuntosJ2());
         System.out.println(partido.getJugador1().getNombre()+" hizo "+partido.getPuntosJ1()+" puntos");
         System.out.println(partido.getJugador2().getNombre()+" hizo "+partido.getPuntosJ2()+" puntos");
         System.out.println(partido.getJugador1().getNombre()+" jugo "+jugador1.getPartidosJugados()+" partidos");
         System.out.println(partido.getJugador2().getNombre()+" jugo "+jugador2.getPartidosJugados()+" partidos");
         Partido partido2=new Partido();
         partido2.registrarDatos(jugador1, jugador2, 10, 21);
         
         DbManager.getInstance().saveOrUpdate(StatsPartido.getInstance());
         DbManager.getInstance().saveOrUpdate(partido2);
         //DbManager.getInstance().saveOrUpdate(jugador1);
         //DbManager.getInstance().saveOrUpdate(jugador2);
         JugadorHome.getInstance().saveUpdatePlayer(jugador1);
         JugadorHome.getInstance().saveUpdatePlayer(jugador2);

         System.out.println("El partido salio "+partido.getPuntosJ1()+" a "+partido.getPuntosJ2());
         System.out.println(partido2.getJugador1().getNombre()+" hizo "+partido2.getPuntosJ1()+" puntos");
         System.out.println(partido2.getJugador2().getNombre()+" hizo "+partido2.getPuntosJ2()+" puntos");
         System.out.println(partido2.getJugador1().getNombre()+" jugo "+jugador1.getPartidosJugados()+" partidos");
         System.out.println(partido2.getJugador2().getNombre()+" jugo "+jugador2.getPartidosJugados()+" partidos");
         
         Jugador jugador3 = new Jugador().nombre("Nicolas");
         Example jugadorexample=Example.create(jugador3).excludeZeroes();
         DbManager.getInstance().getSession().getCurrentSession().getTransaction().begin();
         List <Jugador> listaj = DbManager.getInstance().getSession().getCurrentSession().createCriteria(Jugador.class).add(jugadorexample).list();      
         System.out.println(listaj.get(0).nombre);
         DbManager.getInstance().closeSession();
    }
}
