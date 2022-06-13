/*
    Time complexity: O(N)
    Space complexity: O(1)
*/
class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        
        while (start < end) {
            area = Math.max(area, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        
        return area;
    }
}
