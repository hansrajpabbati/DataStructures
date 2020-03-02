package Q_49_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an array of strings, group anagrams together.
//
//Example:
//
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//Note:
//
//All inputs will be in lowercase.
//The order of your output does not matter.

public class Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String,List<String>> map = new HashMap<>();
		List<List<String>> ans = new ArrayList<List<String>>();

		for(int i=0;i<strs.length;i++) {
			char[] str = strs[i].toCharArray();
			Arrays.sort(str);
			String temp = new String(str);
//			System.out.println(temp);
			if(!map.containsKey(temp)) {
				map.put(temp, new ArrayList<String>());
			}
			if(map.containsKey(temp)) {
				map.get(temp).add(strs[i]);
			}
		}
		
		for(Map.Entry<String, List<String>> m: map.entrySet()) {
			List<String> tmp = m.getValue();
			Collections.sort(tmp);
			ans.add(tmp);
		}


		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ana = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Solution s = new Solution();
		System.out.println(s.groupAnagrams(ana));

	}

}
