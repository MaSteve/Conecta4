/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr3.logica;

/**
 *
 * @author marcoantonio
 */
public class MovimientoGravity extends Movimiento{

    public MovimientoGravity(int columna, int fila, Ficha color)//, Tablero tab)
    {
        this.columna=columna;
        this.fila=fila;
        //posDef(columna, fila, tab);
        this.color=color;
    }
    @Override
    public void ejecutaMovimiento(Tablero tab) throws MovimientoInvalido {
        posDef(columna, fila, tab);
        if(!tab.enLimites(columna, fila))
        {
            throw new MovimientoInvalido("Posición incorrecta.");
        }
        else if(!tab.getCasilla(columna, fila).equals(Ficha.VACIA))
        {
            throw new MovimientoInvalido("Casilla ocupada.");
        }
        else tab.setCasilla(columna, fila, color);
        //return true;
    }
    private void posDef(int posx, int posy, Tablero tab)
    {
        //columna=posx;
        //fila=posy;
        if(tab.getCasilla(posx, posy).equals(Ficha.VACIA))
        {
            int[] grav=Gravedad(tab);
            int x=posx+grav[3]-grav[2];
            int y=posy+grav[1]-grav[0];

            if(x!=columna || y!=fila)
            {
                boolean stop=false;
                while(tab.enLimites(x, y) && !stop)
                {
                    Ficha cell=tab.getCasilla(x, y);
                    if(cell.equals(Ficha.VACIA))
                    {
                        columna=x;
                        fila=y;
                        x=x+grav[3]-grav[2];
                        y=y+grav[1]-grav[0];
                    }
                    else stop=true;
                }
            }
        }
    }
    
    private int[] Gravedad(Tablero tab) //UP DOWN LEFT RIGHT
    {
        int[] grav=new int[4];
        grav[0]=fila-1;
        grav[1]=tab.getAlto()-fila;
        grav[2]=columna-1;
        grav[3]=tab.getAncho()-columna;
        int min=grav[0];
        for(int i=1; i<4; i++)
        {
            if(grav[i]<min)min=grav[i];
        }
        for(int i=0; i<4; i++)
        {
            if(grav[i]==min)grav[i]=1;
            else grav[i]=0;
        }
        return grav;
    }
    @Override
    public void undo(Tablero tab) {
        tab.setCasilla(columna, fila, Ficha.VACIA);
    }
    
}
