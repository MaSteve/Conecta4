package tp.pr3.control;

import java.util.Random;
import tp.pr3.logica.Ficha;
import tp.pr3.logica.Movimiento;
import tp.pr3.logica.MovimientoComplica;
import tp.pr3.logica.Tablero;

/**
 *
 * @author marcoantonio
 */
public class JugadorAleatorioComplica implements Jugador{

    @Override
    public Movimiento getMovimiento(Tablero tab, Ficha color) {
        Random rand=new Random();
        return new MovimientoComplica(rand.nextInt(tab.getAncho())+1,color);
    }
    
}
