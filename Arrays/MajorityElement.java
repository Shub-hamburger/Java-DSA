/*
    Time complexity: O(n)
    Space complexity: O(1)
    
    Problem Link: https://leetcode.com/problems/majority-element/
*/

// Moore's voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if(num==candidate)
            count += 1; 
            else count -= 1; 
        }

        return candidate;
    }
}

/*
    // Time complexity: O(n)
    // Space complexity: O(n)

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int majorityElement = 0;
        int maxCount = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majorityElement = entry.getKey();
            }
        }
        
        return majorityElement;
    }
}
*/

/*
    Time complexity: O(nLogn)
*/
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length / 2];
//     }
// }
