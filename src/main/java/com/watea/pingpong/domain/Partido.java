package com.watea.pingpong.domain;

public class Partido {
	Jugador jugador1, jugador2;
	Integer puntosJ1;
	Integer puntosJ2;
        
	public void registrarDatos(Jugador jugador1, Jugador jugador2, Integer puntosJ1, Integer puntosJ2) {
                this.jugador1=jugador1;
		this.jugador2=jugador2;
                this.puntosJ1=puntosJ1;
                this.puntosJ2=puntosJ2;
		this.jugador1.registrarPuntos(puntosJ1, puntosJ2);
		this.jugador2.registrarPuntos(puntosJ2, puntosJ1);
	}

        public Jugador getJugador1() {
            return jugador1;
        }

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
