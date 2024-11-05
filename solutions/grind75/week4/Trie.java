package solutions.grind75.week4;

public class Trie {

    public Trie[] trie;
    public boolean flag;

    public Trie() {
        trie = new Trie[26];
        flag = false;
    }
    
    public void insert(String word) {
        Trie node = this;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.trie[idx] == null) {
                node.trie[idx] =  new Trie();
            }

            node = node.trie[idx];
        }

        node.flag = true;
    }
    
    public boolean search(String word) {
        Trie node = this;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.trie[idx] == null) {
                return false;
            }

            node = node.trie[idx];
        }

        return node.flag;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.trie[idx] == null) {
                return false;
            }

            node = node.trie[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
