package 종수.week22;
import java.util.*;

class Solution {

    // 상, 우, 하, 좌
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        // visited[행][열][방향]
        boolean[][][] visited = new boolean[n][m][4];

        List<Integer> answer = new ArrayList<>();

        // 모든 칸에서 4가지 방향으로 출발
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {

                    if (visited[i][j][d]) {
                        continue;
                    }

                    int x = i;
                    int y = j;
                    int dir = d;
                    int count = 0;

                    // 방문했던 (위치, 방향)에 돌아올 때까지 반복
                    while (!visited[x][y][dir]) {

                        visited[x][y][dir] = true;
                        count++;

                        // 현재 칸에 따라 진행 방향 변경
                        char c = grid[x].charAt(y);

                        if (c == 'L') {
                            dir = (dir + 3) % 4;
                        } else if (c == 'R') {
                            dir = (dir + 1) % 4;
                        }

                        // 다음 칸으로 이동
                        x = (x + dx[dir] + n) % n;
                        y = (y + dy[dir] + m) % m;
                    }

                    answer.add(count);
                }
            }
        }

        // 사이클 길이를 오름차순 정렬
        Collections.sort(answer);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}