//Written by Joe Hardy
public interface QueueI<Type> {

    //Enqueue: A public method that takes in a parameter of the Generic Type returns nothing.
	public void enqueue(Type thing);
	
    //Dequeue: A public method that takes in no parameters and returns the Generic Type.
	public Type dequeue();
	
    //Peek: A public method that takes in no parameters and returns the Generic Type.
	public Type peek();
	
    //Print: A public method that takes in no parameters and returns nothing.
	public void print();
	
}
