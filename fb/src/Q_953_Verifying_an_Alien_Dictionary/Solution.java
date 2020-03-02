package Q_953_Verifying_an_Alien_Dictionary;

import java.util.HashMap;

//In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//
//Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
//
// 
//
//Example 1:
//
//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//Example 2:
//
//Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//Output: false
//Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
//Example 3:
//
//Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//Output: false
//Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
// 
//
//Constraints:
//
//1 <= words.length <= 100
//1 <= words[i].length <= 20
//order.length == 26
//All characters in words[i] and order are English lowercase letters.

public class Solution {
	HashMap<Character, Integer> map;
	public boolean isAlienSorted(String[] words, String order) {
		map = new HashMap<>();
		for(int i=0;i<order.length();i++) {
			if(!map.containsKey(order.charAt(i))) {
				map.put(order.charAt(i), i);
			}
		}
		
		for(int i=0;i< words.length - 1;i++) {
			if(!compare(words[i], words[i+1])) {
				return false;
			}
		}
	
		
		
		
		return true;

	}
	
	public boolean compare(String s1, String s2) {
		int l1=s1.length();
		int l2 = s2.length();
		
		
		for(int i=0,j=0;i<l1 && j < l2; i++,j++) {
			char c1= s1.charAt(i);
			char c2= s2.charAt(j);
			if(c1 != c2) {
				if(map.get(c1) > map.get(c2)) {
					return false;
				}else {
					return true;
				}
			}
			
			
		}
		if(l1>l2) {
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(s.isAlienSorted(words, order));

	}

}
