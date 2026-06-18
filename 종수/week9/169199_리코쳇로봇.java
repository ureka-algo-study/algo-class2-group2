package 종수.week9;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String[] board) {

        int dx[] = { 1, -1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };

        int startx = 0;
        int starty = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    startx = i;
                    starty = j;
                }
            }
        }

        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { startx, starty, 0 });
        visited[startx][starty] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (board[x].charAt(y) == 'G') {
                return cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;

                // 범위 안이고 D가 아니면
                while (true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];

                    // 범위를 벗어나거나 장애물을 만나면 멈춤
                    if (tx < 0 || tx >= board.length
                            || ty < 0 || ty >= board[0].length()
                            || board[tx].charAt(ty) == 'D') {
                        break;
                    }

                    nx = tx;
                    ny = ty;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;
    }
}