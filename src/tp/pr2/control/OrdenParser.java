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
public class OrdenParser {
    
    public OrdenParser()
    {
        ordenes=new Orden[]{new OrdenDeshacer(),new OrdenJugarC4(),new OrdenJugarCo(),new OrdenPoner(),new OrdenReiniciar()};
    }
    
    public void Parser(String orden, Partida partida, Scanner input)
    {
        for(Orden ord: ordenes)
        {
            if(ord.parsea(orden)!=null) 
            {
                ord.ejecuta(partida, input);
                return;
            }
        }
        System.err.println("No te entiendo.");
    }
    
    private Orden ordenes[];
}
