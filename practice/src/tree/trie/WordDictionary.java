package tree.trie;
/**
 * 211
 * 
 * @author carllee1991
 *
 */

class Node{
	boolean isWord;
	boolean hasChild;
	Node[] children;
	public Node(){
		isWord = false;
		children = new Node['z'-'a'+1];
	}
}

public class WordDictionary {
	Node root;
	public WordDictionary(){
		root = new Node();
	}
	// Adds a word into the data structure
	public void addWord(String word){
		Node current = root;
		for(char c:word.toCharArray()){
			if(current.children[c-'a']==null)
				current.children[c-'a'] = new Node();
			current.hasChild = true;
			current = current.children[c-'a'];
		}
		current.isWord = true;
	}
	
	// Returns if the word is in the data structure.
	// A word could contain the dot character '.' to represent
	// any on letter
	public boolean search(String word){
		boolean res = dfs(root, word, 0);
		System.out.println(res);
		return res;
	}
	private boolean dfs(Node parent, String word, int index){
		if(index==word.length())	return true;
		
		if(word.charAt(index)=='.' && parent.hasChild){
			for(int i=0; i<parent.children.length; i++){
				if(parent.children[i]!=null && dfs(parent.children[i], word, index+1))
					return true;
			}
		}
		else if(parent.children[word.charAt(index)-'a']!=null)
			return dfs(parent.children[word.charAt(index)-'a'], word, index+1);

		return false;
	}
	
	public static void main(String[] args){
		WordDictionary dict = new WordDictionary();
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");
		dict.search("pad");
		dict.search("bad");
		dict.search(".ad");
		dict.search("b..");
	}
}
