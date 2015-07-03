package questions;

import java.util.LinkedList;

public class TrieQuestions {
	class TrieNode {
		// Initialize your data structure here.
		    char content;
		    boolean isEnd;
		    LinkedList<TrieNode> childNodes;
		    
		    public TrieNode(){
		        this.content = ' ';
		        this.isEnd = false;
		        this.childNodes = new LinkedList<TrieNode>();
		    }
		    
		    public TrieNode(char content){
		        this.content = content;
		        this.isEnd = false;
		        this.childNodes = new LinkedList<TrieNode>();
		    }
		    
		    public TrieNode subNode(char content){
		        if(this.childNodes!=null){
		            for(TrieNode node : this.childNodes){
		                if(node.content == content){
		                    return node;
		                }
		            }
		        }
		        return null;
		    }
		}
	
	
	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        if(search(word)) return;
	        TrieNode curr = root;
	        for(int i=0; i<word.length(); i++){
	            char c = word.charAt(i);
	            TrieNode node = curr.subNode(c);
	            if(node == null){
	                node = new TrieNode(c);
	                curr.childNodes.add(node); //different with the toturial
	            }
	            curr = node;
	        }
	        
	        curr.isEnd = true;
	        
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        if(word == null) return true;
	        TrieNode curr = root;
	        for(int i=0; i<word.length(); i++){
	            TrieNode node = curr.subNode(word.charAt(i));
	            if(node == null){
	                return false;
	            }
	            curr = node;
	        }
	        
	        if(curr.isEnd){
	            return true;
	        }else{
	            return false;
	        }
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode curr = root;
	        for(int i = 0; i<prefix.length(); i++){
	            TrieNode node = curr.subNode(prefix.charAt(i));
	            if(node == null){
	                return false;
	            }
	            curr = node;
	        }
	        
	        return true;
	    }
	}
}
