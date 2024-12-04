//Written by Joe Hardy
//Comments from https://cse.sc.edu/~shephejj/csce146/Labs/Lab08FoodOrderSimulatorHeap.html
public class MinHeap<T extends Comparable<T>> {
	
	private T[] heap;
	private int size;
	public static final int MAX_SIZE = 1024;
	
	public MinHeap() {
		heap = (T[]) new Comparable[MAX_SIZE];
		size = 0;
	}
	
    //add: Takes in a new element via a parameter and adds it to the heap.
	public void add(T element) {
		heap[size] = element;
		
		if (heap[size].compareTo(heap[getParentIndex(size)]) < 0) {
			bubbleUp();
		}
			
		size++;
	}
	
	private void bubbleUp() {
		
		int index = size;
		
		while ( index > 0 && heap[index].compareTo(heap[getParentIndex(index)]) < 0 ) {
			T temp = heap[getParentIndex(index)];
			heap[getParentIndex(index)] = heap[index];
			heap[index] = temp;
			index = getParentIndex(index);
		}
	}
	
    //remove: Removes and returns the first element in the heap.
	public T remove() {
		
		if (size > 0) {
			T temp = heap[0];
			heap[0] = heap[size-1];
			heap[size-1] = null;
			
			bubbleDown();
			
			size--;
			return temp;
		}
		else {
			return null;
		}
	}
	
	private void bubbleDown() {
		
		int index = 0;
		
		while (getLeftChildIndex(index) < size) {
			int smallerIndex = getLeftChildIndex(index);
			if (getRightChildIndex(index) < size && heap[getRightChildIndex(index)] != null && heap[getRightChildIndex(index)].compareTo(heap[getLeftChildIndex(index)]) < 0) {
				smallerIndex = getRightChildIndex(index);
			}
			if (heap[smallerIndex] != null && heap[index].compareTo(heap[smallerIndex]) > 0) {
				T temp = heap[index];
				heap[index] = heap[smallerIndex];
				heap[smallerIndex] = temp;
			}
			else
				break;
			index = smallerIndex;
		}
	}
	
	private int getRootIndex() {
		return 0;
	}
	
	private int getLeftChildIndex(int parentIndex) {
		return parentIndex*2 + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return parentIndex*2 + 2;
	}
	
	private int getParentIndex(int childIndex) {
		return (childIndex-1) / 2;
	}
	
}
