package 종수.week10;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        int map[][] = new int[102][102];
        for (int i = 0; i < rectangle.length; i++) {

            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    if (map[y][x] != 2) { // 이미 2로 바뀐곳이 변경되지 않게
                        map[y][x] = 1;
                    }
                }
            } // 사각형 색칠

            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    map[y][x] = 2;
                }
            } // 내부 테두리를 제외한 부분을 2로 변경

        }

        int n = map.length;
        int m = map[0].length;

        int dx[] = { 1, -1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        q.offer(new int[] { characterX, characterY });
        visited[characterY][characterX] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == itemX && y == itemY) {
                return dist[y][x] / 2;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (visited[ny][nx])
                    continue;
                if (map[ny][nx] != 1)
                    continue;

                visited[ny][nx] = true;
                dist[ny][nx] = dist[y][x] + 1;
                q.offer(new int[] { nx, ny });
            }
        }

        // 맵 확인용
        // for (int y = 0; y < map.length; y++) {
        //     for (int x = 0; x < map[0].length; x++) {
        //         System.out.print(map[y][x] + " ");
        //     }
        //     System.out.println();
        // }

        return answer;
    }
}