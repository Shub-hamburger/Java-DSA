/*
	Time Complexity: O(N)
	Space Complexity: O(N)
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376574
*/
import java.util.*;
public class Solution {
	public static ArrayList<Integer> smallestSubarrayWithKDistinct(ArrayList<Integer> a, int K) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		int n = a.size();
		int start = 0;
		int minLen = Integer.MAX_VALUE;
		int leftStart = n;
		
		for(int end = 0; end < n; end++) {
			map.put(a.get(end), map.getOrDefault(a.get(end), 0) + 1);
			
			while (map.size() == K) {
				if (end - start + 1 < minLen) {
					leftStart = start;
					minLen = end - start + 1;
					ans = new ArrayList<>();
					ans.add(start);
					ans.add(end);
				}
				else if (end - start + 1 == minLen) {
					if (start < leftStart) {
						leftStart = start;
						ans = new ArrayList<>();
						ans.add(start);
						ans.add(end);
					}
				}
				
				if (map.getOrDefault(a.get(start), 0) == 1)
					map.remove(a.get(start));
				else
					map.put(a.get(start), map.getOrDefault(a.get(start), 0) - 1);
				start++;
				
			}
		}
		
		if (minLen ==  Integer.MAX_VALUE) {
			ans = new ArrayList<>();
			ans.add(-1);
			return ans;
		}
		return ans;
    }
}
