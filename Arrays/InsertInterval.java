/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/insert-interval/
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        boolean inserted = false;
        
        // if no intervals are there
        if (intervals.length == 0) {
            inserted = true;
            mergedIntervals.add(newInterval);
        }
        
        for(int[] interval: intervals) {
            // check for overlap with newInterval
            if (!inserted && interval[1] >= newInterval[0] && interval[0] <= newInterval[1]) {
                interval[0] = Math.min(interval[0], newInterval[0]);
                interval[1] = Math.max(interval[1], newInterval[1]);
                inserted = true;
            }
            // check if newInterval is smaller than the first interval
            else if (!inserted && interval[0] > newInterval[1]) {
                inserted = true;
                mergedIntervals.add(newInterval);
            }
            
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1)[1] < interval[0])
                mergedIntervals.add(interval);
            else {
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], interval[1]);
            }
        }
        
        // if newInterval is larger than the largest interval
        if (!inserted)
            mergedIntervals.add(newInterval);
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
