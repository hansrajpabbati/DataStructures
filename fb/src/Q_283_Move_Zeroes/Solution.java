package Q_283_Move_Zeroes;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Example:
//
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Note:
//
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.

public class Solution {
	int[] input = {0,1,0,3,12};
	public void moveZeroes(int[] nums) {
		int index =0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] !=0) {
				nums[index] = nums[i];
				index++;
			}
		}
		while(index != nums.length) {
			nums[index] =0;
			index++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		s.moveZeroes(s.input);
		for(int i : s.input) {
			System.out.print(i + " ");
		}
//		System.out.println(s.input[2]);

	}
	
//	public void moveZeroes(int[] nums) {
//		// Arrays.sort(nums);
//		int[] ans = new int[nums.length];
//		int count =0;
//		int index =0;
//		for(int i=0;i<nums.length;i++){
//			if(nums[i] == 0){
//				count++;
//			}
//			else {
//				ans[index] = nums[i]; 
//				index++;
//			}
//		}
//
//		while(nums.length != ans.length){
//			ans[index] =0;
//			index++;
//		}
//
//		for(int i=0;i<nums.length;i++){
//			nums[i] = ans[i];
//		}
//	}

}
