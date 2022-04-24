/*
	Time Complexity : O(N * log(N))
	Space Complexity : O(1),

	where N is the number of elements in the array.
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376558

*/
import java.util.*;
public class Solution {
	public static ArrayList<Integer> findTriplets(int[] arr, int n) {
		Arrays.sort(arr);
       	ArrayList<Integer> a = new ArrayList<>();
       	for(int i = arr.length - 1; i >= 0; i--) {
			int ans = arr[i];
			int start = 0, end = i - 1;
			while(start < end) {
				if(ans == arr[start] + arr[end]) {
					a.add(arr[start]);
					a.add(arr[end]);
					a.add(ans);
					return a;
				}
				else if(ans > arr[start] + arr[end])
					start++;
				else
					end--;
			}
		}
		return a;
	}
}
