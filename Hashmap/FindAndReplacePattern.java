/*
    Time complexity: O(m * n)
    Space complexity: O(m * n)
    
    where, m is the number of words and n is length of each word
    
    Inutition:
    ---------
    According to the ques, "every letter maps to another letter, and no two letters map to the same letter"
    So, we just need to ensure that this property (bijection) holds. To achieve this, we'll use two hashmaps.
    Hashmap 1: Mapping of letter to pattern
    Hashmap 2: Mappinng of pattern to letter
    
    With these if we're able to ascertain that multiple words[i] are not mapped to the same pattern[i] 
    and vice-versa, then we've a bijection and we add this word to our ans.
	
	Problem Link: https://leetcode.com/problems/find-and-replace-pattern/
*/
class Solution {
    public boolean match(String word, String pattern) {
        Map<Character, Character> patternMap = new HashMap();
        Map<Character, Character> wordMap = new HashMap();
        
        for(int i = 0; i < word.length(); i++) {
            char wordCh = word.charAt(i);
            char patCh = pattern.charAt(i);
            
            if (!patternMap.containsKey(patCh))
                patternMap.put(patCh, wordCh);
            if (!wordMap.containsKey(wordCh))
                wordMap.put(wordCh, patCh);
            
            if (patternMap.get(patCh) != wordCh || wordMap.get(wordCh) != patCh)
                return false;
        }
        
        return true;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(String word: words) {
            if (match(word, pattern))
                ans.add(word);
        }
        
        return ans;
    }
}
