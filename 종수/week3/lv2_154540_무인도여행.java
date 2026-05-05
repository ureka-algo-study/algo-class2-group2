package 종수.week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};

        int N = maps.length;
        int M = maps[0].length();
        int map[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = c - '0';
                }
                System.out.print(map[i][j]);
            } // for
            System.out.println();
        } // for

        boolean visited[][] = new boolean[N][M];

        int dx[] = { 1, -1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };

        List<Integer> arr = new ArrayList<>();

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {

                if(visited[j][k] == true || map[j][k] == 0) continue;
                int sum = map[j][k];
                Queue<int[]> queue = new ArrayDeque<>();

                queue.offer(new int[] { j, k });
                visited[j][k] = true;
                
                while (!queue.isEmpty()) {
                    int cur[] = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                            continue;
                        if (visited[nx][ny] == true)
                            continue;
                        if (map[nx][ny] == 0)
                            continue;
                        

                        sum += map[nx][ny];

                        visited[nx][ny] = true;
                        queue.offer(new int[] { nx, ny });
                    } // for


                } // while
                arr.add(sum);
            } // for
        } // for
        answer = new int[arr.size()];


        if(arr.isEmpty()){
            return answer = new int[] {-1}; 
        }
        
        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }// solution
}// Solution












// import java.util.ArrayDeque;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Queue;

// class Solution {
//     public int[] solution(String[] maps) {
//         int[] answer = {};

//         int n = maps[0].length();
//         int m = maps.length;

//         int map[][] = new int[n][m];

//         for (int i = 0; i < m; i++) {
//             maps[i] = maps[i].replace("X", "0");
//             for (int j = 0; j < n; j++) {
//                 map[j][i] = maps[i].charAt(j) - '0';
//                 System.out.print(map[j][i] + " ");
//             }
//             System.out.println();
//         }

//         int dx[] = { 1, -1, 0, 0 };
//         int dy[] = { 0, 0, 1, -1 };

//         // int 결과담을 변수
//         boolean visited[][] = new boolean[n][m];

//         List<Integer> result = new ArrayList<>();

//         for (int a = 0; a < n; a++) {
//             for (int b = 0; b < m; b++) {

//                 if(map[a][b] == 0 || visited[a][b]) continue;

//                 int sum = 0;

//                 Queue<int[]> queue = new ArrayDeque<>();

//                 queue.offer(new int[] { a, b });
//                 visited[a][b] = true;

//                 while (!queue.isEmpty()) {

//                     int now[] = queue.poll();
//                     int x = now[0];
//                     int y = now[1];

//                     sum += map[x][y];

//                     for (int i = 0; i < 4; i++) {

//                         int nx = x + dx[i];
//                         int ny = y + dy[i];

//                         if (nx >= n || ny >= m || nx < 0 || ny < 0)
//                             continue;
//                         if (map[nx][ny] == 0)
//                             continue;
//                         if (visited[nx][ny] == true)
//                             continue;

//                         visited[nx][ny] = true;

//                         queue.offer(new int[] { nx, ny });
//                     }

//                 }

//                 result.add(sum);

//             }
//         }

//         if (result.size() == 0) return new int[]{-1};

//         Collections.sort(result);

//         answer = new int[result.size()];
//         for(int i = 0; i < result.size(); i++){
//             answer[i] = result.get(i);
//         }

//         return answer;
//     }
// }