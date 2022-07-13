/*
    Time complexity: O(nlogn)
    Space complexity: O(1)
    
    Problem Link: https://leetcode.com/problems/non-overlapping-intervals/
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals == null)
            return 0;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        
        int[] prevInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (currInterval[0] < prevInterval[1]) {
                count++;
            } 
            else {
                prevInterval = currInterval;
            }
        }
        
        return count;
    }
}
