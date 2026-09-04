import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(A);
        
        for(int i=0; i<B.length; i++){
            pq.offer(B[i]);
        }
        
        int idx = 0;
        
        while(idx < A.length){
            if(pq.isEmpty()) return answer;
            
            if (A[idx] < pq.peek()){
                answer ++;
                idx++;
            }
            pq.poll();
        }
        
        return answer;
    }
}