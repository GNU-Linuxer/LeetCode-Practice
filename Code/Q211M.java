// 211. Design Add and Search Words Data Structure (Medium)
// https://leetcode.com/problems/design-add-and-search-words-data-structure/

public class Q211M {
    private final TrieNode root;

    public Q211M() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null && word.length() == 0) {
            return;
        }
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int offset = c - 'a';
            if (curr.children[offset] == null) {
                curr.children[offset] = new TrieNode();
            }
            curr = curr.children[offset];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        if (word == null && word.length() == 0) {
            return false;
        }
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode root) { // Will mask up the field root
        if (root == null) {
            return false;
        }
        if (index == word.length()) {
            return root.isWord;
        }
        char c = word.charAt(index);
        boolean result = false;
        if (c == '.') {
            for (TrieNode t : root.children) {
                if (t != null) {
                    result = result | search(word, index + 1, t);
                }
            }
        } else {
            int offset = c - 'a';
            result = result | search(word, index + 1, root.children[offset]);
        }

        return result;
    }

    public static void main(String[] args) {
        Q211M obj = new Q211M();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }

    private class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
}
