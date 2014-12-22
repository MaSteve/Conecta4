/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

import java.util.Scanner;
import tp.pr2.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public abstract class Orden {
    public abstract void ejecuta(Partida partida, Scanner input, Controlador control);
    public abstract Orden parsea(String ord);
}
