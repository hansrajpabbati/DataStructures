package Q_378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import java.util.PriorityQueue;

//Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
//Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//Example:
//
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//return 13.
//Note:
//You may assume k is always valid, 1 ≤ k ≤ n2.

public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		
		PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(b-a)); 
		for(int i=0 ; i< matrix.length ;i++) {
			for(int j=0 ;j < matrix[0].length;j++) {
				q.add(matrix[i][j]);
				if(q.size() > k) {
					q.poll();
				}
			}
		}
		return q.poll();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{ 1,  5,  9},
									{10, 11, 13},
									{12, 13, 15}};
		Solution s = new Solution();
		System.out.println(s.kthSmallest(matrix, 10));

	}



}
