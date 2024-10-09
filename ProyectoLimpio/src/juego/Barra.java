package juego;

import java.awt.Color;

import entorno.Entorno;

public class Barra {
	

	private double x;
	private double y;
	private double ancho;
	private double alto;
	
	private double desplazamiento;

	public Barra(double x, double y, double ancho, double alto, double desplazamiento) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.desplazamiento = desplazamiento;
	}
	
	public void dibujarse(Entorno e) {
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.white);
	}
	
	public void moverDerecha(Entorno e) {
		//if(this.x + this.ancho/2 < e.ancho())
			this.x += this.desplazamiento; 
	}
	
	public boolean hayColisionDerecha(Entorno e){
		return this.x + this.ancho/2 < e.ancho();
	}
	public void moverIzquierda() {
		//if(this.x - this.ancho/2 > 0 )
			this.x -= this.desplazamiento; 
	}
	
	public boolean hayColisionIzquierda(){
		return this.x - this.ancho/2 > 0;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getAncho() {
		return ancho;
	}

	public double getAlto() {
		return alto;
	}
}
