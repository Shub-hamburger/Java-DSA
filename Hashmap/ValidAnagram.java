/*
    Time complexity: O(N)
    Space complexity: O(N)
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m != n)
            return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) - 1);
            else
                return false;
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        
        return true;
    }
}
