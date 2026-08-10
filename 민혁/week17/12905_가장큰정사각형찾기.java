class Solution {

    public int solution(int[][] board) {

        /*
        모든 칸을 검사 정사각형의 왼쪽 위 시작점
        */
        
        int rows = board.length;
        int cols = board[0].length;

        int maxSize = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // 시작점이 0이면 정사각형 불가능
                if (board[i][j] == 0) {
                    continue;
                }

                // 최소 1x1은 가능
                int size = 1;

                maxSize = Math.max(maxSize, size);

                // 2x2, 3x3, 4x4 ... 확장
                while (true) {

                    int nextSize = size + 1;

                    // board 범위를 벗어나지 말아야함
                    if (i + nextSize > rows ||
                        j + nextSize > cols) {
                        break;
                    }

                    boolean possible = true;

                    // 새로 추가되는 아래쪽 행 검사
                    int bottomRow = i + nextSize - 1;

                    for (int c = j; c < j + nextSize; c++) {
                        if (board[bottomRow][c] == 0) {
                            possible = false;
                            break;
                        }
                    }

                    // 새로 추가되는 오른쪽 열 검사
                    int rightCol = j + nextSize - 1;
                    
                    if (possible) {
                        for (int r = i; r < i + nextSize; r++) {

                            if (board[r][rightCol] == 0) {
                                possible = false;
                                break;
                            }
                        }
                    }

                    // 확장 실패
                    if (!possible) {
                        break;
                    }

                    // 확장 성공
                    size = nextSize;

                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize * maxSize;
    }
}
