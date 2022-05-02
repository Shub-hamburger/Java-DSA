/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  
  Problem Link: https://leetcode.com/problems/majority-element-ii/
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int maxCount = n / 3;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxCount) {
                ans.add(entry.getKey());
            }
        }
        
        return ans;
    }
}
