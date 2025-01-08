class Node {
    private Node[] links = new Node[26];
    
    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public Node next(char c) {
        return links[c - 'a'];
    }

    // This method inserts a node into the Trie
    public void put(char c, Node node) {
        links[c - 'a'] = node;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    // Inserts the word into the Trie
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.put(c, new Node());
            }
            node = node.next(c);
        }
    }

    // Checks if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.contains(c)) {
                return false;
            }
            node = node.next(c);
        }
        return true;
    }
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            Trie prefixTrie = new Trie();
            Trie suffixTrie = new Trie();
            
            // Insert the current word into the prefix Trie
            prefixTrie.insert(words[i]);
            
            // Insert the reversed word into the suffix Trie
            String wordReverse = new StringBuilder(words[i]).reverse().toString();
            suffixTrie.insert(wordReverse);
            
            for (int j = 0; j < i; j++) {
                // Skip if word[j] is longer than word[i]
                if (words[j].length() > words[i].length())
                    continue;

                String prefixWord = words[j];
                String revPrefixWord = new StringBuilder(prefixWord).reverse().toString();

                // Check if prefixWord and revPrefixWord are present in the prefix and suffix Tries
                if (prefixTrie.startsWith(prefixWord) && suffixTrie.startsWith(revPrefixWord)) {
                    count++;
                }
            }
        }
        return count;
    }
}
