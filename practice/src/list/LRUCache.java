package list;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * 
 * get(key) Get the value if the key exists in the cache, otherwise return -1.
 * 
 * set(key, value) Set or insert the value if the key is not already present. 
 * When the cache reached its capacity should invalidate the least recently
 * used item before inserting a new item
 * 
 * @author yili3
 * */
public class LRUCache {
	private class Node{
		Node next;
		Node previous;
		int key, value;
		public Node(int key, int value, Node previous, Node next){
			this.key = key;
			this.value = value;
			next = previous;
			previous = next;
		}
		public Node(int key, int value){
			this.key = key;
			this.value = value;
			next = null;
			previous = null;
		}
	}
	
	private Map<Integer, Node> map;
	private Node least, most;
	private int capacity, currentCapacity;
	
	public LRUCache(int capacity){
		this.capacity=capacity;
		currentCapacity = 0;
		least = null;
		most = null;
		map = new HashMap<Integer, Node>();
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node current = map.get(key), previousNode=current.previous, nextNode = current.next;
			if(current.equals(most))	return most.value;
			if(previousNode!=null){
				previousNode.next = nextNode;
				nextNode.previous = previousNode;
			}else{
				least = nextNode;
				nextNode.previous = null;
			}
			
			most.next = current;
			current.previous = most;
			most = current;
			return current.value;
		}
		else return -1;
	}
	public void set(int key, int value){
		if(map.containsKey(key)){
			map.get(key).value = value;
			get(key);
		}
		
		else if(capacity==1){
			map.clear();
			least = new Node(key, value);
			most = least;
			map.put(key, least);
		}
		
		else if(capacity==currentCapacity){
			map.remove(least.key);
			least = least.next;
			least.previous = null;
			Node newNode = new Node(key, value, most, null);
			most.next = newNode;
			newNode.previous = most;
			most = newNode;
			map.put(key, newNode);
		}
		
		else{
			Node newNode = new Node(key, value);
			if(least==null){
				least = newNode;
				most = newNode;
			}
			else{
				most.next = newNode;
				newNode.previous = most;
				most = newNode;
			}
			map.put(key, newNode);
			currentCapacity++;
		}
	}
	
	public static void main(String[] args){
		LRUCache cache = new LRUCache(3);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.set(5, 5);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
	}
}
