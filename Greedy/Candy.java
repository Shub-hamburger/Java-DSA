/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Intuition:
    ----------
    Initially we given everyone 1 candy and then update the candies based on the ratings once traversing left to right
    and once right to left.
    
*/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        for(int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
        
        int totalCandies = candies[candies.length - 1];
        for(int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            totalCandies += candies[i];
        }            
        
        return totalCandies;
    }
}
