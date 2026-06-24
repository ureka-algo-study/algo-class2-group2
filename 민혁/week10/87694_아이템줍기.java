import java.util.*;

class Solution {
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {

//         int[][] board = new int[51][51]; // 지도 (0,0) 부터 (50,50) 까지
//         boolean[][] visited = new boolean[51][51]; // 방문체크

//         for(int[] rectangle : rectangles) {



//             int leftBottomX = rectangle[0];
//             int leftBottomY =51 - rectangle[1];
//             int rightTopX = rectangle[2];
//             int rightTopY = 51 - rectangle[3];

//             for(int i = rightTopY; i <= leftBottomY; i ++) {
//                 for(int j = leftBottomX; j <= rightTopX; j ++) {
//                     board[i][j] = 1;
//                 }
//             }
//         }//rectangle

//         for(int[] rectangle : rectangles) {

//             int leftBottomX = rectangle[0] + 1;
//             int leftBottomY = 51 - rectangle[1] - 1;
//             int rightTopX = rectangle[2] - 1;
//             int rightTopY = 51 - rectangle[3] + 1;

//             for(int i = rightTopY; i <= leftBottomY; i ++) {
//                 for(int j = leftBottomX; j <= rightTopX; j ++) {
//                     board[i][j] = 0;
//                 }
//             }
//         } //rectangle

//         // =========

//         int[] dx = {0,0,-1,1};
//         int[] dy = {1,-1,0,0};
//         ArrayDeque<int[]> q = new ArrayDeque<>();


//         q.add(new int[] {characterX, characterY,0});
//         visited[51 - characterY][characterX] = true; // 이 부분



//         while(!q.isEmpty()) {
//             int[] cur = q.poll();
//             int curX = cur[0];
//             int curY = cur[1];
//             int dist = cur[2];



//             if(curX == itemX && curY == itemY) { // 발견
//                 return dist;
//             }

//             for(int i = 0; i < 4; i ++) {
//                 int nextX = curX + dx[i];
//                 int nextY = curY + dy[i];

//                 if(nextX <= 0 || nextX >= 51 || nextY <= 0 || nextY >= 51) {
//                     continue;
//                 }

//                 if(board[51 - nextY][nextX] == 0 || visited[51 - nextY][nextX]) {
//                     continue;
//                 }


//                 visited[51 - nextY][nextX] = true;
//                 q.add(new int[] {nextX, nextY, dist + 1});
//             }//for
//         } // while

//         return -1; 선분이 겹치는 경우를 표현 못함

        int[][] board = new int[102][102];
        boolean[][] visited = new boolean[102][102];

        // 1. 사각형 전체 칠하기
        for (int[] rectangle : rectangles) {
            int leftX = rectangle[0] * 2;
            int leftY = rectangle[1] * 2;
            int rightX = rectangle[2] * 2;
            int rightY = rectangle[3] * 2;

            for (int y = leftY; y <= rightY; y++) {
                for (int x = leftX; x <= rightX; x++) {
                    board[y][x] = 1;
                }
            }
        }

        // 2. 내부 지우기
        for (int[] rectangle : rectangles) {
            int leftX = rectangle[0] * 2;
            int leftY = rectangle[1] * 2;
            int rightX = rectangle[2] * 2;
            int rightY = rectangle[3] * 2;

            for (int y = leftY + 1; y <= rightY - 1; y++) {
                for (int x = leftX + 1; x <= rightX - 1; x++) {
                    board[y][x] = 0;
                }
            }
        }

        int startX = characterX * 2;
        int startY = characterY * 2;
        int targetX = itemX * 2;
        int targetY = itemY * 2;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY, 0});
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int curX = cur[0];
            int curY = cur[1];
            int dist = cur[2];

            if (curX == targetX && curY == targetY) {
                return dist / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= 102 || nextY < 0 || nextY >= 102) {
                    continue;
                }

                if (board[nextY][nextX] == 0 || visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;
                q.add(new int[] {nextX, nextY, dist + 1});
            }
        }

        return -1;

    }
}