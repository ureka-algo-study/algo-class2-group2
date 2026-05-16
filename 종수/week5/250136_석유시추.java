package 종수.week5;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[] seoku;
    static int n,m;
    static int[][] lands;
    static int count;
    static Set<Integer> set;
    public int solution(int[][] land) {
        int answer = 0;
        lands = land;
        n = land.length;
        m = land[0].length;
        seoku = new int[m];


        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(!visited[i][j] && land[i][j] != 0){
                    count = 0;
                    set = new HashSet<>();
                    
                    bfs(i, j);
                    // dfs(i, j);

                    for(int x : set)
                        seoku[x] += count;
                }

            }//for
        }//for

        for(int i = 0; i < m; i++){
           answer = Math.max(answer, seoku[i]);
        }   

        return answer;
    }//solution


    static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});

        count++;
        set.add(y);

        visited[x][y] = true;

        while(!q.isEmpty()){
            int now[] = q.poll();

            for(int i = 0; i < 4; i++){

                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (lands[nx][ny] == 0)
                    continue;

                count++;
                set.add(ny);

                visited[nx][ny] = true;

                q.offer(new int[]{nx,ny});

            }


        }
    }
}//Solution

    // dfs로 풀이시 맵의 크기가 너무 커졌을 경우 스택오버플로우가 난다.
    // static void dfs(int x, int y){

    //     visited[x][y] = true;

    //     set.add(y);
    //     count++;

    //     for(int i = 0; i < 4; i++){

    //         int nx = x + dx[i];
    //         int ny = y + dy[i];

    //         if(nx < 0 || ny < 0 || nx >= n || ny >= m)
    //             continue;
    //         if(visited[nx][ny])
    //             continue;
    //         if(lands[nx][ny] == 0)
    //             continue;

    //         dfs(nx, ny);


    //     }

    // }//dfs
// }//Solution

// 석유 매장량을 확인 할 수 있는 2차원 배열을 만들고 
// 땅의 가로를 1차원 배열을 만들고 석유 매장량을 확인할때 해당 가로를 지나면 매장량 +