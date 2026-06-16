import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        // 시작 위치 찾아야함
        int[] start = new int[2];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            } //j
        } //i

        boolean[][] visited = new boolean[board.length][board[0].length()];
        int[][] count = new int[board.length][board[0].length()];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();


            if(board[cur[0]].charAt(cur[1]) == 'G') {
                return count[cur[0]][cur[1]];
            }

            for(int i = 0; i < 4; i ++) {
                int curX = cur[0];
                int curY = cur[1];
                while(true) {
                    int nextX = curX + dx[i]; // 계속 전진
                    int nextY = curY + dy[i];


                    if(nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length()) {
                        break; // 벽이면 끝
                    }

                    if(board[nextX].charAt(nextY) == 'D') {
                        break; // 장애물이면 끝
                    }
                    curX = nextX;
                    curY = nextY;
                } //while

                if(!visited[curX][curY]) {
                    count[curX][curY] = count[cur[0]][cur[1]] + 1;
                    visited[curX][curY] = true;
                    q.offer(new int[]{curX,curY});
                }
            } //for
        } //while
        return -1;




    }
}