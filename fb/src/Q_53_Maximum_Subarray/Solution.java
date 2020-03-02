package Q_53_Maximum_Subarray;
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//Example:
//
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//Follow up:
//
//If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

public class Solution {

	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		int max = nums[0];
		int runMax = nums[0];
		dp[0] = nums[0];
		for(int i=1;i<nums.length;i++) {
//			dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
//			max = Math.max(max, dp[i]);
			runMax = Math.max(nums[i], nums[i] + runMax);
//			System.out.println(runMax);
			max = Math.max(max, runMax);
		}


		return max;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		Solution s = new  Solution();
		System.out.println(s.maxSubArray(arr));
	}

}
