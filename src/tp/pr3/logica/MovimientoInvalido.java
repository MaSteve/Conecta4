package tp.pr3.logica;

/**
 *
 * @author marcoantonio
 */
public class MovimientoInvalido extends Exception{
    public MovimientoInvalido()
    {
        super();
    }
    public MovimientoInvalido(String msg, Throwable arg)
    {
        super(msg, arg);
    }
    public MovimientoInvalido(String msg)
    {
        super(msg);
    }
    public MovimientoInvalido(Throwable arg)
    {
        super(arg);
    }
}
