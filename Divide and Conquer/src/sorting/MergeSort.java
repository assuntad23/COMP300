package sorting;

public class MergeSort {

	@SuppressWarnings("rawtypes")
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
		
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		
		if (hi <= lo)
			return;
		int mid = lo + (hi-lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		
		for(int k = lo; k<= hi; k++){
			aux[k] = a[k];
		}
		
		for (int k = lo; k<= hi; k++){
			if (i >mid)
				a[k] = aux[j++];
			else if (j >hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else 
				a[k] = aux[i++];
		}
	}
	
	public static void printArray(Comparable [] a){
		for (Comparable c : a)
			System.out.print(c + " ");
		System.out.println();
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static boolean less(Comparable a, Comparable b){
		int ret = a.compareTo(b);
		return (ret<0);	
	}

	public static void main(String[] args) {
		Integer[] arr = {2,4,65,98,1,37,3,2,665};
		System.out.println("Before...");
		printArray(arr);
		
		sort(arr);
		System.out.println("After...");
		printArray(arr);
	}

}
