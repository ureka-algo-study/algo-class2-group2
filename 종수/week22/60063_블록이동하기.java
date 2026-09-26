package 종수.week22;

import java.util.*;

class Solution {
    int[][] map;
    boolean[][][][] visited;
    int n;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int[][] board) {
        n = board.length;

        // 가장자리를 벽으로 감싸서 범위 검사 생략
        map = new int[n + 2][n + 2];

        for (int[] row : map) {
            Arrays.fill(row, 1);
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                map[r + 1][c + 1] = board[r][c];
            }
        }

        visited = new boolean[n + 2][n + 2][n + 2][n + 2];

        Queue<int[]> q = new ArrayDeque<>();

        // 시작 위치: (1,1), (1,2)
        q.offer(new int[]{1, 1, 1, 2, 0});
        visited[1][1][1][2] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r1 = cur[0];
            int c1 = cur[1];
            int r2 = cur[2];
            int c2 = cur[3];
            int dist = cur[4];

            // 두 칸 중 하나가 목적지에 도착
            if ((r1 == n && c1 == n) ||
                (r2 == n && c2 == n)) {
                return dist;
            }

            // 1. 상하좌우 평행 이동
            for (int d = 0; d < 4; d++) {
                int nr1 = r1 + dr[d];
                int nc1 = c1 + dc[d];
                int nr2 = r2 + dr[d];
                int nc2 = c2 + dc[d];

                if (map[nr1][nc1] == 0 &&
                    map[nr2][nc2] == 0) {

                    add(q, nr1, nc1, nr2, nc2, dist + 1);
                }
            }

            // 2. 회전
            if (r1 == r2) {
                // 가로 상태: 위 또는 아래로 회전
                for (int d : new int[]{-1, 1}) {
                    if (map[r1 + d][c1] == 0 &&
                        map[r2 + d][c2] == 0) {

                        // 왼쪽 칸을 축으로 회전
                        add(q, r1, c1,
                               r1 + d, c1, dist + 1);

                        // 오른쪽 칸을 축으로 회전
                        add(q, r2, c2,
                               r2 + d, c2, dist + 1);
                    }
                }
            } else {
                // 세로 상태: 왼쪽 또는 오른쪽으로 회전
                for (int d : new int[]{-1, 1}) {
                    if (map[r1][c1 + d] == 0 &&
                        map[r2][c2 + d] == 0) {

                        // 위쪽 칸을 축으로 회전
                        add(q, r1, c1,
                               r1, c1 + d, dist + 1);

                        // 아래쪽 칸을 축으로 회전
                        add(q, r2, c2,
                               r2, c2 + d, dist + 1);
                    }
                }
            }
        }

        return -1;
    }

    void add(Queue<int[]> q,
             int r1, int c1, int r2, int c2, int dist) {

        // 좌표 순서를 일정하게 유지
        if (r1 > r2 || (r1 == r2 && c1 > c2)) {
            int temp = r1;
            r1 = r2;
            r2 = temp;

            temp = c1;
            c1 = c2;
            c2 = temp;
        }

        if (visited[r1][c1][r2][c2]) {
            return;
        }

        visited[r1][c1][r2][c2] = true;
        q.offer(new int[]{r1, c1, r2, c2, dist});
    }
}