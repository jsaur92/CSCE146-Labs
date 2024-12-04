//Written by Joe Hardy
public class SortSorter {
	
	Item[] items;
	
	//Turn the array of strings into an array of Items.
	public SortSorter(String[] sorts) {
		items = new Item[sorts.length];
		for (int i = 0; i < sorts.length; i ++) {
			items[i] = new Item(sorts[i]);
		}
	}
	
	//public method which sorts this object's items variable using mergeSort and then returns it.
	public void sort() {
		items = mergeSort(items);
	}
	
	//Sort the Items by how many times the word "sort" appears, using the merge sort algorithm.
	private Item[] mergeSort(Item[] itm) {
		
		if (itm.length == 1) {
			return itm;
		}
		
		Item[] left = new Item[itm.length / 2];
		for (int i = 0; i < left.length; i++) {
			left[i] = itm[i];
		}
		left = mergeSort(left);
		
		Item[] right = new Item[itm.length / 2 + itm.length % 2];
		for (int i = left.length; i < itm.length; i++) {
			right[i - left.length] = itm[i];
		}
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	//Merge method for the merge sort algorithm.
	private Item[] merge(Item[] left, Item[] right) {
		Item[] ret = new Item[left.length + right.length];
		int i = 0;
		int j = 0;
		
		//Compare the left and right arrays and move the lower value into ret until one array is empty.
		while (i < left.length && j < right.length) {
			//System.out.println("i: " + i + ", j: " + j);
			if (right[j].num < left[i].num) {
				ret[i+j] = right[j];
				j++;
			}
			else {
				ret[i+j] = left[i];
				i++;
			}
		}
		
		//Dump the rest of left into ret (assuming right is empty).
		while (i < left.length) {
			ret[i+j] = left[i];
			i++;
		}
		
		//Dump the rest of right into ret (assuming left is empty).
		while (j < right.length) {
			ret[i+j] = right[j];
			j++;
		}
		
		return ret;
	}
	
	public String[] toStringArray() {
		String[] ret = new String[items.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = items[i].text;
		}
		return ret;
	}
	
	//Contains the text of a line as well as the number of "sort"s in it.
	class Item {
		String text;
		int num;
		
		Item(String text) {
			this.text = text;
			count();
		}
		
		void count() {
			num = 0;
			String t = text.toLowerCase();
			while(t.length() > 3) {
				if (t.substring(0, 4).equals("sort"))
					num++;
				t = t.substring(1);
			}
		}
	}
}
