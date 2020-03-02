package Q_460_LFU_Cache_1;

import java.util.HashMap;

import Q_146_LRU_Cache.LRUCache.Node;

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
	HashMap<Integer,Node> freqMap;
	DeQueue deQueue;

	public class Node{
		public int key;
		public int value;
		public int freq;
		public Node next;
		public Node prev;


		public Node(){

		}
		
		public Node(int key, int value, int freq) {
			this.key = key;
			this.value = value;
			this.freq = freq;
		}
	}

	
	public class DeQueue{
		Node head;
		Node tail; 
		
		public DeQueue() {
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
		}
		
		
		public void insert(Node node)
		{
			node.next = head.next;
			node.prev = head;
			head.next.prev = node;
			head.next = node;
		}
		
		public void insertAtTail(Node node)
		{
			node.next = tail;
			node.prev = tail.prev;
			tail.prev.next = node;
			tail.prev = node;
		}
		
		public void delete(Node node)
		{
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
		
		public Node getLastNode()
		{
			return tail.prev;
		}
		
		public void putAtHead(Node node, Node headNode) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			
			node.next = headNode;
			node.prev = headNode.prev;
			headNode.prev.next = node;
			headNode.prev = node;
			
		}
		
	}
	

	public LFUCache(int capacity) {
		map = new HashMap<>();
		freqMap = new HashMap<>();
		deQueue = new DeQueue();
		//		if()
		this.capacity = capacity;

	}

	public int get(int key) {
		if(map.containsKey(key) && capacity >0)
		{
			Node n = map.get(key);
			n.freq += 1;
			updateFreqMap(n);
//			deQueue.putAthead(n);
			return n.value;
		}

		return -1;

	}

	public void put(int key, int value) {
		
		int currFreq = 1;
		Node node = new Node(key, value, currFreq);
		
		if(map.containsKey(key)) {
			Node n = map.get(key);
			n.freq += 1;
			n.value = value;
//			map.put(key, n);
			updateFreqMap(node);
			return;
		}
		if(map.size() < capacity)
		{
			map.put(key, node);
			deQueue.insertAtTail(node);
			if(!freqMap.containsKey(currFreq)) {
				freqMap.put(currFreq, node);
			}else
			{
				Node headNode = freqMap.get(currFreq);
				deQueue.putAtHead(node, headNode);
				freqMap.put(currFreq, node);
			}
		}else
		{
			Node lastNode = deQueue.getLastNode();
			int oldFreq = lastNode.freq;
			Node oldNode = freqMap.get(oldFreq);
			if(oldNode == lastNode)
			{
				if(oldNode.next != deQueue.tail && oldNode.next.freq == oldFreq)
				{
					freqMap.put(oldFreq, oldNode.next);
				}else
				{
					freqMap.remove(oldFreq);
					}
			}
				
			map.remove(lastNode.key);
			deQueue.delete(lastNode);
			deQueue.insertAtTail(node);
			map.put(key, node);
			if(!freqMap.containsKey(currFreq)) {
				freqMap.put(currFreq, node);
			}else
			{
				Node headNode = freqMap.get(currFreq);
				deQueue.putAtHead(node, headNode);
				freqMap.put(currFreq, node);
			}
			
		}
		
		
	}

	public void updateFreqMap(Node node) {
		if(node == null)
		{
			return;
		}
		int oldFreq = node.freq-1;
		Node oldNode = freqMap.get(oldFreq);
		if(oldNode == node)
		{
			if(oldNode.next != deQueue.tail && oldNode.next.freq == oldFreq)
			{
				freqMap.put(oldFreq, oldNode.next);
			}else
			{
				freqMap.remove(oldFreq);
			}
		}
		
		if(freqMap.containsKey(node.freq))
		{
			deQueue.putAtHead(node, freqMap.get(node.freq));
		}else
		{
			Node prevNode = node.prev;
			if(prevNode != deQueue.head && prevNode.freq == (node.freq -1))
			{
				deQueue.putAtHead(node, freqMap.get(prevNode.freq));
			}
			freqMap.put(node.freq, node);
			
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
