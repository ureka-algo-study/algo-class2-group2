import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0; i<enemy.length; i++){
            pq.offer(enemy[i]);
            n-=enemy[i];
            // System.out.println(enemy[i] + " - n: " + n + ", k: "+ k);
            
            while(n<0 && k>0){
                k--;
                n+=pq.poll();
                // System.out.println(n);
            }
            if(k<=0 && n<0){
                answer = i;
                return answer;
            }
            // System.out.println(i + " - n: " + n + ", k: "+ k);
        }
        return enemy.length;
    }
}