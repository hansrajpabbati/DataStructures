package rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	static private int gcd(int a , int b)
	{
		if(b==0)
		{
			return a;
		}
		else
		{
			return gcd(b, a%b); 
		}
	}
	
	static int[] connectedCIties(int n, int g,int[] origincities, int[] destinationCities ) {
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for(int i =1; i<=n ; i++)
		{
			for(int j =1 ; j<=n;j++)
			{
				if(i==j ) continue;
				int gcd = gcd(i,j);
				if(gcd > g)
				{
					if(!map.containsKey(i))
					{
						map.put(i	, new ArrayList<>());
					}
					map.get(i).add(j);
				}
			}
		}
		int [] result = new int[origincities.length];
		for(int i=0 ; i< origincities.length;i++)
		{
			int origin = origincities[i];
			int dest = destinationCities[i];
			Queue<Integer> q = new LinkedList<Integer>();
			boolean[] visited = new boolean[n+1];
			q.add(origin);
			visited[origin] = true;
			while(!q.isEmpty())
			{
				int curr = q.poll();
				if(curr == dest)
				{
					result[i] =1;
					break;
				}
				List<Integer> edges = map.get(curr);
				if(edges!=null)
				{
					for(int edge : edges)
					{
						if(!visited[edge])
						{
							q.add(edge);
							visited[edge] = true;
						}
					}
				}
			}
		}
		
		return result;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "[]][]["; 
	}

}
