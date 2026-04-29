import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        
        int[] start = {0,0,1};
        int[] di = {0,0,-1,1}; //동서남북
        int[] dj = {1,-1,0,0};
        
        q.offer(start);
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] pop = q.poll();
            if(pop[0] == maps.length-1 && pop[1] == maps[0].length-1){
                return pop[2];
            }
            for(int idx = 0; idx < 4; idx++){
                int i = pop[0] + di[idx];
                int j = pop[1] + dj[idx];
                
                if(i >=0 && i < maps.length && j >= 0 && j < maps[0].length && !visited[i][j] && maps[i][j] == 1){
                    int[] tmp = {i, j, pop[2]+1};
                    q.offer(tmp);
                    visited[i][j] = true;
                    
                }
            }
        }
        return -1;
    }
}