// The interface that was required to be declared
// This innterface is being implemented bt GenericStack class
public interface GenericStackInterface<E>{
	
	public int getSize();
	public E peek();
	public void push(E item);
	public boolean isEmpty();
	public E pop();	
}
