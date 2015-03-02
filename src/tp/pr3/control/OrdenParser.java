package tp.pr3.control;

/**
 *
 * @author marcoantonio
 */
public class OrdenParser { //ESTO TIENE QUE SER TODO ESTÁTICO!!!
    
    public static Orden parser(String orden)
    {
        String[] order=orden.split("\\s+");
        for(Orden ord: ordenes)
        {
            Orden ret=ord.parsea(order);
            if(ret!=null) 
            {
                return ret;
            }
        }
        return null;
    }
    
    public static void Ayuda()
    {
        StringBuilder str=new StringBuilder();
        str.append("Los comandos disponibles son:\n\n");
        for(Orden ord: ordenes) 
        {
            str.append(ord.getTextoAyuda());
            str.append("\n");
        }
        System.out.println(str.toString());
    }
    
    private final static Orden ordenes[] = new Orden[]{new OrdenPoner(), new OrdenDeshacer(), new OrdenReiniciar(),
            new OrdenJugar(), new OrdenJugador(), new OrdenSalir(), new OrdenAyuda()};;
}
