// Given two strings S and T, return if they are equal when both are typed into 
// empty text editors. # means a backspace character.

package LeetCode;

public class Day09_BackspaceStringCompare {
	
	public static String removeHashes(String s) {
		
		StringBuilder sSB = new StringBuilder(s);
		
		while (sSB.toString().contains("#")) {
			
			int index = sSB.indexOf("#");
			
			if (index == 0) {
				sSB.deleteCharAt(index);
			} else {
				sSB.deleteCharAt(index);
				sSB.deleteCharAt(--index);
			}
		}

		return sSB.toString();
	}
	
	public static boolean backspaceCompare(String s, String t) {
		
		s = removeHashes(s);
		t = removeHashes(t);
		
		if (s.equals(t)) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		String s = "a##c";
		String t = "#a#c";
		
		System.out.println(backspaceCompare(s, t));
		
	}

}
