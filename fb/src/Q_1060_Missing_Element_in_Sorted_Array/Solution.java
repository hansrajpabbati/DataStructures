package Q_1060_Missing_Element_in_Sorted_Array;

//Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
//
//
//
//Example 1:
//
//Input: A = [4,7,9,10], K = 1
//Output: 5
//Explanation: 
//The first missing number is 5.
//Example 2:
//
//Input: A = [4,7,9,10], K = 3
//Output: 8
//Explanation: 
//The missing numbers are [5,6,8,...], hence the third missing number is 8.
//Example 3:
//
//Input: A = [1,2,4], K = 3
//Output: 6
//Explanation: 
//The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
// 
//
//Note:
//
//1 <= A.length <= 50000
//1 <= A[i] <= 1e7
//1 <= K <= 1e8

public class Solution {

	public int missingElement(int[] nums, int k) {
		
		for(int i=1;i<nums.length;i++) {
			int diff = nums[i] - nums[i-1]-1;
			if(diff< k) {
				k = k-diff;
			}else {
				return nums[i-1]+ k;
			}
		}
		
		return nums[nums.length-1] + k;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,4};
//		int[] nums = {4,7,9,10};
		int k = 3;
		Solution s = new Solution();
		System.out.println(s.missingElement(nums, k));

	}

}





//public int missingElement(int[] nums, int k) {
//	int[] miss = new int[k];
//	int pos=0;
//	int valIndex=nums[0];
//	
//	for(int i=0;i<nums.length;) {
//		if(nums[i] != valIndex) {
//			if(miss.length ==k && miss[k-1] !=0) {
//				return miss[k-1];
//			}
//			miss[pos] = valIndex;
//			valIndex++;
//			pos++;
//		}else
//		{
//			i++;
//			valIndex++;
//		}
//	}
//	
//	if(pos < k) {
//		return nums[nums.length-1] + (k-pos);
//	}
//	
////	for(int j=pos;j<miss.length;j++) {
////		miss[j] = valIndex++;
////	}
//	
////	return nums[nums.length-1] + (k-pos);
//	
//	return miss[k-1];
//
//}