/*
	Time Complexity: O(N)
	Space Complexity: O(1)

	Where 'N' is the number of elements in the sequence.
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376556
 */
public class Solution {
	public static int maxArea(int[] height) {
	    int area = 0;
		int left = 0;
		int right = height.length - 1;
		
		while (left < right) {
			area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			}
			else
				right--;
		}
		
		
		return area;
	}
}
