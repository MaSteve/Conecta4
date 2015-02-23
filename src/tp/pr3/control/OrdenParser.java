/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr3.control;

/**
 *
 * @author marcoantonio
 */
public class OrdenParser { //ESTO TIENE QUE SER TODO ESTÁTICO!!!
    
    /*public OrdenParser()
    {
        ordenes=new Orden[]{new OrdenPoner(), new OrdenDeshacer(), new OrdenReiniciar(),
            new OrdenJugar(), new OrdenJugador(), new OrdenSalir(), new OrdenAyuda()};
    }*/
    
    public static Orden parser(String orden)
    {
        String[] order=orden.split("\\s+");
        for(Orden ord: ordenes)
        {
            if(ord.parsea(order)!=null) 
            {
                return ord;
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
    
    private static Orden ordenes[] = new Orden[]{new OrdenPoner(), new OrdenDeshacer(), new OrdenReiniciar(),
            new OrdenJugar(), new OrdenJugador(), new OrdenSalir(), new OrdenAyuda()};;
}
