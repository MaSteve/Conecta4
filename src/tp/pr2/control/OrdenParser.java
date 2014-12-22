/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

/**
 *
 * @author marcoantonio
 */
public class OrdenParser {
    
    public OrdenParser()
    {
        ordenes=new Orden[]{new OrdenDeshacer(),new OrdenJugarC4(),new OrdenJugarCo(),
                new OrdenPoner(),new OrdenReiniciar(), new OrdenSalir()};
    }
    
    public Orden Parser(String orden)
    {
        for(Orden ord: ordenes)
        {
            if(ord.parsea(orden)!=null) 
            {
                return ord;
            }
        }
        return null;
    }
    
    private Orden ordenes[];
}
