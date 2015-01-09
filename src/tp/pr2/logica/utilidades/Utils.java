/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.logica.utilidades;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Tablero;

/**
 *
 * @author marcoantonio
 */
public class Utils {
    //Agrupa métodos estáticos útiles
    
    public static boolean cuatroEnRaya(Ficha color, int posx, int posy, int incrx, int incry, Tablero t)
    {//En esta versión se usa este método
        int x=posx+incrx;
        int y=posy+incry;
        int cont=1;
        boolean stop=false;
        while(!stop && x<=t.getAncho() && y<=t.getAlto() && x>=1 && y>=1)
        {
            if(t.getCasilla(x, y).equals(color))
            {
                x=x+incrx;
                y=y+incry;
                cont++;
                if(cont==4)
                {
                    //ganador=color;//Revisar
                    return true;
                }
            }
            else stop=true;
        }
        x=posx-incrx;
        y=posy-incry;
        stop=false;
        while(!stop && x<=t.getAncho() && y<=t.getAlto() && x>=1 && y>=1)
        {
            if(t.getCasilla(x, y).equals(color))
            {
                x=x-incrx;
                y=y-incry;
                cont++;
                if(cont==4)
                {
                    //ganador=color;
                    return true;
                }
            }
            else stop=true;
        }
        return false;
    }
}
