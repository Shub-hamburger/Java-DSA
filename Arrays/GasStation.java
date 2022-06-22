/*

    Time complexity: O(N)
    Space complexity: O(1)
    
    Intuition
    ---------
    Imagine we take a tour around this circle, the only condition that we can complete this trip is to have more fuel
    provided than costed in total. That's what the first loop does.

    If we do have more fuel provided than total consumed, that means we can always find a start point around this circle
    that we could complete the journey with an empty tank. 
    Hence, we check from the beginning of the array, if we can gain more fuel at the current station, we will maintain
    the start point, else, which means we will burn out of oil before reaching to the next station, we will start over
    at the next station.
    
    Problem Link: https://leetcode.com/problems/gas-station/
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalFuel = 0;
        
        for(int i = 0; i < n; i++) {
            totalFuel += gas[i] - cost[i];
        }
        
        // If enough fuel is not there.
        if (totalFuel < 0)
            return -1;
        
        int start = 0;
        int accumulatedFuel = 0;
        
        for(int i = 0; i < n; i++) {
            int currSurplus = gas[i] - cost[i];
            if (accumulatedFuel + currSurplus < 0) {
                start = i + 1;
                accumulatedFuel = 0;
            }
            
            else accumulatedFuel += currSurplus;
        }
        
        return start;
    }
}
