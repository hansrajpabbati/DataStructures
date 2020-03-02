package Q_118_PascalsTriangle;
//Mock Interview 01/12/2020
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(staticpascalTriangle(10));
	}

public static List<List<Integer>> staticpascalTriangle(int num)
{
	List<List<Integer>> ans = new ArrayList<>();
    if(num <=0)
    {
    	return ans;
    }
    for(int i=0 ; i< num ;i++)
    {
        List<Integer> temp = new ArrayList<>();
        
        if(i ==0)
        {
            temp.add(1);
            ans.add(temp);
        }else{
            List<Integer> t1 = new ArrayList<>();
            t1 = ans.get(i-1);
            
            for(int j =0 ; j <= t1.size() ; j++)
            {
                if(j ==0)
                {
                temp.add(t1.get(j));
                }else if(j > 0 && j < t1.size() )
                {
                   temp.add(t1.get(j-1) + t1.get(j));
                }else if(j == t1.size()){
                    temp.add(t1.get(j-1));
                }
                
            }
            ans.add(temp);
            
        }
        
        
    }
    return ans;
    
}


}
