import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            q.offer(new int[]{progresses[i], speeds[i]});
        }
        int test = 0;
        while(!q.isEmpty()){ //
            int cnt = 0;
            while(!q.isEmpty() && q.peek()[0] >= 100){
                q.poll();
                // System.out.println("poll");
                cnt++;
            }
            if(cnt > 0){
                ans.add(cnt);
                // System.out.println("cnt: " + cnt);
            }
            
            for(int i=0; i<q.size(); i++){
                int[] pop = q.poll();
                // System.out.println("poll : " + pop[0]);
                int progress = pop[0] + pop[1];
                q.offer(new int[] {progress, pop[1]});
            }
        }
        answer = ans.stream().mapToInt(i->i).toArray();
        return answer;
    }
}