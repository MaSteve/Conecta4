package tp.pr1.logica;
import tp.pr1.logica.utilidades.CircularUnsignedIntStack;

/**
 *
 * @author marcoantonio
 */
public class Partida {
    /*
     * Clase Partida. Maneja un tablero de fichas y tiene las funcionalidades
     * básicas de la práctica
     */
    public Partida()
    {
        reset();
    }
    public boolean ejecutaMovimiento(Ficha color, int col)
    {   //Intenta ejecutar un movimiento y comunica al controlador si hay éxito
        if(col<=0||col>ANCHO)return false;
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
            tablero.setCasilla(col, i-1, color);//Tras localizar la posición coloca la ficha
            stack.push(col);//Almacena el movimiento
            turno=turno.contrario();//Cambia el turno
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
    public boolean cuatroEnRaya(Ficha color, int posx, int posy, int incrx, int incry)
    {//No se usa esta función
        int x=posx+incrx;
        int y=posy+incry;
        int cont=1;
        boolean stop=false;
        while(!stop && x<=ANCHO && y<=ALTO)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x=x+incrx;
                y=y+incry;
                cont++;
                if(cont==4)
                {
                    ganador=turno.contrario();
                    return true;
                }
            }
            else stop=true;
        }
        x=posx-incrx;
        y=posy-incry;
        stop=false;
        while(!stop && x>=1 && y>=1)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x=x-incrx;
                y=y-incry;
                cont++;
                if(cont==4)
                {
                    ganador=turno.contrario();
                    return true;
                }
            }
            else stop=true;
        }
        return false;
    }
    public boolean isTerminada()
    {//Determina si la partida ha terminado. Se ejecuta en el controlador.
        if(lastx<1||lastx>ANCHO||lasty<1||lasty>ALTO)return false;
        boolean stop=false;
        Ficha color=tablero.getCasilla(lastx, lasty);
        ////EJE X
        //cuatroEnRaya(color, lastx, lasty, 1, 0);
        int x=lastx+1, y=lasty, cont=1;
        while(!stop && x<=ANCHO)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x++;
                cont++;
                if(cont==4)
                {
                    ganador=turno.contrario();
                    terminada=true;
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
                    ganador=turno.contrario();
                    terminada=true;
                    return true;
                }
            }
            else stop=true;
        }
        ////EJE Y
        //cuatroEnRaya(color, lastx, lasty, 0, 1);
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
                    ganador=turno.contrario();
                    terminada=true;
                    return true;
                }
            }
            else stop=true;
        }
        ////DIAGONAL 1
        //cuatroEnRaya(color, lastx, lasty, 1, 1);
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
                    ganador=turno.contrario();
                    terminada=true;
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
                    ganador=turno.contrario();
                    terminada=true;
                    return true;
                }
            }
            else stop=true;
        }
        ////DIAGONAL 2
        //cuatroEnRaya(color, lastx, lasty, 1, -1);
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
                    ganador=turno.contrario();
                    terminada=true;
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
                    ganador=turno.contrario();
                    terminada=true;
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
        terminada=end;
        return end;
    }
    public void reset()//Es en sí el constructor de la Partida
    {
        lastx=0;
        lasty=0;
        tablero=new Tablero(ANCHO, ALTO);
        stack=new CircularUnsignedIntStack();
        turno=Ficha.BLANCA;
        terminada=false;
        ganador=Ficha.VACIA;
    }
    public boolean undo()
    {//Función deshacer. Llama a la pila para obtener la última columna usada
        int col=stack.pop();
        if(col<1||col>ANCHO) return false;
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
            if(stop){
            tablero.setCasilla(col, i, Ficha.VACIA); //Se pone vacio
            turno=turno.contrario();//Cambia el turno
            lastx=0;
            lasty=0; //Se ponen a cero para evitar problemas
            return true;}
            else return false;//Otra ñapa de mierda
        }
    }
    
    private int lastx;//Permiten agilizar la función isTerminada()
    private int lasty;//Es la posición del último movimiento
    
    private CircularUnsignedIntStack stack;
    private Tablero tablero; 
    private Ficha turno; 
    private boolean terminada; 
    private Ficha ganador;
    private static final int ANCHO=7;
    private static final int ALTO=6;
}
