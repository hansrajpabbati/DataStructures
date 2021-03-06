package CoinChange_2_DP_518;



//518. Coin Change 2
//You are given coins of different denominations and a total amount of money.
//Write a function to compute the number of combinations that make up that amount. 
//You may assume that you have infinite number of each kind of coin.
//
//
//
//Example 1:
//
//Input: amount = 5, coins = [1, 2, 5]
//Output: 4
//Explanation: there are four ways to make up the amount:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
//Example 2:
//
//Input: amount = 3, coins = [2]
//Output: 0
//Explanation: the amount of 3 cannot be made up just with coins of 2.
//Example 3:
//
//Input: amount = 10, coins = [10] 
//Output: 1


//Time Complexity  : O(m*n)
//Space Complexity : O(m*n)

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins = {1,2,5};
		int amount = 5;

		System.out.println(change(amount, coins));

		
	}
	public static int change(int amount, int[] coins) {
		
		
		int [][]dp = new int[coins.length +1][amount + 1];
		
		for(int i =0 ; i< dp.length ; i++)
		{
			dp[i][0] = 1;
		}
		
		for(int i=1 ; i < dp[0].length ; i++)
		{
			dp[0][i] =0;  
		}
		 
		for(int i =1 ; i < dp.length;i++)
		{
			for(int j=1 ; j < dp[0].length ;j++)
			{
				
				if(j < coins[i-1])
				{
					dp[i][j] = dp[i-1][j];
				}else
				{
					dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
				}
				
				
			}
		}
		 return dp[dp.length-1][dp[0].length-1];
	}
	

}


//System.out.println("Case 1 values  " + "amount " + amount + " index " + index + " mincoins " + minCoins);
//System.out.println("Case 2 values  " + "amount " + amount + " index " + index + " mincoins " + minCoins);

