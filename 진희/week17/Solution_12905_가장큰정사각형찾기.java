package study.week17;

public class Solution_12905_가장큰정사각형찾기 {
    public int solution(int [][]board)
    {
        int r = board.length;
        int c = board[0].length;

        int[][] dp = new int [r][c];

        int max = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 0) continue;

                if (i == 0 || j == 0) dp[i][j] = board[i][j];
                else {
                    int num = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    dp[i][j] = num + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        } //for

        return max * max;
    }
}
