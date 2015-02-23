package tp.pr3.logica;

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
