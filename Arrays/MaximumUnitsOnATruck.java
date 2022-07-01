/*
    Time complexity: O(NlogN) -> because of sorting
    Space complexity: O(1) to O(N) depending on the sort algorithm used
*/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxUnits = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        
        for(int[] boxType: boxTypes) {
            if (truckSize >= boxType[0]) {
                maxUnits += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                maxUnits += truckSize * boxType[1];
                return maxUnits;
            }
        }
        
        return maxUnits;
    }
}
