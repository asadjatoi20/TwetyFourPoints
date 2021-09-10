// Stack follows Last In First Out Order which is easier to solve a expression 
// This class will obtain the input from TextField and arrange it in the form in the stack
import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenericStack<E> implements GenericStackInterface<E>{
	  /**
	   * The list of objects of this stack
	   */
	  private int size; //size of the stack
	  private Object[] array;
	  private int top;

	  private ArrayList<E> list = new ArrayList<E> ();
	  
	    
	  // some methods that needed to be implemented because we are implementing an interface
	public int getSize() {
		return list.size();
	}

	public E peek() {
		return list.get((top-1));
	}

	public void push(E item) {
		list.add (top++, item);
	}

	public boolean isEmpty() {
		return false;
	}

	public E pop() {
		return list.remove (--top);
	} 
}
