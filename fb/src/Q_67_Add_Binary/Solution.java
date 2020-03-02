package Q_67_Add_Binary;

//Given two binary strings, return their sum (also a binary string).
//
//The input strings are both non-empty and contains only characters 1 or 0.
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"

public class Solution {

	public String addBinary(String a, String b) {
		int ia = a.length()-1;
		int ib = b.length()-1;
		char c = '0';
		StringBuilder sb = new StringBuilder();
		
		while(ia>-1 || ib > -1 || c == '1') {
			
			char ia_val = '0';
			char ib_val = '0';
			
			if(ia > -1) {
				ia_val = a.charAt(ia--);
			}
			if(ib > -1) {
				ib_val = b.charAt(ib--);
			}
			
			int numberOfOnes=0;
			
			if(ia_val =='1') {numberOfOnes++;}
			if(ib_val =='1') {numberOfOnes++;}
			if(c =='1') {numberOfOnes++;}
			
			
			if(numberOfOnes==3) {
				sb.insert(0,'1');
				c = '1';
				
			}else if(numberOfOnes ==2) {
				sb.insert(0, '0');
				c ='1';
			}else if(numberOfOnes ==1) {
				sb.insert(0, '1');
				c='0';
			}else {
				sb.insert(0, '0');
				c='0';
			}
		}
		
		
		
		return sb.toString();        
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1010";
		String b = "1011";

		Solution s = new Solution();
		System.out.println(s.addBinary(a, b));
		
	}

}
