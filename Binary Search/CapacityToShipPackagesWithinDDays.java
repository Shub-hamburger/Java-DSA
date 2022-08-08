/*
    Time complexity: O(Nlog(sum - max))
    Space complexity: O(1)
    
    Here, sum is the sum of all weights, max is the maximum weight and N is the number of weights.
    
    Problem Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
*/
class Solution {
    public boolean isPossible(int[] weights, int weight, int days) {
        int count = 0;
        int allocatedWeight = 0;
        
        for(int currWeight: weights) {
            // if limit has exceeded, load on another ship
            if(allocatedWeight + currWeight > weight) {
                count++;
                allocatedWeight = currWeight;
                
                // if the weight of package is more than the load capacity of the ships, we can't load it
                if(allocatedWeight > weight)
                    return false;
            } 
            else {
                // continue loading
                allocatedWeight += currWeight;
            }
        }
        
        // return true only if shipment can be done with `days` days.
        return count < days ? true : false;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int ans = -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        // low = max(weights) as we need to load all packages and this is the min ans possible
        // high = sum(weights) as this is highest ans possible
        for(int weight: weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // check if loading is possible with curr weight (here, mid)
            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
}
