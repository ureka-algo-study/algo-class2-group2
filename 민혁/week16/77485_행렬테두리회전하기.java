import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        /*
        배열만들기
        배열을 4개로 분할해서 저장(상우하좌)
        배열 중 가장 작은 값 정답에 추가
        0번째부터 n-1번째까지 한칸씩 이동
        쿼리가 2254일때 5-2 4-2 세로가로 x1 y1 x2 y2
        */
        
        List<Integer> list = new ArrayList<>();
        
        // 보드 생성
        int n = 1;
        int[][] board = new int[rows][columns];
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j ++) {
                board[i][j] = n;
                n++;
            }
        } //check
        
        for(int[] query : queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            
            int[] upper = new int[y2 - y1];
            int[] right = new int[x2 - x1];
            int[] lower = new int[y2 - y1];
            int[] left = new int[x2 - x1]; //check

            // 상우하좌
            for (int i = 0; i < upper.length; i++) {
                upper[i] = board[x1 - 1][y1 - 1 + i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = board[x1 - 1 + i][y2 - 1];
            }

            for (int i = 0; i < lower.length; i++) {
                lower[i] = board[x2 - 1][y2 - 1 - i];
            }

            for (int i = 0; i < left.length; i++) {
                left[i] = board[x2 - 1 - i][y1 - 1];
            }

            // 가장 작은 값 일단 저장
            int length  = 2 * (x2 - x1 + y2 - y1);
            int[] minArray = new int[length];
            
            for(int i = 0; i < upper.length; i ++) {
                minArray[i] = upper[i];
            }
            for(int i = 0; i < right.length; i ++) {
                minArray[i + upper.length] = right[i];
            }
            for(int i = 0; i < lower.length; i ++) {
                minArray[i + upper.length + right.length] = lower[i];
            }
            for(int i = 0; i < left.length; i ++) {
                minArray[i + upper.length + right.length + lower.length] = left[i];
            }
            
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < minArray.length; i ++) {
                min = Math.min(min,minArray[i]);
            }
            list.add(min);

            // 시계방향 이동 시작
            // 상
            for(int i = 0; i < upper.length; i++) {
                board[x1 - 1][y1 + i] = upper[i]; 
            }

            // 우
            for(int i = 0; i < right.length; i++) {
                 board[x1 + i][y2 - 1] = right[i];
            }
            // 하
            for(int i = 0; i < lower.length; i++) {
                board[x2 - 1][y2 - 2 - i] = lower[i];
            }
            // 좌
            for(int i = 0; i < left.length; i++) {
                 board[x2 - 2 - i][y1 - 1] = left[i];
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
