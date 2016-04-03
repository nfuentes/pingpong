package com.watea.pingpong.domain;

import com.watea.pingpong.stats.StatsPartido;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity 
public class Partido {
        
        @Id
        @GeneratedValue
        private Long id;   
        
        @ManyToOne (cascade = CascadeType.ALL)
        Jugador jugador1;
        
        @ManyToOne (cascade = CascadeType.ALL)
        Jugador jugador2;
        
        @Column
	Integer puntosJ1;
        
        @Column
	Integer puntosJ2;
        
	public void registrarDatos(Jugador jugador1, Jugador jugador2, Integer puntosJ1, Integer puntosJ2) {
                StatsPartido.getInstance().update();
                this.jugador1=jugador1;
		this.jugador2=jugador2;
                this.puntosJ1=puntosJ1;
                this.puntosJ2=puntosJ2;
		this.jugador1.registrarPuntos(puntosJ1, puntosJ2);
		this.jugador2.registrarPuntos(puntosJ2, puntosJ1);
	}
        
        @ManyToMany
        public Jugador getJugador1() {
            return jugador1;
        }
        
        @ManyToMany
        public Jugador getJugador2() {
            return jugador2;
        }

        public Integer getPuntosJ1() {
            return puntosJ1;
        }

        public Integer getPuntosJ2() {
            return puntosJ2;
        }
}
