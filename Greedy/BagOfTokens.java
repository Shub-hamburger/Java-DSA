/*
    Time complexity: O(nlogn)
    Space complexity: O(logn) -> taken by Arrays.sort()
    
    Problem Link: https://leetcode.com/problems/bag-of-tokens/
*/
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int ans = 0;
        
        while (left <= right) {
            if (power >= tokens[left]) {
                score++;
                power -= tokens[left];
                left++;
                ans = Math.max(ans, score);
            } 
            else if (power < tokens[left] && score > 0) {
                score -= 1;
                power += tokens[right];
                right -= 1;
            }
            else {
                return ans;
            }
        }
        
        return ans;
    }
}
