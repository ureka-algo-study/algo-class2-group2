import java.util.*;


class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[][] dest = new int[2][2];
        int[] cur = new int[3];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    cur[0] = i;
                    cur[1] = j;
                    cur[2] = 0;
                }
                else if(maps[i].charAt(j) == 'L'){
                    dest[0][0] = i;
                    dest[0][1] = j;
                }
                else if(maps[i].charAt(j) == 'E'){
                    dest[1][0] = i;
                    dest[1][1] = j;
                }
            }
        }
        

        boolean isSuccess = false;
        
        for(int dest_idx = 0; dest_idx<2; dest_idx++){
            boolean[][] visited = new boolean[maps.length][maps[0].length()];
            Queue<int[]> q = new LinkedList<>();
        
            q.offer(cur);
            int[] di = {0,0,1,-1};
            int[] dj = {1,-1,0,0};

            while(!q.isEmpty()){
                cur = q.poll();
                if(visited[cur[0]][cur[1]]) continue;
                
                visited[cur[0]][cur[1]] = true;

                if(dest[dest_idx][0] == cur[0] && dest[dest_idx][1] == cur[1]){
                    break;
                }

                for(int idx=0; idx<4; idx++){
                    int i = cur[0] + di[idx];
                    int j = cur[1] + dj[idx];

                    if(i<0 || i>=maps.length || j<0 || j>=maps[0].length()) continue;
                    if(maps[i].charAt(j) == 'X') continue;

                    q.offer(new int[]{i, j, cur[2]+1});
                }

            }
            
            if(dest[dest_idx][0] != cur[0] || dest[dest_idx][1] != cur[1]){
                return -1;
            }
        }
        
        return cur[2] == 0? -1 : cur[2];
    }
}