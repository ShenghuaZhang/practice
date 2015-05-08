package tree.trie;

/**
 * 207 https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * Note:You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author carllee1991
 *
 */
class TrieNode {
	boolean valid;
	TrieNode[] children;

	// Initialize your data structure here.
	public TrieNode() {
		valid = false;
		children = new TrieNode['z' - 'a' + 1];
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new TrieNode();
			current = current.children[c - 'a'];
		}
		current.valid = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				return false;
			current = current.children[c - 'a'];
		}
		return current.valid;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (char c : prefix.toCharArray()) {
			if (current.children[c - 'a'] == null)
				return false;
			current = current.children[c - 'a'];
		}
		return true;
	}
	
	public static void main(String[] args){
		Trie tt = new Trie();
		tt.insert("something");
		System.out.println("test for search: "+tt.search("some"));
		System.out.println("test for search: "+tt.search("something"));
		System.out.println("test for search: "+tt.startsWith("some"));
	}
}