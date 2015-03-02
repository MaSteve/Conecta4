package tp.pr3.logica;

/**
 *
 * @author marcoantonio
 */
public abstract class Movimiento {
    public abstract void ejecutaMovimiento(Tablero tab) throws MovimientoInvalido;
    public abstract void undo(Tablero tab);
    public Ficha getJugador()
    {
        return color;
    }
    public int getColumna()
    {
        return columna;
    }
    
    public int getFila()//Ojo a ver quien lo usa
    {
        return fila;
    }
    
    protected int columna;//Esto igual no le gusta!!!!
    protected int fila;
    protected Ficha color;
}
