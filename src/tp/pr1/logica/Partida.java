/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1.logica;

import tp.pr1.logica.utilidades.CircularUnsignedIntStack;

/**
 *
 * @author marcoantonio
 * @author ivan
 */
public class Partida {

	public Partida() {
		reset();
	}

	public final void reset() // IT'S THE FINAL COUNTDOWN
	{
		tablero = new Tablero(ANCHO, ALTO);
		turno = Ficha.BLANCA;
		ganador = Ficha.VACIA;
		historial = new CircularUnsignedIntStack();
	}

	public Ficha getGanador() {
		return ganador;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public boolean isTerminada() {
		return (ganador == Ficha.VACIA)? false: true;
	}

	public boolean undo() {
		if (historial.count() == 0) return false;
		else {
			int col = historial.pop();
			int i = buscarCima(col);
			tablero.setCasilla(col, i+1, Ficha.VACIA);
			turno = turno.contrario();
			return true;
		}
	}

	public boolean ejecutaMovimiento(Ficha color, int col) {
		if (color != turno)	return false;
		if (tablero.getCasilla(col, 1) != Ficha.VACIA ) return false;
		// Todo correcto
		ponerFicha(col);
		// Comprobar efecto de este movimiento
		if (principalDiagonal(col) || secoundaryDiagonal(col) || horizontal(col) || vertical(col))
			ganador = turno.contrario();
		return true;
	}
	
	public Ficha getTurno() {
		return turno;
	}
	
	private boolean principalDiagonal(int col) {
		int i = buscarCima(col);
		if (++i <= tablero.getAlto()) {
			Ficha ficha = tablero.getCasilla(col, i);
			int countUp = 0, countDown = 0;
			while(i - 1 - countUp >= 1 && col - 1 - countUp >= 1 && tablero.getCasilla(col - 1 - countUp, i - 1 - countUp) == ficha )
				countUp++;
			while(i + 1 + countDown <= tablero.getAlto() && col + 1 + countDown <= tablero.getAncho() && tablero.getCasilla(col + 1 + countDown, i + 1 + countDown) == ficha)
				countDown++;
			if (countUp + 1 + countDown >= 4) return true;
		}
		return false;
	}
	
	private boolean secoundaryDiagonal(int col) {
		int i = buscarCima(col);
		if (++i <= tablero.getAlto()) {
			Ficha ficha = tablero.getCasilla(col, i);
			int countUp = 0, countDown = 0;
			while(i - 1 - countUp >= 1 && col + 1 + countUp <= tablero.getAncho() && tablero.getCasilla(col + 1 + countUp, i -1 - countUp) == ficha )
				countUp++;
			while(i + 1 + countDown <= tablero.getAlto() && col - 1 - countDown >= 1 && tablero.getCasilla(col -1 - countDown, i + 1 + countDown) == ficha)
				countDown++;
			if (countUp + 1 + countDown >= 4) return true;
		}
		return false;
	}
	
	private boolean horizontal(int col) {
		int i = buscarCima(col);
		if (++i <= tablero.getAlto()) {
			Ficha ficha = tablero.getCasilla(col, i);
			int countLeft = 0, countRight = 0;
			while (i - 1 - countLeft >= 1 && tablero.getCasilla(col, i - 1 - countLeft) == ficha) countLeft++;
			while (i + 1 + countRight <= tablero.getAlto() && tablero.getCasilla(col, i + 1 + countRight) == ficha) countRight++;
			if (countLeft + 1 + countRight >= 4) return true;
		}
		return false;
	}
	
	private boolean vertical(int col) {
		int i = buscarCima(col);
		if ((tablero.getAlto() - i) >= 4) {
			int count = 0;
			i++;
			Ficha ficha = tablero.getCasilla(col, i);
			while(i <= tablero.getAlto() && tablero.getCasilla(col, i) == ficha) {
				i++;
				count++;
			}
			if (count >= 4) return true;
		}
		return false;
	}
	
	private void ponerFicha(int col) {
		int i = buscarCima(col);
		if (i > 0) tablero.setCasilla(col, i, turno);
		historial.push(col);
		turno = turno.contrario();
	}

	private int buscarCima(int col) {
		int i = tablero.getAlto();
		while( i > 0 && tablero.getCasilla(col, i) != Ficha.VACIA) {
			i--;
		}
		return i;
	}
	
	private CircularUnsignedIntStack historial;
	private Tablero tablero;
	private Ficha turno;
	private Ficha ganador;
	private static final int ANCHO = 7;
	private static final int ALTO  = 6;
}
