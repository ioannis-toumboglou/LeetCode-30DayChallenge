// Given an array of strings, group anagrams together.

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day06_GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, List<String>> map = new HashMap<>();
		
		for (int i=0; i<strs.length; i++) {
			String word = strs[i];
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String newWord = new String(letters);
			
			if (map.containsKey(newWord)) {
				map.get(newWord).add(word);
			} else {
				List<String> words = new ArrayList<>();
				words.add(word);
				map.put(newWord, words);
			}
		}
		
		List<List<String>> anagrams = new ArrayList<>();
		
		for (String s : map.keySet()) {
			List<String> values = map.get(s);
			anagrams.add(values);
		}
		
		return anagrams;
	}

	public static void main(String[] args) {
		
		String[] strs = {"cat", "dog", "tac", "god", "act"};
		
		System.out.println(groupAnagrams(strs));

	}

}
