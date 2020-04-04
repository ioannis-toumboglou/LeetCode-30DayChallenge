package LeetCode;

public class Day04_MoveZeros {
	
	public static void printArray(int[] array) {
		String result = "[";
		
		for (int i=0; i<array.length-1; i++) {
			result = result + array[i] + ", ";
		}
		
		result = result + array[array.length-1] +  "]";
		
		System.out.println(result);
	}
	
	public static int[] moveZeros(int[] array) {
		
		for (int i=0; i<array.length-1; i++) {
			for (int j=i+1; j<array.length; j++) {
				if (array[i] == 0) {
					if (array[j] != 0) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
		}

		return array;
	}

	public static void main(String[] args) {
		
		int[] array = {0,1,0,3,12};
		
		printArray(moveZeros(array));
	}

}
