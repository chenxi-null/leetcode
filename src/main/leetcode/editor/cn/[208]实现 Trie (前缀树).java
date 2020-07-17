//Implement a trie with insert, search, and startsWith methods. 
//
// Example: 
//
// 
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");   
//trie.search("app");     // returns true
// 
//
// Note: 
//
// 
// You may assume that all inputs are consist of lowercase letters a-z. 
// All inputs are guaranteed to be non-empty strings. 
// 


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node.putIfAbsent(c);
            node = node.get(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.contains(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }

    static class TrieNode {
        private TrieNode[] links = new TrieNode[26];
        private boolean isEnd;

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void putIfAbsent(char ch) {
            if (!contains(ch)) {
                put(ch);
            }
        }

        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch) {
            links[ch - 'a'] = new TrieNode();
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
