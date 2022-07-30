/*
    Time complexity: O(n1 + n2)
    Space complexity: O(n1 + n2)
    
    where, n1 & n2 are lengths of words1 & words2 arrays respectively.
    
    Inutition:
    ---------
    For example, when checking whether "warrior" is a superset of words B = ["wrr", "wa", "or"], 
    we can combine these words in B to form a "maximum" word "arrow", that has the maximum count of every letter in
    each word in B.
    Now, we'll just check whether the count of every character in "warrior" is more than the maximum word formed from
    B (here, "arrow").
*/

class Solution {
    public int[] counter(String word) {
        int[] count = new int[26];
        for(char ch: word.toCharArray()) {
            count[ch - 'a']++;
        }
        
        return count;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] maxFromWords2 = new int[26];
        
        // create max word from words2 array
        for(String word: words2) {
            int[] words2Counter = counter(word);
            for(int i = 0; i < 26; i++) {
                maxFromWords2[i] = Math.max(maxFromWords2[i], words2Counter[i]); 
            }
        }
        
        int idx;
        for(String word: words1) {
            int[] words1Counter = counter(word);
            for(idx = 0; idx < 26; idx++)
                if (words1Counter[idx] < maxFromWords2[idx])
                    break;
            if (idx == 26)
                ans.add(word);
        }
        
        return ans;
    }
}
