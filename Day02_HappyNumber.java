package LeetCode;

public class Day02_HappyNumber {
	
	public static int newNumber(int number) {
		int newNumber = 0;
		
		while (number != 0) {
			newNumber = newNumber + (number % 10)*(number % 10);
			number /= 10;
		}
		
		return newNumber;
	}

	public static boolean isHappy(int number) {
		int counter = 1000;
		
		if (number == 1) {
			return true;
		}
		
		while (counter > 0) {
			number = newNumber(number);
			if (number == 1) {
				return true;
			} else {
				counter--;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int number = 19;
		
		System.out.println(isHappy(number));

	}

}
