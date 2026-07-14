class Solution {

    static int[][] Arr;
    static int[] answer;

    public int[] solution(int[][] arr) {
        /*
        압축하고자 하는 특정 영역
        전체영역 -> 가로세로/2 -> 가로세로/2 -> 가로세로/2
        */

        Arr = arr;
        answer = new int[2];

        //전체
        minimize(0,0,arr.length);

        return answer;


    }

    private void minimize(int row, int col, int size) {

        int startValue = Arr[row][col];
        boolean sameFlag = true;

        for(int i = row; i < row+size; i ++) {
            for(int j = col; j < col+size; j++) {
                if(Arr[i][j] != startValue) {
                    sameFlag = false;
                    break;
                }

                if(!sameFlag) {
                    break;
                }
            }
        }

        if(sameFlag) {
            answer[startValue]++;
            return;
        }

        int half = size / 2;

        minimize(row, col, half);
        minimize(row, col + half, half);
        minimize(row + half, col, half);
        minimize(row + half, col + half, half);
    }

}