package Q_1004_Max_Consecutive_Ones_III;

//Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
//
//Return the length of the longest (contiguous) subarray that contains only 1s. 
//
// 
//
//Example 1:
//
//Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//Output: 6
//Explanation: 
//[1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
//Example 2:
//
//Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//Output: 10
//Explanation: 
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
// 
//
//Note:
//
//1 <= A.length <= 20000
//0 <= K <= A.length
//A[i] is 0 or 1 

public class Solution {

	public int longestOnes(int[] A, int K) {
		
		int x=0,y=0;
		int max=0;
		
		while(y< A.length) {
			if(A[y] == 1) {
				y++;
				max = Math.max(max,y-x);
			}else {
				if(K >0) {
					K--;
					y++;
					max = Math.max(max, y-x);
				}else
				{
					if(A[x] ==0) {
						K++;
					}
					x++;
//					max = Math.min(max, y-x);
				}
			}
		}
		
		return max;  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int K = 3;
		Solution s= new Solution();
		System.out.println(s.longestOnes(A, K));
	}

}
