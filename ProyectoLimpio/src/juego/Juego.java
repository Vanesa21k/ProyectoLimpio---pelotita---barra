package juego;



import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	// Variables y métodos propios de cada grupo
	// ...
	private Barra barra;
	private Pelota pelota;
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		pelota = new Pelota(this.entorno.ancho()/2,this.entorno.alto()/2,50,-1,1,1);
		this.barra = new Barra(entorno.ancho()/2, entorno.alto() - 100, 200, 50, 5);
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		
		pelota.dibujar(entorno);
		pelota.mover();
		if(pelota.hayColisionPorAbajo(entorno) || pelota.hayColisionPorArriba()) {
			pelota.cambiarMovimientoVertical();
		}
		if(pelota.hayColisionPorDerecha(entorno) || pelota.hayColisionPorIzquierda()) {
			pelota.cambiarMovimientoHorizontal();
		}
		
		barra.dibujarse(entorno);
		if(entorno.estaPresionada(entorno.TECLA_DERECHA) && !barra.hayColisionDerecha(entorno))
			barra.moverDerecha(entorno);
		
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && !barra.hayColisionIzquierda())
			barra.moverIzquierda();
		
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
