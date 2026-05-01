package 종수.week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};

        int n = maps[0].length();
        int m = maps.length;

        int map[][] = new int[n][m];

        for (int i = 0; i < m; i++) {
            maps[i] = maps[i].replace("X", "0");
            for (int j = 0; j < n; j++) {
                map[j][i] = maps[i].charAt(j) - '0';
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }

        int dx[] = { 1, -1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };

        // int 결과담을 변수
        boolean visited[][] = new boolean[n][m];

        List<Integer> result = new ArrayList<>();

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {

                if(map[a][b] == 0 || visited[a][b]) continue;

                int sum = 0;

                Queue<int[]> queue = new ArrayDeque<>();

                queue.offer(new int[] { a, b });
                visited[a][b] = true;

                while (!queue.isEmpty()) {

                    int now[] = queue.poll();
                    int x = now[0];
                    int y = now[1];

                    sum += map[x][y];

                    for (int i = 0; i < 4; i++) {

                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= n || ny >= m || nx < 0 || ny < 0)
                            continue;
                        if (map[nx][ny] == 0)
                            continue;
                        if (visited[nx][ny] == true)
                            continue;

                        visited[nx][ny] = true;

                        queue.offer(new int[] { nx, ny });
                    }

                }

                result.add(sum);

            }
        }

        if (result.size() == 0) return new int[]{-1};

        Collections.sort(result);

        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}