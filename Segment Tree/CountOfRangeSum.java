/*
    Overall Time complexity: O(nlogn)
    Overall Space complexity: O(n)
    
    Problem Link: https://leetcode.com/problems/count-of-range-sum/
*/

class SegementTreeNode {
    SegementTreeNode left;
    SegementTreeNode right;
    int count;
    long min;
    long max;
    
    public SegementTreeNode(long min, long max) {
        this.min = min;
        this.max = max;
    }
}
    
class Solution {
    /*
        Time complexity: O(n)
        Space complexity: O(n) -> stack space
    */
    public SegementTreeNode build(Long[] arr, int left, int right) {
        // base case
        if (left > right)
            return null;
        
        SegementTreeNode root = new SegementTreeNode(arr[left], arr[right]);
        if (left ==  right)
            return root;
        
        // hypothesis
        int mid = left + (right - left) / 2;
        root.left = build(arr, left, mid); // build left subtree
        root.right = build(arr, mid + 1, right); // build right subtree
        
        // induction
        return root;
    }
    
    /*
        Time complexity: O(logn)
        Space complexity: O(logn) -> stack space
    */
    private void update(SegementTreeNode root, long val) {
        // base case
        if(root == null) 
            return;
        
        if(val >= root.min && val <= root.max) {
            root.count++;
            
            // hypothesis
            update(root.left, val);
            update(root.right, val);
        }
    }
    
    /*
        Time complexity: O(logn)
        Space complexity: O(logn) -> stack space
    */
    private int query(SegementTreeNode root, long min, long max) {
        // base cases
        if(root == null) 
            return 0;
        
        // if the node's [min, max] completely doesn't lie in the range [min, max]
        if(min > root.max || max < root.min) 
            return 0;
        
        // if the node's [min, max] completely lies in the range [min, max]
        if(min <= root.min && max >= root.max) 
            return root.count;
        
        // hypothesis
        // now we know the node's [min, max] overlaps with the range [min, max]
        int leftCount = query(root.left, min, max);
        int rightCount = query(root.right, min, max);
        
        // induction
        return leftCount + rightCount;
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0) 
            return 0;
    
        int n = nums.length;
        int count = 0;
    
        // The cumulative sum is stored in a set as we're only concerned about the range of sum, so duplicates are useless
        HashSet<Long> set = new HashSet<Long>();
        long cumSum = 0; 
    
        for(int i = 0; i < nums.length; i++) {
            cumSum += (long) nums[i];
            set.add(cumSum);
        }

        Long[] arr = set.toArray(new Long[0]);

        // Sort arr as we need to extract the range of sum
        Arrays.sort(arr);
        
        // build a segment tree
        SegementTreeNode root = build(arr, 0, arr.length - 1);
        
        for(int i = nums.length - 1; i >= 0; i--) {
            update(root, cumSum);
            cumSum -= (long) nums[i];
            
            /*
                Sum of range [i, j] is actually prefixSum[j] - prefixSum[i - 1]
                Since, we want to check whether prefixSum[j] - prefixSum[i - 1] belongs to [lower, upper] or not
                We count the number of prefixSum[j] that is in the range of [lower + prefix[i-1] , upper + prefix[i-1]
            */
            count += query(root, (long)lower + cumSum, (long)upper + cumSum);
        }
    
        return count;
    }
}
