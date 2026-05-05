import java.util.*;

public class Solution {

    /*
    1. X를 발견하면 다음 탐색 가장 큰거로 계속해서 최신화 마지막에 남은 가장 큰값반환
    */
    static boolean[][] visited;
    static int N, M;
    static int Max = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> result = new ArrayList<>();

    public int[] solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    bfs(i, j, maps);
                }
            }
        }


        int[] result1 = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            result1[i] = result.get(i);
        }
        Arrays.sort(result1);

        if (result1.length == 0) {
            return new int[]{-1};
        }

        return result1;

    }

    static void bfs(int x, int y, String[] maps) {

        Deque<int[]> q = new ArrayDeque<>();

        visited[x][y] = true;
        q.offer(new int[]{x, y});

        int sum = maps[x].charAt(y) - '0';

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        sum += maps[nx].charAt(ny) - '0';
                    }
                }
            }
        } // while

        result.add(sum);


    }
}
