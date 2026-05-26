package 종수.week6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int n = progresses.length;

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            q.offer((100 - progresses[i] + speeds[i] -1) / speeds[i]);
            
        }

        int cur = q.poll();
        int count = 1;

        while(!q.isEmpty()){
            if(q.peek() <= cur){
                q.poll();
                count++;
            }else{
                list.add(count);
                cur = q.poll();
                count = 1;
            }
        }
        list.add(count);

        answer = new int[list.size()];
        int i=0;
        for(int x : list){
            answer[i] = x;
            i++;
        }
        return answer;
    }
}