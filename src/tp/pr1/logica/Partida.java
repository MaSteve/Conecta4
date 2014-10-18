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
 */
public class Partida {
    
    public Partida()
    {
        reset();
    }
    public boolean ejecutaMovimiento(Ficha color, int col)
    {
        if(!(tablero.getCasilla(col, 1).equals(Ficha.VACIA))||
                !color.equals(turno)||terminada)
        {
            return false;
        }
        else
        {
            int i=2;
            boolean stop=false;
            while(i<=ALTO && !stop)
            {
                if(tablero.getCasilla(col, i).equals(Ficha.VACIA))
                i++;
                else
                {
                    stop=true;
                }
            }
            lastx=col;
            lasty=i-1;
            tablero.setCasilla(col, i-1, color);
            stack.push(col);
            turno=turno.contrario();
            return true;
        }
    }
    public Ficha getGanador()
    {
        return ganador;
    }
    public Tablero getTablero()
    {
        return tablero;
    }
    public Ficha getTurno()
    {
        return turno;
    }
    public boolean isTerminada()
    {
        boolean stop=false;
        Ficha color=tablero.getCasilla(lastx, lasty);
        ////EJE X
        int x=lastx+1, y=lasty, cont=1;
        while(!stop && x<=ANCHO)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x++;
                cont++;
                if(cont==4)
                {
                    ganador=turno;
                    return true;
                }
            }
            else stop=true;
        }
        x=lastx-1;
        stop=false;
        while(!stop && x>=1)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x--;
                cont++;
                if(cont==4)
                {
                    ganador=turno;
                    return true;
                }
            }
            else stop=true;
        }
        ////EJE Y
        x=lastx;
        y=lasty+1;
        cont=1;
        stop=false;
        while(!stop && y<=ALTO)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                y++;
                cont++;
                if(cont==4)
                {
                    ganador=turno;
                    return true;
                }
            }
            else stop=true;
        }
        ////DIAGONAL 1
        x=lastx+1;
        y=lasty+1;
        cont=1;
        stop=false;
        while(!stop && x<=ANCHO && y<=ALTO)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x++;
                y++;
                cont++;
                if(cont==4)
                {
                    ganador=turno;
                    return true;
                }
            }
            else stop=true;
        }
        x=lastx-1;
        y=lasty-1;
        stop=false;
        while(!stop && x>=1 && y>=1)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x--;
                y--;
                cont++;
                if(cont==4)
                {
                    ganador=turno;
                    return true;
                }
            }
            else stop=true;
        }
        ////
        x=lastx+1;
        y=lasty-1;
        cont=1;
        stop=false;
        while(!stop && x<=ANCHO && y>=1)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x++;
                y--;
                cont++;
                if(cont==4)
                {
                    ganador=turno;
                    return true;
                }
            }
            else stop=true;
        }
        x=lastx-1;
        y=lasty+1;
        stop=false;
        while(!stop && x>=1 && y<=ALTO)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x--;
                y++;
                cont++;
                if(cont==4)
                {
                    ganador=turno;
                    return true;
                }
            }
            else stop=true;
        }
        ////
        boolean end=true;
        int i=1; 
        while(end && i<=ANCHO)
        {
            end=!tablero.getCasilla(i, 1).equals(Ficha.VACIA);
            i++;
        }
        return end;
    }
    public final void reset() //???
    {
        tablero=new Tablero(ANCHO, ALTO);
        stack=new CircularUnsignedIntStack();
        turno=Ficha.BLANCA;
        terminada=false;
        ganador=Ficha.VACIA;
    }
    public boolean undo()
    {
        int col=stack.pop();
        if(col<=1||col>ANCHO) return false;
        else
        {
            int i=1;
            boolean stop=false;
            while(i<=ALTO && !stop)
            {
                if(tablero.getCasilla(col, i).equals(Ficha.VACIA))
                i++;
                else
                {
                    stop=true;
                }
            }
            tablero.setCasilla(col, i-1, Ficha.VACIA);
            turno=turno.contrario();
            return true;
        }
    }
    
    private int lastx;//Pueden desaparecer en futuras revisiones
    private int lasty;
    
    private CircularUnsignedIntStack stack;
    private Tablero tablero; 
    private Ficha turno; 
    private boolean terminada; 
    private Ficha ganador;
    private static final int ANCHO=8;
    private static final int ALTO=8;
}
