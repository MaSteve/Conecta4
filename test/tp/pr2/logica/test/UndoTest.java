package tp.pr2.logica.test;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.MovimientoConecta4;
import tp.pr2.logica.Partida;
import tp.pr2.logica.ReglasConecta4;

public class UndoTest {
	
	Partida p;
	
	@Before
	public void init() {
		p = new Partida(new ReglasConecta4());
	}
	
	@Test
	public void testUndoTrasMovimiento() {
		p.ejecutaMovimiento(new MovimientoConecta4(1, Ficha.BLANCA));
		assertTrue("Tras un movimiento, undo() debería funcionar", p.undo());
		assertTrue("Al hacer undo tras un movimiento, el tablero debe quedar vacío.", UtilsPartidaYTablero.tableroVacio(p.getTablero()));
		assertEquals("Al hacer undo tras un movimiento, debe ser turno de las blancas.", Ficha.BLANCA, p.getTurno());
		assertFalse("Al hacer undo tras un movimiento, la partida no ha debido terminar.", p.isTerminada());
	}
	
	@Test
	public void testUndo10Veces() {		
		for (int i = 1; i <= 3; ++i)
			for (int x = 1; x <= 7; ++x) {
				p.ejecutaMovimiento(new MovimientoConecta4(x, p.getTurno()));
				assertFalse(p.isTerminada());
			}
		
		for (int i = 0; i < 10; ++i) {
			Ficha turno = p.getTurno();
			assertTrue("El undo debería poder hacerse al menos 10 veces.", p.undo());
			assertTrue("Tras undo el turno no cambio.", turno != p.getTurno());
			assertFalse(p.isTerminada());
		}
		
		for (int i = 0; i < 28; ++i) {
			int x = 1 + (i % 7);
			int y = 6 - (i / 7);
			Ficha color = (i % 2 == 0) ? Ficha.BLANCA : Ficha.NEGRA;
			if (i >= 11) color = Ficha.VACIA;
			assertEquals("Tras el undo el tablero no se mantiene igual en (" + x + ", " + y + ").", color,
					p.getTablero().getCasilla(x,  y));
		}
	}
	
	@Test
	public void testNoUndoTrasReset() {
		assertTrue(p.ejecutaMovimiento(new MovimientoConecta4(3, p.getTurno())));
		p.reset(new ReglasConecta4());
		assertFalse("Tras reset, undo() no debe funcionar.", p.undo());
	}
}
