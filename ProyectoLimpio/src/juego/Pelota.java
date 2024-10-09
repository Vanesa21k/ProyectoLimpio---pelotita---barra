package juego;

import java.awt.Color;

import entorno.Entorno;

public class Pelota {
	double x;
	double y;
	double radio;
	private int movimientoVertical;
	private int movimientoHorizontal;
	private int velocidad;
	
	public Pelota(double x, double y, double radio, int movV, int movH, int vel) {
		this.x = x;
		this.y = y;
		this.radio = radio;
		this.movimientoHorizontal = movH;
		this.movimientoVertical = movV;
		this.velocidad = vel;
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarCirculo(this.x, this.y, this.radio*2, Color.red);
	}
	
	public void mover() {
		this.x+=movimientoHorizontal*velocidad;
		this.y+=movimientoVertical*velocidad;
		
	}
	
	public boolean hayColisionPorArriba() {
		return this.y - this.radio <= 0;
	}
	
	public boolean hayColisionPorAbajo(Entorno entorno) {
		return this.y + this.radio >= entorno.alto();
	}
	
	public void cambiarMovimientoVertical() {
		this.movimientoVertical*=-1;
	}
	
	public boolean hayColisionPorIzquierda() {
		return this.x - this.radio <= 0;
	}
	
	public boolean hayColisionPorDerecha(Entorno entorno) {
		return this.x + this.radio >= entorno.ancho();
	}
	
	public void cambiarMovimientoHorizontal() {
		this.movimientoHorizontal*=-1;
	}
	

}
