package Q_238_Product_of_Array_Except_Self;


//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Example:
//
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
//Note: Please solve it without division and in O(n).
//
//Follow up:
//Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

public class Solution {

	public int[] productExceptSelf(int[] nums) {
		
		
		int[] ans = new int[nums.length];
//		int[] fp = new int[nums.length];
//		int[] bp = new int[nums.length];
		
		if(nums == null || nums.length ==0) {
			return ans;
		}
		int temp =1;
		int rp =1;
		
		for(int i=0;i<nums.length;i++) {
			rp = temp*rp;
			ans[i] = rp;
			temp = nums[i];
		}
		temp=1;
		rp=1;
		
		for(int i = nums.length-1;i>=0;i--) {
			rp = temp*rp;
			ans[i] = rp*ans[i];
			temp = nums[i];
		}
		
		return ans;       
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		Solution s = new Solution();
		int[] ans = s.productExceptSelf(nums);
		for(int a:ans) {
			System.out.println(a);
		}
		
//		System.out.println(s.productExceptSelf(nums));

	}

}
//public int[] productExceptSelf(int[] nums) {
//	
//	
//	int[] ans = new int[nums.length];
//	int[] fp = new int[nums.length];
//	int[] bp = new int[nums.length];
//	
//	if(nums == null || nums.length ==0) {
//		return ans;
//	}
//	int temp =1;
//	int rp =1;
//	
//	for(int i=0;i<nums.length;i++) {
//		rp = temp*rp;
//		fp[i] = rp;
//		temp = nums[i];
//	}
//	temp=1;
//	rp=1;
//	
//	for(int i = nums.length-1;i>=0;i--) {
//		rp = temp*rp;
//		bp[i] = rp;
//		temp = nums[i];
//	}
//	
//	for(int i=0;i<nums.length;i++) {
//		ans[i] = fp[i]*bp[i];
//	}
//	
//	
//	
//	
//	return ans;       
//}
