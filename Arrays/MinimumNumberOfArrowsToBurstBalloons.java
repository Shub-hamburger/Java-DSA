/*
    Time complexity: O(nlogn)
    Space complexity: O(n) -> taken for sorting
    
    Intuition:
    ---------
    If we remove all the points that are causing the overlap, then we'll be left with only non overlapping points
    and we'll need as many arrows too. 
    This works because overlapping balloons can be shot be a single arrow, so by removing overlaps we'll be left
    with distinct balloons only.
	
	Problem Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
*/
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0 || points == null)
            return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int n = points.length;
        int count = 0;
        
        int[] prevPoint = points[0];
        for(int i = 1; i < n; i++) {
            int[] currPoint = points[i];
            
            // check for overlapping points
            if (currPoint[0] <= prevPoint[1]) {
                count++;
            }
            else {
                prevPoint = currPoint;
            }
        }
        
        return n - count;
    }
}
