/*
    Time complexity: O(n + mlogm)
    Space complexity: O(m)
    
    where, n in the size of array and m is the number of unqiue numbers in arr
    
    Problem Link: https://leetcode.com/problems/reduce-array-size-to-the-half/
*/
class Solution {
    public int minSetSize(int[] arr) {
        int count = 0;
        int size = arr.length;
        int halfSize = size / 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num: arr){
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }
        
        for(int val: map.values())
            pq.add(val);
        
        while (!pq.isEmpty() && halfSize > 0) {
            halfSize -= pq.poll();
            count++;
        }
        
        return halfSize > 0 ? -1 : count;
    }
}
