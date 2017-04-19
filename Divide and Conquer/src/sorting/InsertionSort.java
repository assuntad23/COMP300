package sorting;

public class InsertionSort {
	
	public static void sort(int[] array){
		for (int i = 1; i < array.length; i++){
			int key = array[i];
			int j;
			for (j = i-1; j >= 0; j--){
				if (array[j] >= key)
					array[j+1] = array[j];
				else {
					break;
				}
			}
			array[j+1] = key;
		}
	}
	
	public static void printArray(int[] arr){
		for (int i = 0; i < arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 3,4,8,2,5,8,0};
		printArray(arr);
		sort(arr);
		printArray(arr);
	}

}


