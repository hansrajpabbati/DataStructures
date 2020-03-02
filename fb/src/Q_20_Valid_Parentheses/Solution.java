package Q_20_Valid_Parentheses;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.
//
//Example 1:
//
//Input: "()"
//Output: true
//Example 2:
//
//Input: "()[]{}"
//Output: true
//Example 3:
//
//Input: "(]"
//Output: false
//Example 4:
//
//Input: "([)]"
//Output: false
//Example 5:
//
//Input: "{[]}"
//Output: true


public class Solution {
	HashMap<Character, Character> map = new HashMap<>();
	
	public HashMap<Character, Character> createMap(){
		String open = "{[(";
		String close ="}])";
		for(int i=0;i<open.length();i++) {
			map.put(close.charAt(i), open.charAt(i));
		}
		return map;
	}
	
	public boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		for(int i=0;i<s.length();i++) {
			Character c = s.charAt(i);
			if(c == '{' || c == '[' || c=='(' ) {
				st.push(c);
			}else {
//				Character openbr= map.get(c);
				if(st.isEmpty() || st.pop() != map.get(c)) {
					return false;
				}
			}
		}
		return st.isEmpty();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "([]})";
		String str = "[";
		Solution s = new Solution();
		s.createMap();
		System.out.println(s.isValid(str));

	}

}
