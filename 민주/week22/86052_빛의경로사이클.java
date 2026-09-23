import java.util.*;

class Solution {
    boolean[][][] visited;
    int N;
    int M;
    String[] grid;
    ArrayList<Integer> ans = new ArrayList<>();
    
    int[] di = {0,0,-1,1}; // L R U D
    int[] dj= {-1,1,0,0}; // L R U D
    
    public int[] solution(String[] grid) {
        int[] answer = {};
        N = grid.length;
        M = grid[0].length();
        visited = new boolean[N][M][4];
        this.grid = grid;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int d=0; d<4; d++){
                    dfs(i,j,d);
                }
            }
        }
        answer = ans.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }
    
    void dfs(int x, int y, int dir){
        
        int cnt = 0;
        
        
        while(!visited[x][y][dir]){
            visited[x][y][dir] = true;
            cnt ++;
        
            
            if(grid[x].charAt(y) == 'L'){
                // L R U D
                // L(0) -> U(2), R(1) -> D(3), U(2) -> R(1), D(3) -> L(0)
                if(dir <= 1){
                    dir = (dir+2) % 4;
                }
                else{
                    dir = (3 - dir);
                }

            }
            else if(grid[x].charAt(y) == 'R'){
                // L R U D
                // L(0) -> D(3), R(1) -> U(2), U(2) -> L(0), D(3) -> R(1)
                if(dir <= 1){
                    dir = 3 - dir;
                }
                else{
                    dir = (dir-2);
                }
            }

            int nx = x + di[dir];
            int ny = y + dj[dir];

            if(nx < 0) {
                nx = N-1;
            }
            else if(nx >= N){
                nx = 0;
            }
            if(ny < 0){
                ny = M-1;
            }
            else if(ny >= M){
                ny = 0;
            }
            
            x = nx;
            y = ny;
        }
        if(cnt != 0){
            ans.add(cnt);
        }
        return;
        
        
        
        // dfs(nx, ny, dir, cnt+1);
    }
}