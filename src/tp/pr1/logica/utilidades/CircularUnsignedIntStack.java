package tp.pr1.logica.utilidades;
/**
 *
 * @author ivan
 */
public class CircularUnsignedIntStack {
    /*
     * Pila. Almacena hasta diez movimientos para la funcionalidad "deshacer".
     * Es circular
     */
	public CircularUnsignedIntStack() {
		gonda = new int[10];
                empty=true;
                bot = top = 0;//Por defecto 10 mov
	}	
	
	public CircularUnsignedIntStack(int size) {
		gonda = new int[size];
                empty=true;
		bot = top = 0;//No se usa
	}

	public int count() {//Devuelve la cantidad de elementos que tiene la pila
		if (bot > top)  return top + 1 + gonda.length - bot;
		else			return top - bot;
	}

	public void push(int val) { //Añade un elemento
		top = inc(top);
		if (top == bot) bot = inc(bot);
		gonda[top] = val;
                if(empty)
                {
                    empty=false;
                    bot = inc(bot);
                }
	}

	public int pop() {//Quita el último elemento y lo devuelve.
                if(empty)return -1;
                else if (bot == top) 
                {
                    empty=true;
                    return gonda[top];
                }
		else {
                        int auxi=top;
			top = dec(top);
			return gonda[auxi];
		}
	}

	public void clear() {//Reset de la pila
		int size = gonda.length;
		gonda = new int[size];
                empty=true;
		bot = top = 0;
	}
	

	private int inc(int n) { //Función interna para push y pop
		int size = gonda.length;
		return (n+1)%size;
	}
	
	private int dec(int n) { //Función interna para push y pop
		int size = gonda.length;
                if(n==0)return size-1;
		else
                    return (n-1);
	}
	
	private int gonda[];
	private int bot, top;
        private boolean empty;
}
