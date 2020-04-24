/* Design and implement a data structure for Least Recently Used (LRU) cache. It should support the 
   following operations: get and put.

   get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
   otherwise return -1.
   
   put(key, value) - Set or insert the value if the key is not already present. When the cache reached 
   its capacity, it should invalidate the least recently used item before inserting a new item.

   The cache is initialized with a positive capacity.

   Follow up:
   Could you do both operations in O(1) time complexity? 
*/

package LeetCode;

import java.util.HashMap;

public class Day24_LRUCache {
	
	private int size;
    private int limit;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    
    public Day24_LRUCache(int capacity) {
    	
        limit = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            addFirst(head, n);
            
            return n.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            remove(n);
            addFirst(head, n);
            
            return;
        }
        
        Node node = new Node(key, value);
        
        if (limit == 0) {
        	return;
        }
        
        addFirst(head, node);
        
        if (size < limit) {
            ++size;
        } else {
            removeLast(tail, map);
        }
        
        map.put(key, node);
    }
    
    public void addFirst(Node head, Node node) {
    	
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    
    }

    public void removeLast(Node tail, HashMap<Integer, Node> map) {
    	
        Node prev = tail.prev;
        Node prepre = prev.prev;
        prev.next = null;
        prev.prev = null;
        prepre.next = tail;
        tail.prev = prepre;
        map.remove(prev.key);
        
    }

    public void remove(Node node) {
    	
        Node prev = node.prev;
        Node next = node.next;
        node.prev = null;
        node.next = null;
        prev.next = next;
        next.prev = prev;
        
    }
    
    class Node {
    	
        int key;
        int val;
        Node next;
        Node prev;
        
        public Node(int k, int v) { 
        	
        	key = k; 
        	val = v; 
        	next = null; 
        }

    }
	
	public static void main(String[] args) {
		
		Day24_LRUCache cache = new Day24_LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
		
	}
}