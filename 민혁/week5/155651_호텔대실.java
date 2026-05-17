import java.util.*;

class Solution {

    static int min;

    public int solution(String[][] book_time) {
        List<int[]> book = new ArrayList<>();
        // book
        for(int i = 0; i < book_time.length; i ++) {
            book.add(parsing(book_time[i])); // [900,1030]
        }
        book.sort( (i1,i2) -> i1[0] - i2[0] );

        // 3. pq
        PriorityQueue<int[]> pq = new PriorityQueue<>( (i1, i2) -> i1[1] - i2[1]);

        int[]  firstBook = book.remove(0);
        int currentTime = firstBook[0];
        pq.add(firstBook);
        min = Math.max(min, pq.size());

        while(!book.isEmpty()) {
            int[] booking = book.remove(0);
            currentTime = booking[0];

            while(!pq.isEmpty() && pq.peek()[1] <= currentTime) {
                pq.poll();
            }
            pq.offer(booking);
            min = Math.max(min, pq.size());
        }

        return min;
    }

    static int[] parsing(String[] time) {
        int start = Integer.valueOf(time[0].substring(0,2)) * 60 + Integer.valueOf(time[0].substring(3,5));
        int end = Integer.valueOf(time[1].substring(0,2)) * 60 + Integer.valueOf(time[1].substring(3,5)) + 10;
        return new int[]{start, end};
    }
}
