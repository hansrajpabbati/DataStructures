package Q_460_LFU_Cache;

import java.util.HashMap;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//The cache is initialized with a positive capacity.
//
//Follow up:
//Could you do both operations in O(1) time complexity?
//
//Example:
//
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */





public class LFUCache {

	int capacity;
	HashMap<Integer, Node> map;
	HashMap<Integer,Node> rankMap;

	public class Node{
		public int key;
		public int value;
		public int freq;
		public int rank;


		public Node(){

		}

		public Node(int key, int value, int freq,int rank) {
			this.key = key;
			this.value = value;
			this.freq = freq;
			this.rank = rank;
		}
	}


	public LFUCache(int capacity) {
		map = new HashMap<>();
		rankMap = new HashMap<>();
		//		if()
		this.capacity = capacity;

	}

	public int get(int key) {
		if(map.containsKey(key) && capacity >0)
		{
			Node n = map.get(key);
			n.freq += 1;
			updateRankMap(n);
			//			deQueue.putAthead(n);
			return n.value;
		}

		return -1;

	}

	public void put(int key, int value) {
		int currRank = map.size()+1;
		Node node = new Node(key, value,1,currRank);
		if(capacity > 0)
		{
			if(map.size() < capacity)
			{
				if(!map.containsKey(key))
				{
					map.put(key, node);
					//			deQueue.insert(node);
					updateRankMap(node);
				}else
				{
					Node n = map.get(key);
					n.freq += 1;
					n.value = value;
					updateRankMap(n);
				}
			}else
			{
				if(!map.containsKey(key))
				{
					Node lastNode = rankMap.get(capacity);
					int LastKey = lastNode.key;
					map.remove(LastKey);
					rankMap.remove(capacity);

					node.rank -=1;
					map.put(key, node);
					updateRankMap(node);
				}else
				{
					Node n = map.get(key);
					n.freq += 1;
					n.value = value;
					updateRankMap(n);
				}
			}
		}



	}

	public void updateRankMap(Node node) {
		if(node.rank > 1)
		{
			Node prevNode = rankMap.get(node.rank-1);
			if(prevNode.freq > node.freq)
			{
				rankMap.put(node.rank, node);
			}
			else{
				int currRank = node.rank;
				prevNode.rank = currRank;
				node.rank = currRank-1;
				rankMap.put(currRank, prevNode);
				rankMap.put(currRank-1, node);
			}
		}else if(node.rank ==1)
		{
			rankMap.put(node.rank, node);
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		LFUCache cache = new LFUCache(2);
		//		cache.put(1, 1);
		//		cache.put(2, 2);
		//		System.out.println(cache.get(1));       // returns 1
		//		cache.put(3, 3);    // evicts key 2
		//		System.out.println(cache.get(2));      // returns -1 (not found)
		//		cache.put(4, 4);    // evicts key 1
		//		System.out.println(cache.get(1));       // returns -1 (not found)
		//		System.out.println(cache.get(3));       // returns 3
		//		System.out.println(cache.get(4)); 

		LFUCache cache = new LFUCache(3);
		cache.put(1, 1);
		cache.put(2, 2);
		//		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		//		System.out.println(cache.get(2));      // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.put(5, 5);    // evicts key 1
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));


		//		LFUCache cache = new LFUCache( 2 /* capacity */ );
		//
		//		cache.put(1, 1);
		//		cache.put(2, 2);
		//		cache.get(1);       // returns 1
		//		cache.put(3, 3);    // evicts key 2
		//		cache.get(2);       // returns -1 (not found)
		//		cache.get(3);       // returns 3.
		//		cache.put(4, 4);    // evicts key 1.
		//		cache.get(1);       // returns -1 (not found)
		//		cache.get(3);       // returns 3
		//		cache.get(4);       // returns 4

	}

//	["LFUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
//			[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]

}
