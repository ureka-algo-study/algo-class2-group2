import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        boolean[][] map = new boolean[51*2][51*2];
        boolean[][] visited = new boolean[51*2][51*2];
        
        for(int[] rect : rectangle){
            for(int y=rect[1]*2; y<=rect[3]*2; y++){
                for(int x=rect[0]*2; x<=rect[2]*2; x++){
                    map[y][x] = true;
                }
            }
        }
        
        for(int[] rect : rectangle){
            for(int y=rect[1]*2+1; y<rect[3]*2; y++){
                for(int x=rect[0]*2+1; x<rect[2]*2; x++){
                    map[y][x] = false;
                }
            }
        }
        
        // for(int i=0; i<map.length; i++){
        //     for(int j=0; j<map[0].length; j++){
        //         if(map[i][j]) System.out.print("O");
        //         else System.out.print(" ");
        //     }
        //     System.out.println();
        // }
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {characterY*2, characterX*2, 0});
        
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            
            if(visited[y][x]) continue;
            visited[y][x] = true;
            
            if(y == itemY*2 && x == itemX*2){
                return cur[2]/2;
            }
            
            for(int idx=0; idx<dy.length; idx++){
                int ny = y + dy[idx];
                int nx = x + dx[idx];
                
                if(ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                if(!map[ny][nx] || visited[ny][nx]) continue;
                
                q.offer(new int[]{ny, nx, cur[2]+1});
            }
        }
        return answer;
    }
}