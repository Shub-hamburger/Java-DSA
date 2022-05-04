/*
    Time complexity:
    Space complexity:
    
    Idea: We'll sort the array & fix two pointers and then find the remaining two elements using two pointer technique as the array is sorted.
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        
        if (nums == null || n == 0)
            return ans;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int first = nums[i];
                int second = nums[j];
                
                int newTarget = target - (first + second);
                int start = j + 1;
                int end = nums.length - 1;
                
                while (start < end) {
                    int third = nums[start];
                    int fourth = nums[end];
                    int sum = third + fourth;
                    
                    if (sum > newTarget)
                        end--;
                    else if (sum < newTarget)
                        start++;
                    else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(first);
                        temp.add(second);
                        temp.add(third);
                        temp.add(fourth);
                        
                        ans.add(temp);
                        
                        // Ignore the duplicates of third
                        while (start < end && nums[start] == temp.get(2)) 
                            start++;
                        // Ignore the duplicates of fourth
                        while (start < end && nums[end] == temp.get(3))
                            end--;
                    }
                }
                // Ignore the duplicates of second
                while (j + 1 < n && nums[j + 1] == nums[j]) 
                    j++;
            }
            // Ignore the duplicates of first
            while (i + 1 < n && nums[i + 1] == nums[i])
                i++;
        }
        
        return ans;
    }
}
