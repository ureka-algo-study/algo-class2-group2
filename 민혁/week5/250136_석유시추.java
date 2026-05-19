import java.util.*;

class Solution {

    static boolean[][] visited;
    static int[][] Land;
    static int column, row;
    static int[] oilColumn;
    static int answer = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] land) {
        // 1열부터 n열까지 세로로 시추(한 열씩 최대값 저장, visited 초기화, 석유를 찾으면 bfs, count++)
        Land = land;
        column = land[0].length;
        row = land.length;
        visited = new boolean[row][column];
        oilColumn = new int[column];

        for(int x = 0; x < column; x ++) {
            for(int y = 0; y < row ; y ++) {
                if(Land[y][x] == 1 && !visited[y][x]) {
                    bfs(x,y);
                }
            }
        }

        for(int i : oilColumn) {
            answer = Math.max(answer,i);
        }

        return answer;
    }

    public static void bfs(int i, int j) {

        Deque<int[]> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int count = 0;

        visited[j][i] = true;
        q.add(new int[]{i,j});


        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            set.add(curX);
            count++;

            for(int a = 0; a < 4; a ++) {
                int x = curX + dx[a];
                int y = curY + dy[a];

                if(x >= 0 && x < column && y >= 0 && y < row) {
                    if(!visited[y][x] && Land[y][x] == 1) {
                        visited[y][x] = true;
                        q.add(new int[] {x,y});
                    }
                }
            }
        }
        for(int n : set) {
            oilColumn[n] += count;
        }
    }

}

