package r1;

import java.util.Stack;

//import com.sun.tools.classfile.StackMap_attribute.stack_map_frame;

public class Solution {

	
//	static long swapCount(String s) 
//	{ 
//		char[] chars = s.toCharArray(); 
//		
//		// stores total number of Left and Right 
//		// brackets encountered 
//		int countLeft = 0, countRight = 0; 
//				// swap stores the number of swaps required 
//		//imbalance maintains the number of imbalance pair 
//		int swap = 0 , imbalance = 0; 
//		
//		for(int i =0; i< chars.length; i++) 
//		{ 
//			if(chars[i] == '[') 
//			{ 
//				// increment count of Left bracket 
//				countLeft++; 
//				if(imbalance > 0) 
//				{ 
//					// swaps count is last swap count + total 
//					// number imbalanced brackets 
//					swap += imbalance; 
//					// imbalance decremented by 1 as it solved 
//					// only one imbalance of Left and Right 
//					imbalance--;	 
//				} 
//			} else if(chars[i] == ']' ) 
//			{ 
//				// increment count of Right bracket 
//				countRight++; 
//				// imbalance is reset to current difference 
//				// between Left and Right brackets 
//				imbalance = (countRight-countLeft); 
//			} 
//		} 
//		return swap; 
//	} 


	static long swapCount(String s) 
	{ 
//		char[] chars = s.toCharArray(); 
		Stack<Character> st = new Stack<>();
		// stores total number of Left and Right 
		// brackets encountered 
//		int countLeft = 0, countRight = 0; 
				// swap stores the number of swaps required 
		//imbalance maintains the number of imbalance pair 
		int swap = 0 , imbalance = 0; 
		
		int ans = helper(s, 0, swap ,st);
		
		
		return ans; 
	} 
	
	public static int helper (String S , int i , int count, Stack<Character> st)
	{
		int len = S.length();
		while(len >0)
		{
			if(S.charAt(i) == '[')
			{
				st.add(S.charAt(i));
				count++;
			}else
			{
				st.pop();
				count--;
			}
			len--;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[]][]["; 
		System.out.println(swapCount(s) ); 

		s = "[[][]]"; 
		System.out.println(swapCount(s) ); 
		

	}

}
