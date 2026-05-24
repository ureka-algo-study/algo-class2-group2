import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] time = new int[book_time.length][book_time[0].length];
        
        // 시간 (String -> int) 변환 + 청소 시간
        for(int i=0; i<book_time.length; i++){
            for(int j=0; j<book_time[0].length; j++){
                StringTokenizer token = new StringTokenizer(book_time[i][j], ":");
                time[i][j] = Integer.parseInt(token.nextToken()) * 60 + Integer.parseInt(token.nextToken());
            }
            time[i][1] += 10;
            // System.out.println(Arrays.toString(time[i]));
        }
        
        // 입실 순으로 정렬
        Arrays.sort(time, (a,b) -> {return a[0] - b[0];});
        
        // 
        for(int i=0; i<time.length; i++){
            if(pq.isEmpty()){
                pq.offer(time[i][1]);
            }
            else{
                if(pq.peek() > time[i][0]){
                    pq.offer(time[i][1]);
                }
                else{
                    pq.poll();
                    pq.offer(time[i][1]);
                }
            }
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
}