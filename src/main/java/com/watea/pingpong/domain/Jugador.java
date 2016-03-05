package com.watea.pingpong.domain;

public class Jugador {

	public String nombre;
	public String apellido;
	public int puntosFavor;
        public int puntosContra;
	public int PartidosJugados;
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
