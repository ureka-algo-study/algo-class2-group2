package 종수.week13;

class Solution {

    int[][] arr;
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        this.arr = arr;

        compress(0, 0, arr.length);

        return answer;
    }

    public void compress(int x, int y, int size) {

        // 현재 영역이 모두 같은 숫자인지 확인
        if (isSame(x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        // 다르면 4등분
        int half = size / 2;

        compress(x, y, half);                 // 왼쪽 위
        compress(x, y + half, half);          // 오른쪽 위
        compress(x + half, y, half);          // 왼쪽 아래
        compress(x + half, y + half, half);   // 오른쪽 아래
    }

    // 현재 영역이 모두 같은 값인지 검사
    public boolean isSame(int x, int y, int size) {

        int value = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}