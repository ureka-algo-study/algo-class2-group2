import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int t=0; t<players.length; t++){
            
            while(!q.isEmpty() && q.peek() <= t){
                q.poll();
            }
            
            if(players[t] < (q.size() +1) * m ) continue;
            
            while(players[t] >= (q.size() +1) * m ){
                q.offer(t+k);
                answer++;
            }
            
        }
        return answer;
    }
}