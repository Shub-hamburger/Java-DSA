/*
    Time complexity: O(NlogN)
    Space complexity: O(N)
*/
class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {        
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

/*
    Time complexity: O(N ^ 2)
    Space complexity: O(N)
*/
/*
class MyCalendar {
    ArrayList<int[]> calendar;
    
    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] booking: calendar) {
            if (booking[0] < end && start < booking[1]) 
                return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}
*/

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
