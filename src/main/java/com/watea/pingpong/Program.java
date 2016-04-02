/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.watea.pingpong;

import com.watea.pingpong.db.SessionManager;
import com.watea.pingpong.domain.Jugador;
import com.watea.pingpong.domain.Partido;

/**
 *
 * @author nicolas
 */
public class Program {
    public static void main(String[] args){

         SessionManager.getInstance().startSession();
         Jugador jugador1 = new Jugador().nombre("Nicolas").apellido("Fuentes");
         Jugador jugador2 = new Jugador().nombre("Emiliano").apellido("Di Pierro");
         Partido partido=new Partido();
         partido.registrarDatos(jugador1, jugador2, 21, 19);
         SessionManager.getInstance().saveOrUpdate(jugador1);
         SessionManager.getInstance().saveOrUpdate(jugador2);
         SessionManager.getInstance().saveOrUpdate(partido);

         System.out.println("El partido salio "+partido.getPuntosJ1()+" a "+partido.getPuntosJ2());
         System.out.println(partido.getJugador1().getNombre()+" hizo "+partido.getPuntosJ1()+" puntos");
         System.out.println(partido.getJugador2().getNombre()+" hizo "+partido.getPuntosJ2()+" puntos");
         System.out.println(partido.getJugador1().getNombre()+" jugo "+jugador1.getPartidosJugados()+" partidos");
         System.out.println(partido.getJugador2().getNombre()+" jugo "+jugador2.getPartidosJugados()+" partidos");
         Partido partido2=new Partido();
         partido2.registrarDatos(jugador1, jugador2, 21, 10);
         SessionManager.getInstance().saveOrUpdate(jugador1);
         SessionManager.getInstance().saveOrUpdate(jugador2);
         SessionManager.getInstance().saveOrUpdate(partido2);
         System.out.println("El partido salio "+partido.getPuntosJ1()+" a "+partido.getPuntosJ2());
         System.out.println(partido2.getJugador1().getNombre()+" hizo "+partido2.getPuntosJ1()+" puntos");
         System.out.println(partido2.getJugador2().getNombre()+" hizo "+partido2.getPuntosJ2()+" puntos");
         System.out.println(partido2.getJugador1().getNombre()+" jugo "+jugador1.getPartidosJugados()+" partidos");
         System.out.println(partido2.getJugador2().getNombre()+" jugo "+jugador2.getPartidosJugados()+" partidos");
         SessionManager.getInstance().closeSession();
    }
}
