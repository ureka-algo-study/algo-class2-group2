package 종수.week12;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] newboard = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newboard[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            boolean[][] remove = new boolean[m][n];
            boolean hasRemove = false;

            // 현재 칸을 왼쪽 위 기준으로 시계방향 검사
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {

                    char cur = newboard[i][j];

                    if (cur == ' ')
                        continue;

                    if (cur == newboard[i][j + 1]
                            && cur == newboard[i + 1][j]
                            && cur == newboard[i + 1][j + 1]) {

                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j] = true;
                        remove[i + 1][j + 1] = true;

                        hasRemove = true;
                    }
                }
            }

            // 제거할 게 없으면 종료
            if (!hasRemove)
                break;

            // 표시된 블록 제거
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        newboard[i][j] = ' ';
                        answer++;
                    }
                }
            }

            // 4. 아래로 떨어뜨려버리기
            for (int j = 0; j < n; j++) {
                int drop = m - 1;

                for (int i = m - 1; i >= 0; i--) {
                    if (newboard[i][j] != ' ') {
                        newboard[drop][j] = newboard[i][j];
                        drop--;
                    }
                }

                for (int i = drop; i >= 0; i--) {
                    newboard[i][j] = ' ';
                }
            }
        }

        return answer;
    }
}
// 높이 폭
// m n board answer
// 4 5 ["CCBDE", "AAADE", "AAABF", "CCBBF"] 14
// 6 6 ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"] 15