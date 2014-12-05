/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.logica;

/**
 *
 * @author marcoantonio
 */
public class MovimientoComplica extends Movimiento {

    public MovimientoComplica(int donde, Ficha color)
    {
        columna=donde;
        this.color=color;
    }
    
    @Override
    public boolean ejecutaMovimiento(Tablero tab) {
        if(columna<=0||columna>tab.getAncho())return false;
        if(!(tab.getCasilla(columna, 1).equals(Ficha.VACIA)))
        {
            quitada=tab.getCasilla(columna, tab.getAlto());
            for(int i=tab.getAlto(); i>1; i--)
            {
                tab.setCasilla(columna, i, tab.getCasilla(columna, i-1));
            }
            tab.setCasilla(columna, 1, color);
        }
        else
        {
            quitada=Ficha.VACIA;
            int i=2;
            boolean stop=false;
            while(i<=tab.getAlto() && !stop)
            {
                if(tab.getCasilla(columna, i).equals(Ficha.VACIA))
                i++;
                else
                {
                    stop=true;
                }
            }
            tab.setCasilla(columna, i-1, color);//Tras localizar la posición coloca la ficha
        }
        return true;
    }

    @Override
    public void undo(Tablero tab) {
        if(columna>=1 && columna<=tab.getAncho())
        {
            if(!quitada.equals(Ficha.VACIA))
            {
                for(int j=1; j<tab.getAlto(); j++)
                {
                    tab.setCasilla(columna, j, tab.getCasilla(columna, j+1));
                }
                tab.setCasilla(columna, tab.getAlto(), quitada);
            }
            else
            {
                int i=1;
                boolean stop=false;
                while(i<=tab.getAlto() && !stop)
                {
                    if(tab.getCasilla(columna, i).equals(Ficha.VACIA))
                    i++;
                    else
                    {
                        stop=true;
                    }
                }
                if(stop)tab.setCasilla(columna, i, Ficha.VACIA); //Se pone vacio
            }
        }
    }
    private Ficha quitada;
    
}
