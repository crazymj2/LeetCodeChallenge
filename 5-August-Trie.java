/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
class Trie {
    List<String> dataList = new ArrayList<>();
    /** Initialize your data structure here. */
    public Trie() {
        dataList = new ArrayList<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (!dataList.contains(word)) {
			dataList.add(word);
		}
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return dataList.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        boolean found = false;
        for (String s : dataList) {
            if(s.startsWith(prefix)){
                found = true;
                break;
            }
        }
        return found;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
