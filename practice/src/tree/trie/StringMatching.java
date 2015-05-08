package tree.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * List<String> list, String target
 * return all matching string
 * 
 * @author carllee1991
 *
 */
public class StringMatching {
	public List<String> matching(List<String> list, String target){
		Trie tt = new Trie();
		for(int i=0; i<list.size(); i++)	tt.insert(list.get(i));
		
		List<String> ret = new ArrayList<>();
		
		dfs(tt, target, 0, tt.root, new StringBuilder(), ret);
		
		return ret;
	}
	private void dfs(Trie tt, String target, int index, TrieNode current, StringBuilder sb, List<String> ret){
		if(index==target.length()){
			ret.add(sb.toString());
			return;
		}
		if(target.charAt(index)=='.'){
			dfs(tt, target, index+1, current, sb, ret);
			for(int i=0; i<current.children.length; i++){
				if(current.children[i]!=null){
					dfs(tt, target, index+1, current.children[i], sb.append((char)(i+'a')), ret);
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}else{
			for(int i=0; i<current.children.length; i++){
				if(current.children[i]!=null && target.charAt(index)-'a'==i){
					dfs(tt, target, index+1, current.children[i], sb.append(target.charAt(index)), ret);
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
	}
}
