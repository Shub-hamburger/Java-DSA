/*
    Time complexity: O(N * (logN + N)) ~ O(N^2)
    Space complexity: O(N)
    
    Intuition:
    ---------
    1. Pick element from unsorted array "nums" { 5, 2, 6, 1 }. Let's pick "5"
    2. Searching the element in sorted array "arr" { 1, 2, 5, 6 } so index of 5 in sorted array is 2. This, numbers before
    index 2 are smaller than 5.
    3. Now, there can be duplicates, so to mitigate even after we find an answer during binary search we'll keep on
    searching as we may get a better ans on the left side of the search space.
    4. Lastly we'll remove the 5 because we don't want to count this number when it's time to count numbers lesser than 6.
    Check the example [5, 2, 6, 1].
	
	Problem Link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
*/

class Solution {
    public int modifiedBinarySearch(ArrayList<Integer> arr, int num) {
        int left = 0;
        int res = -1;
        int right = arr.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) > num) {
                right = mid - 1;
            } 
            else if (arr.get(mid) < num) {
                left = mid + 1;
            } 
            else {
                res = mid;
                // ans found but keep on searching as we may get a better ans on the left side of the search space.
                right = mid - 1;
            }
        }
        
        return res;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int num: nums)
            arr.add(num);
        
        Collections.sort(arr);
        
        for(int i = 0; i < n; i++) {
            int idx = modifiedBinarySearch(arr, nums[i]);
            ans.add(idx);
            // remove the current num so that we don't count int unnecessarily (check for example [5, 2, 6, 1])
            arr.remove(idx);
        }
        
        return ans;
    }
}
