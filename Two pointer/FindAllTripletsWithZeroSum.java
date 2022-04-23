/*
        Time Complexity : O(N^2)
        Space Complexity : O(N),

        where N is the number of elements in the array.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	private static HashSet<int[]> set = new HashSet<>();
	public static ArrayList<ArrayList<Integer>> findTriplets(ArrayList<Integer> arr, int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Collections.sort(arr);

		for (int i = 0; i < n - 1; i++) {
			int target = -arr.get(i);
			int front = i + 1;
			int back = n - 1;

			while (front < back) {
				int sum = arr.get(front) + arr.get(back);
				if (sum < target) {
					front++;
				}

				else if (sum > target) {
					back--;
				} 
				else {
					int x = arr.get(front);
					int y = arr.get(back);
					ArrayList<Integer> list = new ArrayList<>();

					list.add(arr.get(i));
					list.add(x);
					list.add(y);

					Collections.sort(list);

					if (!set.contains(new int[] {list.get(0), list.get(1), list.get(2)})) {
						set.add(new int[] {list.get(0), list.get(1), list.get(2)});
						ans.add(list);
					}

					while (front < back && arr.get(front).equals(x)) {
						front++;
					}

					while (front < back && arr.get(back) == y) {
						back--;
					}
				}
			}

			while (i + 1 < n && arr.get(i) == arr.get(i + 1)) {
				i++;
			}
		}
		return ans;
	}
}
