package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        
        // DP

        // BFS에 노드를 이용하는 방법

        // BFS 이용
        int dist[] = new int[y+1];
        boolean vist[] = new boolean[y+1];

        Queue<Integer> q = new LinkedList<>();

        vist[x] = true;
        dist[x] = 0;

        q.add(x);

        while(!q.isEmpty()){

            int cur = q.poll();

            if(cur == y)
                return dist[cur];

            int next[] = {
                cur + n,
                cur * 2,
                cur * 3
            };

            for(int i = 0; i < 3; i++){
                if(next[i] <= y && !vist[next[i]]){

                    vist[next[i]] = true;
                    dist[next[i]] = dist[cur] + 1;
                    q.offer(next[i]);
                }
            }



        }
        return -1;
    }
}