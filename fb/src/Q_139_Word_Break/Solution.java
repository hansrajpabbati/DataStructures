package Q_139_Word_Break;

import java.util.Arrays;
import java.util.List;

import Q_139_Word_Break.Solution.TrieNode;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//Note:
//
//The same word in the dictionary may be reused multiple times in the segmentation.
//You may assume the dictionary does not contain duplicate words.
//Example 1:
//
//Input: s = "leetcode", wordDict = ["leet", "code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
//Example 2:
//
//Input: s = "applepenapple", wordDict = ["apple", "pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//             Note that you are allowed to reuse a dictionary word.
//Example 3:
//
//Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output: false

public class Solution {
	
	public class TrieNode{
		char nodeName;
		TrieNode[] children = new TrieNode[26];
		boolean isWord;
		String word;
		public TrieNode() {}
		
		public TrieNode(char name) {
			this.nodeName = name;
		}
	}

	TrieNode root = new TrieNode();
	int index =0;
	
	public void insertTrie(String word) {
		TrieNode curr = root;
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] =  new TrieNode(c);
			}
			curr = curr.children[c - 'a'];
		}
		curr.isWord = true;
		curr.word = word;
	}
	
	public boolean searchTrie(String str) {
		TrieNode curr = root;
		
		while(index < str.length()) {
			boolean ans = hasword(str);
			if(!ans) {
				return false;
			}
		}
		
		
		
		return true;
	}
	
	public boolean hasword(String str) {
		TrieNode curr = root;
		for(int i=index;i<str.length() ;i++) {
			char c = str.charAt(i);
			if(curr.children[c-'a'] == null) {
				return false;
			}else if(curr.children[c-'a'] != null) {
				if(curr.children[c-'a'].isWord == true && curr.children[c-'a'].word != null  )
				{
					index++;
					return true;
				}
				curr = curr.children[c-'a'];
				index++;
			}
		}

		return false;
	} 

	public boolean wordBreak(String s, List<String> wordDict) {
		if(wordDict != null) {
			for(String word: wordDict) {
				insertTrie(word);
			}
		}
		
		boolean ans = searchTrie(s);
		System.out.println("index "+index);
		System.out.println(wordDict.size());
		
		
	
		
		return ans;   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
//		String s = "applepenapples";
//		String s = "aaaaaaa";
		List<String> wordDict = Arrays.asList("leet", "code");
//		List<String> wordDict = Arrays.asList("apple", "pen");
//		List<String> wordDict = Arrays.asList("aaaa", "aaa");
		Solution so = new Solution();
		System.out.println(so.wordBreak(s, wordDict));
//		System.out.println(wordDict.get(0));

	}

}

//String s = "aaaaaaa";
//List<String> wordDict = Arrays.asList("aaaa", "aaa");




//public class Solution {
//public boolean wordBreak(String s, Set<String> wordDict) {
//  trie dict = new trie();
//  for(String a:wordDict){
//      trie at = dict;
//      for(int i=0;i<a.length();i++){
//          if(at.branches[a.charAt(i)-'a']==null)
//              at.branches[a.charAt(i)-'a']=new trie();
//          at = at.branches[a.charAt(i)-'a'];
//      }
//      at.end=true;
//  }
// // System.out.println(dict);
//  usedStarts=new boolean[s.length()+1];
//  return recurse(s,dict,dict,0);
//}
//static boolean[]usedStarts;
//static boolean recurse(String a, trie dict, trie at, int ati){
// // System.out.println(a+" "+at+" "+ati);
//  if(at==null)
//      return false;
//  if(ati==a.length())
//      return at.end;
//  if(at.end&&!usedStarts[ati]){
//      usedStarts[ati]=true;
//      if(recurse(a,dict,dict,ati))
//          return true;
//  }
//  return recurse(a,dict,at.branches[a.charAt(ati)-'a'],ati+1);
//}
//static class trie{
//  public trie[]branches;
//  public boolean end;
//  public trie(){
//      branches=new trie[26];
//      end=false;
//  }
//  public String toString(){
//      return "["+end+" "+Arrays.toString(branches)+"]";
//  }
//}
//}

