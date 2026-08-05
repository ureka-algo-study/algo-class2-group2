package study.week16;

public class Solution_77485_행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];

        for (int i = 0, num = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        } //for - insert map

        int idx = 0;
        for (int[] q : queries) {
            int r1 = q[0] - 1; // 시작 행
            int c1 = q[1] - 1; // 시작 열
            int r2 = q[2] - 1; // 끝 행
            int c2 = q[3] - 1; // 끝 열

            int tmp = map[r1][c1];
            int min = tmp;

            for (int i = r1; i < r2; i++) {
                map[i][c1] = map[i+1][c1];
                min = Math.min(min, map[i][c1]);
            } //위로 당기기

            for (int i = c1; i < c2; i++) {
                map[r2][i] = map[r2][i+1];
                min = Math.min(min, map[r2][i]);
            } //왼쪽으로 당기기

            for (int i = r2; i > r1; i--) {
                map[i][c2] = map[i-1][c2];
                min = Math.min(min, map[i][c2]);
            } //아래로 당기기

            for (int i = c2; i > c1; i--) {
                map[r1][i] = map[r1][i-1];
                min = Math.min(min, map[r1][i]);
            } //오른쪽으로 당기기

            map[r1][c1+1] = tmp;
            answer[idx++] = min;
        }

        return answer;
    }
}
