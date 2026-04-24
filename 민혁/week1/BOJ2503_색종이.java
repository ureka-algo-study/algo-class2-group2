package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class BOJ2503_색종이 {
    /*
    1. 빈 도화지 생성
    2. 색종이 수만큼 반복(n)
        - 색종이를 빈도화지에 색칠
    3. 색칠된 칸 카운트

    총 시간 복잡도 O(n)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 색종이 수 입력받기

        // 1. 빈 도화지 생성
        boolean[][] painted = new boolean[100][100];

        // 2. 색종이 수만큼 빈 도화지 색칠하기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            paint(x, y, painted);
        }

        // 3. 색칠된 칸 카운트
        int count = 0;
        for(int i =0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(painted[i][j]) {
                    count++;
                }
            }
        }
        // 4. 결과 출력
        System.out.println(count);
    }

    // 도화지에 색종이를 색칠하는 static 메서드
    public static void paint(int x, int y,boolean[][] painted) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(painted[x + j][90 - y + i]) {
                    continue;
                } // 중복체크 이미 색칠되어 있으면 다시 if문으로
                painted[x + j][90 - y + i] = true;
            }
        }
    }
}
