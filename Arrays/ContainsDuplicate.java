/*
    Time complexity: O(N)
    Space complexity: O(N)
*/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int num: nums) {
            if(set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        
        return false;
    }
}
