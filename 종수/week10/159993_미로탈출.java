package 종수.week10;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        int start[] = new int[2];
        int lever[] = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }

            }
        }

        int tolever = bfs(maps, start, 'L');

        if (tolever == -1)
            return -1;

        int toexit = bfs(maps, lever, 'E');

        if (toexit == -1)
            return -1;

        return tolever + toexit;

    }

    private int bfs(String[] maps, int[] start, char target) {

        int n = maps.length;
        int m = maps[0].length();

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        // 시작 좌표와 현재 거리를 큐에 저장
        q.offer(new int[] { start[0], start[1], 0 });
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 목표를 찾으면 현재까지의 거리 반환
            if (maps[x].charAt(y) == target)
                return dist;

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (visited[nx][ny])
                    continue;

                if (maps[nx].charAt(ny) == 'X')
                    continue;

                visited[nx][ny] = true;

                q.offer(new int[] { nx, ny, dist + 1 });
            }
        }

        // 목표를 끝까지 찾지 못한 경우
        return -1;
    }
}