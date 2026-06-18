class Solution {
    public int[] solution(int n) {
        class Loc {
            int row = 0;
            int col = 0;
        }

        int[][] snail = new int[n][n];
        Loc loc = new Loc();

        // 아래 오른쪽 대각
        int[][] direction = {{1, 0}, {0, 1}, {-1, -1}};

        int dir = 0; // 막힐때마다 방향전환 변수
        int total = n * (n + 1) / 2; // 전체 개수

        for (int i = 1; i <= total; i++) {
            snail[loc.row][loc.col] = i;

            int nextRow = loc.row + direction[dir][0];
            int nextCol = loc.col + direction[dir][1];

            // 벽에 막히거나 이미 채워졌으면
            if (nextRow < 0 || nextRow >= n ||nextCol < 0 || nextCol >= n ||snail[nextRow][nextCol] != 0) {
                //방향 전환
                dir = (dir + 1) % 3; //0 -> 1 -> 2 -> 0 -> 1 -> 2..
                nextRow = loc.row + direction[dir][0]; // 다음 행선지 다시 설정
                nextCol = loc.col + direction[dir][1];
            }

            loc.row = nextRow;
            loc.col = nextCol;
        }
        // snail 출력 결과에 담기
        int[] result = new int[total];
        int idx = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(snail[i][j] == 0) {
                    continue;
                }
                result[idx] = snail[i][j];
                idx++;
            }
        } // for

        return result;

    }
}