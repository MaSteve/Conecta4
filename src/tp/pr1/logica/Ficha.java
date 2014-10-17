/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1.logica;

/**
 *
 * @author marcoantonio
 */
public enum Ficha {
    BLANCA, NEGRA, VACIA;
    
    public Ficha contrario()
    {
        switch(this)
        {
            case BLANCA: return NEGRA;
            case NEGRA: return BLANCA;  
            default: return VACIA;
        }
    }
}
