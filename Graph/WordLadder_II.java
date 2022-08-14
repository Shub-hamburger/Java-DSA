/*
    Time complexity: O(m^2 * n)
    Space complexity: O(m * n) 
    
    where, m is the length of the word & n is the size of the wordList.
    
    Intuition:
    ----------
    The basic idea is:

    1. Use BFS to find the shortest distance between start and end, tracing the distance of crossing nodes from start node to
    end node, and store node's next level neighbors to HashMap;

    2. Use DFS to output paths with the same distance as the shortest distance from distance HashMap: compare if the distance
    of the next level node equals the distance of the current node + 1.
    
    Problem Link: https://leetcode.com/problems/word-ladder-ii/
*/

class Solution {
    private void findShortestPath(String endWord, Queue<String> queue, HashSet<String> set, HashMap<String, Integer> map) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currWord = queue.poll();
                
                // if end word is found, break
                if (currWord.equals(endWord))
                    break;
                
                char[] charArray = currWord.toCharArray();
                for(int j = 0; j < currWord.length(); j++) {
                    char currChar = charArray[j];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        // replace the current character in currWord with a new character
                        charArray[j] = ch;
                        
                        // creating a new word
                        String newWord = new String(charArray);
                        // check if the new word is in the set and is not visited yet
                        if (set.contains(newWord) && !map.containsKey(newWord)) {
                            map.put(newWord, map.get(currWord) + 1);
                            queue.add(newWord);
                        }
                    }
                    
                    // reset the character back
                    charArray[j] = currChar;
                }
            }
        }
    }
    
    private void dfs(String currWord, String beginWord, HashMap<String, Integer> map, 
                     List<String> seq, List<List<String>> ans) {
        // base case
        if (currWord.equals(beginWord)) {
            List<String> temp = new ArrayList(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        
        char[] charArray = currWord.toCharArray();
        for(int j = 0; j < currWord.length(); j++) {
            char currChar = charArray[j];
            for(char ch = 'a'; ch <= 'z'; ch++) {
                // replace the current character in currWord with a new character
                charArray[j] = ch;
                        
                // creating a new word
                String newWord = new String(charArray);
                // check if the new word is in the map and the distance of the newWord equals the distance of the currWord + 1.
                if (map.containsKey(newWord) && map.get(newWord) + 1 == map.get(currWord)) {
                    seq.add(newWord);
                    dfs(newWord, beginWord, map, seq, ans);
                    seq.remove(seq.size() - 1);
                }
            }
                    
            // reset the character back
            charArray[j] = currChar;
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        List<String> sequence = new ArrayList<>();
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);
        HashMap<String, Integer> map = new HashMap<>();
        
        queue.add(beginWord);
        map.put(beginWord, 0);
        
        // find shortest path (bfs call) and store the distances of each transformation w.r.t beginWord
        findShortestPath(endWord, queue, set, map);
        
        // if after the bfs call endWord is not in the map then there is no ans
        if (!map.containsKey(endWord))
            return ans;
        
        sequence.add(endWord);
        
        // do dfs on the map
        dfs(endWord, beginWord, map, sequence, ans);
        
        return ans;
    }
}
