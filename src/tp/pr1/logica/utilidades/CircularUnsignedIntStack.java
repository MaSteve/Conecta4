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
	}	
	
	public CircularUnsignedIntStack(int size) {
		gonda = new int[size];
		bot = top = 0;
	}

	public int count() {
		if (bot > top)  return top + 1 + gonda.length - bot;
		else			return top - bot;
	}

	public void push(int val) {
		top = inc(top);
		if (top == bot) bot = inc(bot);
		gonda[top] = val;
	}

	public int pop() {
		if (bot == top) return -1;
		else {
			top = dec(top);
			return gonda[inc(top)];
		}
	}

	public void clear() {
		int size = gonda.length;
		if (size < 1)
			size = 10;
		gonda = new int[size];
		bot = top = 0;
	}
	

	private int inc(int n) {
		int size = gonda.length;
		return (n+1)%size;
	}
	
	private int dec(int n) {
		int size = gonda.length;
		return (n-1)%size;
	}
	
	private int gonda[];
	private int bot, top;
}
