/*
        Time Complexity : O(N^2)
        Space Complexity : O(N),
        where N is the number of elements in the array.
 */
import java.util.*;
public class Solution {
	private static HashSet<int[]> set = new HashSet<>();
	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);

		for (int i = 0; i < n - 2; i++) {
			int target = K - arr[i];
			int front = i + 1;
			int back = n - 1;

			while (front < back) {
				int sum = arr[front] + arr[back];
				if (sum < target) {
					front++;
				}

				else if (sum > target) {
					back--;
				} 
				else {
					int x = arr[front];
					int y = arr[back];
					ArrayList<Integer> list = new ArrayList<>();

					list.add(arr[i]);
					list.add(x);
					list.add(y);

					Collections.sort(list);

					if (!set.contains(new int[] {arr[i], x, y})) {
						set.add(new int[] {arr[i], x, y});
						ans.add(list);
					}

					while (front < back && arr[front] == x) {
						front++;
					}

					while (front < back && arr[back] == y) {
						back--;
					}
				}
			}

			while (i + 1 < n && arr[i] == arr[i + 1]) {
				i++;
			}
		}
		return ans;
	}
}
