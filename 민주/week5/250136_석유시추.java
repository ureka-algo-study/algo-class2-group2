import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        
        
        boolean[][] visited = new boolean[land.length][land[0].length];
        int[] line = new int[land[0].length];
        
        int[] di = {0,0,-1,1};
        int[] dj = {1,-1,0,0};
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if((land[i][j] == 0) || visited[i][j]) continue;
                
                int cnt = 0;
                Queue<int[]> q = new LinkedList<>();
                boolean[] visited_line = new boolean[land[0].length];
                
                q.offer(new int[] {i,j});
                // System.out.println("offer: " + i + " " + j);
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    if(visited[cur[0]] [cur[1]]) continue;
                    // System.out.println("poll: " + cur[0] + " " + cur[1]);
                    cnt++;
                    visited[cur[0]] [cur[1]] = true;
                    visited_line[cur[1]] = true;
                    
                    for(int idx=0; idx<4; idx++){
                        int x = cur[0] + di[idx];
                        int y = cur[1] + dj[idx];
                        
                        if(x<0 || y<0 || x>= land.length || y>=land[0].length) continue;
                        if(visited[x][y] || (land[x][y] == 0) ) continue;
                        
                        q.offer(new int[]{x,y});
                        // System.out.println("offer: " + x + " " + y);
                    }
                }
//                 System.out.println("---------------");
//                 System.out.println(cnt);
                
                for(int k=0; k<land[0].length; k++){
                    line[k] += visited_line[k] ? cnt : 0;
                }
            }
        }
        
        // System.out.println(Arrays.toString(line));
        for(int i=0; i<land[0].length; i++){
            answer = Math.max(answer, line[i]);
        }
        return answer;
    }
}