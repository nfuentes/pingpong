package com.watea.pingpong.domain;

import com.watea.pingpong.db.DbManager;
import com.watea.pingpong.homes.JugadorHome;
import com.watea.pingpong.stats.StatsPartido;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Jugador implements Serializable {
        
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
	public int partidosJugados;
        
        @Column
        public int partidosGanados;
        
        @Column (precision=10, scale=2)
	public double Promedio;
        
        
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
            return partidosJugados;
        }

        public void setPartidosJugados(Integer PartidosJugados) {
            this.partidosJugados = PartidosJugados;
        }
        
        public Integer getPartidosGanados() {
            return partidosGanados;
        }

        public void setPartidosGanados(Integer partidosGanados) {
            this.partidosGanados = partidosGanados;
        }

        public double getPromedio() {
            return Promedio;
        }

        public void setPromedio(double Promedio) {
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
                if (puntosFavor>puntosContra){
                    this.partidosGanados+=1;
                }
                this.updatePromedio();
	}
        
        public void contarPartido(){
            this.setPartidosJugados(this.getPartidosJugados()+1);
        }
        
        public void updatePromedio(){
            if (StatsPartido.getInstance().getCount()!=0){
                this.setPromedio((double)this.partidosGanados/StatsPartido.getInstance().getCount());
            }
            JugadorHome.getInstance().saveUpdatePlayer(this);
        }	
}
