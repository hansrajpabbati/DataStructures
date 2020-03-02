package Q_266_Palindrome_Permutation;

import java.util.HashSet;

//Given a string, determine if a permutation of the string could form a palindrome.
//
//Example 1:
//
//Input: "code"
//Output: false
//Example 2:
//
//Input: "aab"
//Output: true
//Example 3:
//
//Input: "carerac"
//Output: true


public class Solution {

	public boolean canPermutePalindrome(String s) {
		HashSet<Character> set = new HashSet<>();
//		for(int i=0;i<s.length();i++) {}
		for(Character c : s.toCharArray()) {
			if(!set.contains(c)) {
				set.add(c);
			}else {
				set.remove(c);
			}
		}
		if(set.size() <= 1) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pali = "carerac";
		Solution s = new Solution();
		System.out.println(s.canPermutePalindrome(pali));

		
	}

}
