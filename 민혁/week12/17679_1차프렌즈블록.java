import java.util.*;

class Solution {

    static int row = 0;
    static int column = 0;
    static char[][] Board;
    static Set<Integer> set = new HashSet<>();

    public int solution(int m, int n, String[] board) {
        /*
        우 하 대각 검사 같으면 -> set ('.'면 continue)
        set 좌표 -> '.'(empty)로 바꿈
        asnwer += set.size() -> set clear
        세로 검사 -> 빈공간 없애기
        set.size() == 0 일떄까지 반복
        */

        row = m;
        column = n;
        Board = new char[m][n];
        int answer = 0;

        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < column; j ++) {
                Board[i][j] = board[i].charAt(j);
            }
        } // board String -> char


        // 시작

        while(true) {
            for(int i = 0; i < row - 1 ; i ++) {
                for(int j = 0; j < column - 1; j ++) {
                    checkBreakable(i, j);
                }
            }

            if(set.size() == 0) {
                break;
            }

            for(int num : set) {
                int r = num / n;
                int c = num % n;

                Board[r][c] = '.';
            }

            answer += set.size();
            set.clear();


            arrangeBoard(); // '.' 인 좌표들 중력적용

        } // while

        return answer;

    }

    public void checkBreakable(int i, int j) {
        if(Board[i][j] == '.') {
            return;
        }

        if(Board[i][j] == Board[i + 1][j] &&
                Board[i][j] == Board[i][j + 1] &&
                Board[i][j] == Board[i + 1][j + 1]
        ) {
            set.add(i * column + j);
            set.add( (i + 1) * column + j);
            set.add(i * column + (j + 1) );
            set.add( (i + 1) * column + (j + 1) );
        }
    } //checkBreakable

    public void arrangeBoard() {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < column; i ++) {
            for(int j = 0; j < row; j ++) {
                if(Board[j][i] != '.') {
                    stack.push(Board[j][i]);
                    Board[j][i] = '.';
                }
            } //forj
            int k = 1;

            while (!stack.isEmpty()) {
                Board[row - k][i] = stack.pop();
                k++;
            } //while

        } //fori
    } //arrangeBoard
}