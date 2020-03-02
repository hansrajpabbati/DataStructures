package Q_28_Implement_strStr;

//Implement strStr().
//
//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//Example 1:
//
//Input: haystack = "hello", needle = "ll"
//Output: 2
//Example 2:
//
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
//Clarification:
//
//What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

public class Solution {

	 public int strStr(String haystack, String needle) {
		int m = haystack.length();
		int n = needle.length();
		
		if(n==0) {
			return 0;
		}
		
		int i=0;
		
		while(i<m) {
			int j=0;
			if(haystack.charAt(i) == needle.charAt(j)) {
				int temp = i;
				while(temp < m && j<n) {
					if(haystack.charAt(temp)!= needle.charAt(j)) {
						break;
					}
					temp++;
					j++;
				}
				if(j == n) {
					return i;
				}
				
			}
			i++;
			
			
		}
		
		 
	     return -1;   
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "hello";
		String needle = "ll";
		Solution s = new Solution();
		System.out.println(s.strStr(haystack, needle));

	}

}


//public int strStr(String haystack, String needle) {
//	 
//	 if(haystack.contains(needle)) {
//		 return haystack.indexOf(needle);
//	 }
//	 
//    return -1;   
//   }
