
import java.util.*;


class Solution {
    public int solution(int[] stones, int k) {

//         int min = Integer.MAX_VALUE;
//         for(int i = 0; i < stones.length - k + 1; i ++) {
//             int[] subStones = Arrays.copyOfRange(stones,i,i+k);
//             int a = Arrays.stream(subStones).max().getAsInt();
//             min = Math.min(min,a);
//         }
//         return min; 시간초과


//         int min = Integer.MAX_VALUE;
//         for(int i = 0; i < stones.length - k + 1; i ++) {
//             int maxStone = Integer.MIN_VALUE;
//             for(int j = i; j < i + k; j++ ) {
//                 maxStone = Math.max(stones[j],maxStone);
//             }
//             min = Math.min(min,maxStone);
//         }
//         return min;  시간 초과

//         int min = Integer.MAX_VALUE;
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (a, b) -> Integer.compare(b[0], a[0])
//         );
//         for (int i = 0; i < stones.length; i++) {
//             pq.offer(new int[]{stones[i], i});
//             while (!pq.isEmpty() && pq.peek()[1] <= i - k) {
//                 pq.poll();
//             }
//             if (i >= k - 1) {
//                 answer = Math.min(min, pq.peek()[0]);
//             }
//         }
//         return answer; 시간 초과

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < stones.length; i++) {
            while(!q.isEmpty() && q.peek() <= i - k) { // 범위 검사
                q.poll();
            }
            while( !q.isEmpty() && stones[q.peekLast()] <= stones[i]) { //최대값 후보 검사
                q.pollLast();
            }
            q.offer(i); // idx로 집어넣기 -> 범위검사를 위해 필요
            if(i >= k -1) {
                answer = Math.min(answer, stones[q.peek()]); // k까지 검사했으면 이제부터 하나하나 다 검사
            }
        }

        return answer;
    }
}