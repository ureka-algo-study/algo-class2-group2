package 종수.week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {

        List<Integer>[] graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        dist[1] = 0;

        while(!q.isEmpty()){

            int now = q.poll();

            for(int next : graph[now]){

                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }

        int max = 0;

        for(int i = 1; i <= n; i++){
            max = Math.max(max, dist[i]);
        }

        int answer = 0;

        for(int i = 1; i <= n; i++){
            if(dist[i] == max){
                answer++;
            }
        }

        return answer;
    }
}