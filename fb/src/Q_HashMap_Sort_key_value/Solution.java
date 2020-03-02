package Q_HashMap_Sort_key_value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	public class map{
		int key;
		String val;
		public map() {
		}
		public map(int x, String y) {
			this.key =x;
			this.val =y;
		}
	}

	public HashMap<Integer, String> sortKeys(HashMap<Integer, String> m){
		PriorityQueue<map> p = new PriorityQueue<>((a,b)->Integer.compare(a.key,b.key));
		//		PriorityQueue<map> p = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
		HashMap<Integer, String> ans = new HashMap<>();

		for(Map.Entry<Integer, String> mKey : m.entrySet()) {
			map name = new map(mKey.getKey(),mKey.getValue());
			p.add(name);
		}

		while(p.size() > 0) {
			map n = p.poll();
			ans.put(n.key, n.val);
		}

		return ans;
	}

	public Map<Integer, String> sortValues(HashMap<Integer, String> m){
		Map<Integer, String> ans2 = new HashMap<>();
		List<map> temp = new ArrayList<>();

		for(Map.Entry<Integer, String> mKey : m.entrySet()) {
			map name = new map(mKey.getKey(),mKey.getValue());
			temp.add(name);
		}

		Collections.sort(temp, new Comparator<map>() {
			@Override
			public int compare(map o1, map o2) {
				// TODO Auto-generated method stub
				return o2.val.compareTo(o1.val);
			}
		});

		for(int i=0;i<temp.size();i++) {
			ans2.put(temp.get(i).key, temp.get(i).val);
		}		

		return ans2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Solution s = new Solution();
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "hello");
		map.put(3, "abcd");
		map.put(5, "aabcdd");
		map.put(4, "pqrs");
		map.put(2, "za");
//		HashMap<Integer , String> ans = s.sortKeys(map);
//
//		for(Map.Entry<Integer, String> mKey : ans.entrySet()) {
//			System.out.println("key "+ mKey.getKey() + " value " +mKey.getValue() );
//		}



		Map<Integer , String> ans1 = s.sortValues(map);

		for(Map.Entry<Integer, String> mKey : ans1.entrySet()) {
			System.out.println("key "+ mKey.getKey() + " value " +mKey.getValue() );
		}

	}

}
