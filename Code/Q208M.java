// 208. Implement Trie (Prefix Tree) (Medium)
// https://leetcode.com/problems/implement-trie-prefix-tree/

public class Q208M {
    private TrieNode root;

    public Q208M() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        // Perform one DFS on a Trie Tree
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            int offset = c - 'a'; // Will automatically cast to int based on the ASCII value in this char
            if(current.children[offset] == null) {
                current.children[offset] = new TrieNode();
            }
            current = current.children[offset];
        }
        current.word = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int offset = c - 'a';
            if(current.children[offset] == null) {
                return false;
            }
            current = current.children[offset];
        }
        return current.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c : prefix.toCharArray()) {
            int offset = c - 'a';
            if(current.children[offset] == null) {
                return false;
            }
            current = current.children[offset];
        }
        return true;
    }

    private class TrieNode {
        public boolean word;
        public TrieNode[] children;

        public TrieNode() {
            word = false;
            children = new TrieNode[26];
        };
    }

    public static void main(String[] args) {
        String word = "apple";
        String prefix = "app";
        Q208M obj = new Q208M();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
