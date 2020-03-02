package CoinChange_2_BruteForce_518;



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

//Time Complexity  : O(m + n)
//Space Complexity : O(1)

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins = {1,2,5};
		int amount = 5;

		System.out.println(coinChangeCombinationhelper(amount, coins, 0));

		
	}
	public static int change(int amount, int[] coins) {
		
		 if(coins.length == 0 && amount ==0)
         {
             return 1;
         }
		return coinChangeCombinationhelper(amount, coins, 0);

	}
	
	private static int coinChangeCombinationhelper(int amount , int[] coins , int index)
	{
		
		//Base case
		
		
		if(amount < 0 || coins.length <= 0 || index >= coins.length)
		{
			return 0;
		}
		
		if(amount == 0)
		{
			return 1;
		}
		
		
		//logic
		
		int case1 = coinChangeCombinationhelper(amount, coins, index +1); 
		int case2 = coinChangeCombinationhelper(amount - coins[index], coins, index);
		System.out.println("Case 1 is " + case1 + " case2 is " + case2);

		
		return case1+case2;
	}

}


//System.out.println("Case 1 values  " + "amount " + amount + " index " + index + " mincoins " + minCoins);
//System.out.println("Case 2 values  " + "amount " + amount + " index " + index + " mincoins " + minCoins);

