/*
    Time complexity: O(N + S), where N <= 5 * (10^4) is length of string s, S <= 5000 * 50 is sum length of all words
    Space complexity: O(M), where M <= 5000 is size of words.
	
    Problem Link: https://leetcode.com/problems/number-of-matching-subsequences/
*/
class Node {
    String str;
    int idx;
    
    public Node(String str, int idx) {
        this.str = str;
        this.idx = idx;
    }
}

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<Character, ArrayList<Node>> map = new HashMap<>();
        
        /*
            Creating a word map for words array.
            Eg: For words = ["a","bb","acd","ace"]
                We'll have:
                
                {
                  "a": ["a", "acd", "ace"],
                  "b": ["bb"]
                }
        */
        for (String word: words){
            char ch = word.charAt(0);
            map.putIfAbsent(ch, new ArrayList<Node>());
            map.get(ch).add(new Node(word, 0));
        }
        
        // Iterating over string 's' and checking for each character
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch))
                continue;
            
            ArrayList<Node> wordList = map.get(ch);
            map.put(ch, new ArrayList<Node>());
            
            for(Node wordNode: wordList) {
                wordNode.idx++;
                if (wordNode.idx == wordNode.str.length())
                    count++;
                else {
                    char newChar = wordNode.str.charAt(wordNode.idx);
                    map.putIfAbsent(newChar, new ArrayList<Node>());
                    map.get(newChar).add(wordNode);
                }
            }
        }
        
        return count;
    }
}

/*
    Recursive solution - Gives TLE
    ------------------
    Time complexity: O(M * N)
    where, M is the length of the words array and N is the length of the string 's'.
    Space complexity: O(M + N) -> Stack space taken by recursion
    
*/

/*
class Solution {
    public boolean helper(String s, int idx1, String word, int idx2) {
        // base case
        if (idx2 < 0) 
            return true;
        if (idx1 < 0) 
            return false;
        
        if (s.charAt(idx1) == word.charAt(idx2))
            return helper(s, idx1 - 1, word, idx2 - 1);
        
        return helper(s, idx1 - 1, word, idx2);
    }
    
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        for(String word: words) {
            if (word.length() <= s.length() && helper(s, s.length() - 1, word, word.length() - 1))
                count++;
        }
        
        return count;
    }
}
*/
