/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1.logica.utilidades;

/**
 *
 * @author ivan
 */
public class CircularUnsignedIntStack {
	public CircularUnsignedIntStack() {
		gonda = new int[10];
                empty=true;
                bot = top = 0;//Iván la vas a cagar
	}	
	
	public CircularUnsignedIntStack(int size) {
		gonda = new int[size];
                empty=true;
		bot = top = 0;
	}

	public int count() {
		if (bot > top)  return top + 1 + gonda.length - bot;
		else			return top - bot;
	}

	public void push(int val) { //Culo incluido cabeza sin incluir?
		top = inc(top);
		if (top == bot) bot = inc(bot);
		gonda[top] = val;
                if(empty)empty=false;
	}

	public int pop() {
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

	public void clear() {
		int size = gonda.length;
		/*if (size < 1) EN QUE COJONES PENSABAS CON ESTO?
			size = 10;*/
		gonda = new int[size];
                empty=true;
		bot = top = 0;
	}
	

	private int inc(int n) {
		int size = gonda.length;
		return (n+1)%size;
	}
	
	private int dec(int n) {
		int size = gonda.length;
                if(n==0)return size-1;
		else
                    return (n-1); //Tengo mis dudas ESTO ERA UNA MIERDA
	}
	
	private int gonda[];
	private int bot, top;
        private boolean empty;
}
