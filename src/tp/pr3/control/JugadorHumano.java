/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Ficha;
import tp.pr3.logica.Game;
import tp.pr3.logica.Movimiento;
import tp.pr3.logica.MovimientoInvalido;
import tp.pr3.logica.Tablero;

/**
 *
 * @author marcoantonio
 */
public class JugadorHumano implements Jugador {

    public JugadorHumano(Scanner input, FactoriaTipoJuego fact)
    {
        this.input=input;
        this.fact=fact;
    }
    @Override
    public Movimiento getMovimiento(Tablero tab, Ficha color) throws MovimientoInvalido {
        int col=0, fila=0;
        try{
            System.out.print("Introduce la columna: ");//Vamos a fiarnos del usuario
            String comando=input.nextLine();//No podemos usar try catch
            comando=comando.trim();
            col=Integer.parseInt(comando);
            if(fact.filasImportan())
            {
                System.out.print("Introduce la fila: ");//Vamos a fiarnos del usuario
                comando=input.nextLine();//No podemos usar try catch
                comando=comando.trim();
                fila=Integer.parseInt(comando);
            }
        }
        catch(NumberFormatException e)
        {
            throw new MovimientoInvalido();
        }
        Movimiento mov=fact.creaMovimiento(col, fila, color);
        
        return mov;
    }
    private Scanner input;
    private FactoriaTipoJuego fact;
}
