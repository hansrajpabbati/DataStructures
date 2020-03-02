package CoinChange_BruteForce_322;



//322. Coin Change
//You are given coins of different denominations and a total amount of money amount.
//Write a function to compute the fewest number of coins that you need to make up that amount. 
//If that amount of money cannot be made up by any combination of the coins, return -1.
//		
//		Example 1:
//			Input: coins = [1, 2, 5], amount = 11
//			Output: 3 
//			Explanation: 11 = 5 + 5 + 1
//
//		Example 2:
//
//			Input: coins = [2], amount = 3
//			Output: -1



//Time Complexity  : Exponential = 2^n
//Space Complexity : constant    = O(1)

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] coins = {1,2,5};
		int amount = 11;
		
		System.out.println(coinChange(coins,amount));

	}
	public static int coinChange(int[] coins, int amount) {
		int min = helperCoin(coins, amount, 0, 0);
		
		return min;

	}
	
	private static int helperCoin(int[] coins, int amount , int index, int minCoins)
	{
		//Base Case
		if(coins.length <= 0 || index  >= coins.length || amount < 0)
		{
			return -1;
		}
		
		if(amount == 0)
		{
			return minCoins;
		}
		
		
		//logic
		int case1 = helperCoin(coins, amount, index+1, minCoins);
		int case2 = helperCoin(coins, amount - coins[index], index, minCoins+1);
		System.out.println("Case 1 is " + case1 + "case2 is " + case2);

		if(case1 == -1)
		{
			return case2;
		}else if(case2 ==-1)
		{
			return case1;
		}
		
		
		return Math.min(case1, case2);
	}

}


//System.out.println("Case 1 values  " + "amount " + amount + " index " + index + " mincoins " + minCoins);
//System.out.println("Case 2 values  " + "amount " + amount + " index " + index + " mincoins " + minCoins);

