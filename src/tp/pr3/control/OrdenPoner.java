package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Movimiento;
import tp.pr3.logica.MovimientoInvalido;

/**
 *
 * @author marcoantonio
 */
public class OrdenPoner extends Orden{

    @Override
    public void ejecuta(Scanner input, Controlador control) {
        try{
            Movimiento mov=control.getJugador().getMovimiento(control.getPartida().getTablero(),
                    control.getPartida().getTurno());
            control.getPartida().ejecutaMovimiento(mov);
        }
        catch(MovimientoInvalido e)
        {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Orden parsea(String[] ord) {
        if(ord[0].equals("poner")) return this;
        else return null;
    }

    @Override
    public String getTextoAyuda() {
        return "PONER: utilízalo para poner la siguiente ficha."; 
    }
    
}
