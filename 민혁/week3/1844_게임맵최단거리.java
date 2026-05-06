import java.util.*;

public class Solution {
	
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
    static int[][] dist;
    static int N;
    static int M;
    
	
	public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        
        dist = new int[N][M];
        dist[0][0] = 1; 
        
        visited = new boolean[N][M];
        
        bfs(maps);
        
        if(!visited[N-1][M-1]) {
            return -1;
        } 
        
        return dist[N-1][M-1];
        
    }
    
    public static void bfs(int[][]maps) {
        Deque<int[]> q = new ArrayDeque<>(); 
        
        visited[0][0] = true;
        q.offer(new int[] {0,0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i ++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M ) { 
                    continue;
                }
                
                if(!visited[nx][ny] && maps[nx][ny] == 1) {
                    q.offer(new int[] {nx,ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                } 
            }
        }
    }

	

}
