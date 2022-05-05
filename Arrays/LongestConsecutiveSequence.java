/*
Two while loops used but runs a but faster because of not computing 
again for same element with this {if (!map.get(num))} check

Time complexity: O(N)
Space complexity: O(N)

*/
class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for(int num: nums)
            map.putIfAbsent(num, true);
        
        for(int num: nums) {
            if (!map.get(num))
                continue;
            map.replace(num, true, false);
            
            int currLength = 1;
            int left = num - 1;
            int right = num + 1;
            
            while (map.containsKey(left)) {
                map.replace(left, true, false);
                currLength++;
                left--;
            }
            while (map.containsKey(right)) {
                map.replace(right, true, false);
                currLength++;
                right++;
            }
            
            maxLen = Math.max(maxLen, currLength);
        }
        
        return maxLen;
    }
}
*/

/*
// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
*/
