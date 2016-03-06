package com.watea.pingpong.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Jugador {
        
        @Id
        @GeneratedValue
        private Long id;
        
        @Column
	public String nombre;
        
        @Column
	public String apellido;
        
        @Column
	public int puntosFavor;
        
        @Column
        public int puntosContra;
        
        @Column
	public int PartidosJugados;
        
        @Column
	public float Promedio;
        
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public Integer getPuntosFavor() {
            return puntosFavor;
        }

        public void setPuntosFavor(Integer puntosFavor) {
            this.puntosFavor = puntosFavor;
        }

        public Integer getPuntosContra() {
            return puntosContra;
        }

        public void setPuntosContra(Integer puntosContra) {
            this.puntosContra = puntosContra;
        }

        public Integer getPartidosJugados() {
            return PartidosJugados;
        }

        public void setPartidosJugados(Integer PartidosJugados) {
            this.PartidosJugados = PartidosJugados;
        }

        public float getPromedio() {
            return Promedio;
        }

        public void setPromedio(float Promedio) {
            this.Promedio = Promedio;
        }

        public Jugador nombre(String nombre){
          this.nombre=nombre;
          return this;
        }
        
        public Jugador apellido(String apellido){
            this.apellido=apellido;
            return this;
        }
        
	public void registrarPuntos(Integer puntosFavor, Integer puntosContra){
		this.setPuntosFavor(this.getPuntosFavor()+puntosFavor);
		this.setPuntosContra(this.getPuntosContra()+puntosContra);
                this.contarPartido();
	}
        
        public void contarPartido(){
            this.setPartidosJugados(this.getPartidosJugados()+1);
        }
	
}
