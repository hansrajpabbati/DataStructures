package abcd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> products = new ArrayList<String>();
		products.add("eggs");
		products.add("milk");
		products.add("cheese");
		List<String> productsSold = new ArrayList<String>();
		productsSold.add("eggs");
		productsSold.add("eggs");
		productsSold.add("cheese");
		productsSold.add("milk");
		
		List<Float> productPrices = new ArrayList<Float>();
		productPrices.add((float) 2.89);
		productPrices.add((float) 3.29);
		productPrices.add((float) 5.79);
		
		List<Float> soldPrice = new ArrayList<Float>();
		soldPrice.add((float) 2.89);
		soldPrice.add((float) 2.99);
		soldPrice.add((float) 5.79);
		soldPrice.add((float) 3.29);

		int ans = priceCheck(products, productPrices, productsSold, soldPrice);
		System.out.println(ans);
	}

	
	public static int priceCheck(List<String> products , List<Float> productPrices, 
			List<String> productsSold, List<Float> soldPrice) {
		
			int count =0;
		
			HashMap<String, Float> actual = new HashMap<String, Float>();
			
			for(int i=0; i<products.size();i++)
			{
				actual.put(products.get(i), productPrices.get(i));
			}
		
//			HashMap<String, Float> sell = new HashMap<String, Float>();
			
//			for(int i=0; i<productsSold.size();i++)
//			{
//				sell.put(productsSold.get(i), productsSold.get(i));
//			}
			
			for(int i=0; i < productsSold.size();i++)
			{
			 String key = productsSold.get(i); 
			 float value = actual.get(key);
			 
			 if(value != soldPrice.get(i))
			 {
				 count++;
			 }
				
			}
		
		
		return count;
	}
}
