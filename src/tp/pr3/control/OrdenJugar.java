package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenJugar extends Orden {

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        if(ord.length<2){
            System.err.println("No te entiendo.");
            return;
        }
        switch(ord[1])
        {
            case "co":
                control.setFactoria(new FactoriaComplica());
                partida.reset(control.getFactoria().creaReglas());break;
            case "c4":
                control.setFactoria(new FactoriaConecta4());
                partida.reset(control.getFactoria().creaReglas());break;
            case "gr":
                if(ord.length==4)
                {
                    int tamx=0, tamy=0;
                    try
                    {
                        tamx=Integer.parseInt(ord[2]);
                        tamy=Integer.parseInt(ord[3]);
                    }
                    catch(Exception e)
                    {
                        System.err.println("No te entiendo.");return; //TODO
                    }
                    control.setFactoria(new FactoriaGravity(tamx, tamy));
                    partida.reset(control.getFactoria().creaReglas());
                    break;
                }
            default:System.err.println("No te entiendo.");return;    
        }
        System.out.println("Partida reiniciada.");
    }

    @Override
    public Orden parsea(String[] ord) {
        if(ord[0].equals("jugar"))
        {
            OrdenJugar ret=new OrdenJugar();
            ret.ord=ord;
            return ret;
        }
        else return null;    
    }

    @Override
    public String getTextoAyuda() {
        return "JUGAR [c4|co|gr] [tamX tamY]: cambia el tipo de juego.";
    }
        
    private String[]ord;
}
