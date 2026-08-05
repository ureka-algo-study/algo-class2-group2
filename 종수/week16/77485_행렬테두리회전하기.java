package 종수.week16;

class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];

        int number = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = number++;
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < queries.length; i++) {

            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int x = x1;
            int y = y1;
            int dir = 0;

            int previous = board[x][y];
            int min = previous;

            int count = 2 * ((x2 - x1) + (y2 - y1));

            for (int j = 0; j < count; j++) {

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < x1 || nx > x2 || ny < y1 || ny > y2) {
                    dir++;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                int temp = board[nx][ny];

                board[nx][ny] = previous;
                previous = temp;

                min = Math.min(min, previous);

                x = nx;
                y = ny;
            }

            answer[i] = min;
        }

        return answer;
    }

}