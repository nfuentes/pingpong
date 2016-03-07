package com.watea.pingpong;

import com.watea.pingpong.domain.Jugador;
import com.watea.pingpong.domain.Partido;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {
    public static void main(String[] args){
        //EntityManagerFactory manager;
        //manager=Persistence.createEntityManagerFactory("com.watea_pingpong_jar_1.0-SNAPSHOTPU");
        SessionFactory session=new Configuration().configure().buildSessionFactory();
        session.openSession();
         Jugador jugador1 = new Jugador().nombre("Nicolas").apellido("Fuentes");
         Jugador jugador2 = new Jugador().nombre("Emiliano").apellido("Di Pierro");
         Partido partido=new Partido();
         partido.registrarDatos(jugador1, jugador2, 21, 19);
         //instance.getTransaction().begin();
         
         session.getCurrentSession().getTransaction().begin();
         session.getCurrentSession().save(jugador1);
         session.getCurrentSession().save(jugador2);
         session.getCurrentSession().getTransaction().commit();
         
         //instance.getTransaction().commit();
         System.out.println("El partido salio "+partido.getPuntosJ1()+" a "+partido.getPuntosJ2());
         System.out.println(partido.getJugador1().getNombre()+" hizo "+partido.getPuntosJ1()+" puntos");
         System.out.println(partido.getJugador2().getNombre()+" hizo "+partido.getPuntosJ2()+" puntos");
         System.out.println(partido.getJugador1().getNombre()+" jugo "+jugador1.getPartidosJugados()+" partidos");
         System.out.println(partido.getJugador2().getNombre()+" jugo "+jugador2.getPartidosJugados()+" partidos");
         Partido partido2=new Partido();
         partido2.registrarDatos(jugador1, jugador2, 21, 10);
         session.getCurrentSession().getTransaction().begin();
         session.getCurrentSession().save(jugador1);
         session.getCurrentSession().save(jugador2);
         session.getCurrentSession().getTransaction().commit();
         System.out.println("El partido salio "+partido.getPuntosJ1()+" a "+partido.getPuntosJ2());
         System.out.println(partido2.getJugador1().getNombre()+" hizo "+partido2.getPuntosJ1()+" puntos");
         System.out.println(partido2.getJugador2().getNombre()+" hizo "+partido2.getPuntosJ2()+" puntos");
         System.out.println(partido2.getJugador1().getNombre()+" jugo "+jugador1.getPartidosJugados()+" partidos");
         System.out.println(partido2.getJugador2().getNombre()+" jugo "+jugador2.getPartidosJugados()+" partidos");
         session.close();
    }
}
