/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenSalir extends Orden {

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        control.exitRequest();
    }

    @Override
    public Orden parsea(String[] ord) {
        if(ord[0].equals("salir")) return this;
        else return null;
    }

    @Override
    public String getTextoAyuda() {
        return "SALIR: termina la aplicación.";
    }
    
}