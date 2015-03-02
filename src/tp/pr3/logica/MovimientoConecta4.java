package tp.pr3.logica;

/**
 *
 * @author marcoantonio
 */
public class MovimientoConecta4 extends Movimiento {

    public MovimientoConecta4(int donde, Ficha color)
    {
        columna=donde;
        this.color=color;
    }
    @Override
    public void ejecutaMovimiento(Tablero tab) throws MovimientoInvalido {
        if(columna<=0||columna>tab.getAncho())
        {
            throw new MovimientoInvalido("Columna incorrecta. Debe estar entre 1 y "+tab.getAncho()+".");
        }
        if(!(tab.getCasilla(columna, 1).equals(Ficha.VACIA)))
        {
            throw new MovimientoInvalido("Columna llena.");
        }
        else
        {
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
            //return true;
        }
    }

    @Override
    public void undo(Tablero tab) {
        if(columna>=1 && columna<=tab.getAncho())
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
            if(stop) tab.setCasilla(columna, i, Ficha.VACIA); //Se pone vacio
        }
    }
    
}
