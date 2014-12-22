/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

import java.util.Scanner;
import tp.pr2.logica.Ficha;
import tp.pr2.logica.Game;
import tp.pr2.logica.Movimiento;
import tp.pr2.logica.Tablero;

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
    public Movimiento getMovimiento(Tablero tab, Ficha color) {
        System.out.print("Introduce la columna: ");//Vamos a fiarnos del usuario
        String comando=input.nextLine();//No podemos usar try catch
        comando=comando.trim();
        int col=Integer.parseInt(comando), fila=0;
        Movimiento mov;
        if(fact.filasImportan())
        {
            System.out.print("Introduce la fila: ");//Vamos a fiarnos del usuario
            comando=input.nextLine();//No podemos usar try catch
            comando=comando.trim();
            fila=Integer.parseInt(comando);
        }
        mov=fact.creaMovimiento(col, fila, color);
        
        return mov;
    }
    private Scanner input;
    private FactoriaTipoJuego fact;
}
