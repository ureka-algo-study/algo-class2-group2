import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 987654321;
        
        Queue<int[]> q = new LinkedList<>();
        int N = board.length;
        boolean[][][][] visited = new boolean[N][N][N][N];
        
        q.offer(new int[]{0,0,0,1,0,0}); // x1,y1,x2,y2,pos,time
        
        visited[0][0][0][1] = true;
        visited[0][1][0][0] = true;
        
        int[] dx = {-1, 1, 0, 0}; // U D L R
        int[] dy = {0, 0, -1, 1};
        
        int[][] dx1 = {{0,0,-1,1}, // LU LD RU RD
                     {0,0,1,1}}; // UL UR DL DR
        int[][] dy1 = {{0,0,1,1},
                     {-1,0,-1,0}};
        int[][] dx2 = {{-1,1,0,0},
                     {0,0,1,1}};
        int[][] dy2 = {{0,0,1,1},
                     {0,1,0,1}};
        int[][] ddirx = {{-1,1,-1,1},
                      {1,1,0,0}};
        int[][] ddiry = {{1,1,0,0},
                      {-1,1,-1,1}};
        
        
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            int x2 = cur[2];
            int y2 = cur[3];
            int pos = cur[4];
            int time = cur[5];
            
            if((x1 == N-1 && y1 == N-1) || (x2 == N-1 && y2 == N-1)){
                answer = Math.min(answer, time);
                return answer;
            }
            
            // 직선 이동
            for(int i=0; i<dx.length; i++){
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];
                
                if(nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= N
                  || nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= N) continue;
                if(board[nx1][ny1] == 1 || board[nx2][ny2] == 1) continue;
                if(visited[nx1][ny1][nx2][ny2]) continue;
                
                visited[nx1][ny1][nx2][ny2] = true;
                visited[nx2][ny2][nx1][ny1] = true;
                
                q.offer(new int[]{nx1, ny1, nx2, ny2, pos, time+1});
            } //for
            
            // 회전
            for(int i=0; i<dx.length; i++){
                int nx1 = x1 + dx1[pos][i];
                int ny1 = y1 + dy1[pos][i];
                int nx2 = x1 + dx2[pos][i];
                int ny2 = y1 + dy2[pos][i];
                int dirx = x1 + ddirx[pos][i];
                int diry = y1 + ddiry[pos][i];
                
                if(nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= N
                  || nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= N
                  || dirx < 0 || dirx >= N || diry < 0 || diry >= N) continue;
                if(board[nx1][ny1] == 1 || board[nx2][ny2] == 1 || board[dirx][diry] == 1) continue;
                if(visited[nx1][ny1][nx2][ny2]) continue;
                
                visited[nx1][ny1][nx2][ny2] = true;
                visited[nx2][ny2][nx1][ny1] = true;
                
                q.offer(new int[]{Math.min(nx1, nx2), Math.min(ny1, ny2), 
                                  Math.max(nx1, nx2), Math.max(ny1, ny2), (pos + 1)  % 2, time+1});
            }
            
            
        }
        return answer;
    }
}