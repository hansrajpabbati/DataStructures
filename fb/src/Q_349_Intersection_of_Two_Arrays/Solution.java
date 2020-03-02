package Q_349_Intersection_of_Two_Arrays;

import java.util.HashSet;

//Given two arrays, write a function to compute their intersection.
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Note:
//
//Each element in the result must be unique.
//The result can be in any order.

public class Solution {

	 public int[] intersection(int[] nums1, int[] nums2) {
		 HashSet<Integer> set = new HashSet<>();
		 HashSet<Integer> ansSet = new HashSet<>();
		 
		 int i=0;
		 
		 if(nums1.length > nums2.length) {
			 while(i<nums1.length) {
					set.add(nums1[i]);
					i++;
				}
		 }else {
			 while(i<nums2.length) {
					set.add(nums2[i]);
					i++;
				}
		 }
		 
		 
		 i=0;

		 if(nums1.length > nums2.length) {
			while(i<nums2.length) {
				if(set.contains(nums2[i])) {
					ansSet.add(nums2[i]);
				}
				i++;
			} 
		 }else {
			 while(i<nums1.length) {
					if(set.contains(nums1[i])) {
						ansSet.add(nums1[i]);
					}
					i++;
		 }
		 }
		 
		 
		
		
		i=0;
		int[] ans = new int[ansSet.size()];
		for(Integer val : ansSet) {
			ans[i] = val;
			i++;
		}
		 
		 
		 
	     return ans;   
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		Solution s = new Solution();
		int[] ans = s.intersection(nums1, nums2);
		int i=0;
		while(i<ans.length)
		{
			System.out.println(ans[i]);
			i++;
		}
			

	}

}
