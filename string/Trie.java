/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-10
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe : 前缀树Demo以及注释
 * ========================================================================================
 */
public class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 构造前缀树
     *
     * @param word 前缀树节点内容
     */
    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char element = word.charAt(i);
            if (currentNode.children[element - 'a'] == null) {
                currentNode.children[element - 'a'] = new TrieNode();
            }
            currentNode = currentNode.children[element - 'a'];
        }
        currentNode.isLast = true;
    }

    /**
     * 判断前缀树是否包含有word内容
     *
     * @param word 待检查的前缀树的内容
     * @return true/false
     */
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char element = word.charAt(i);
            if (currentNode.children[element - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.children[element - 'a'];
        }
        // 最后一个的结束标志
        return currentNode.isLast;
    }

    /**
     * 判断是不是以prefix作为前缀
     *
     * @param prefix 前缀字符串
     * @return if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char element = prefix.charAt(i);
            if (currentNode.children[element - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.children[element - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}

/**
 * 26个数组下标代表字符前缀树，并且保留当前Node是不是结尾表述
 */
class TrieNode {
    TrieNode[] children;
    boolean isLast;

    /**
     * 默认初始化
     */
    public TrieNode() {
        children = new TrieNode[26];
        isLast = false;
    }
}