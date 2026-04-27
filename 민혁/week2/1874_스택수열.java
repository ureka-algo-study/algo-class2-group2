package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    완전탐색 시도했으나 2^100000을 2 * 10000으로 착각해서 터져버림

    다른 방법 시도
    1. 만들어야할 수열의 수를 확인 (target number)
    2. 스택 맨위의 수가 target 보다 작으면 -> target까지 push
    3. 맨 위의 수가 target 이면 pop
    4. 반복
    5. 언제 "NO"가 확정될까? -> 맨 위의 수가 target이 아니면 목표수열을 만들수없음

    시간 복잡도 : O(n) (for문 안에 while이 있어서 O(n^2)인줄 알았으나 for loop 1회 반복마다 while문이 n번 반복하지 않아서 O(n))


     */

    static int N;
    static List<Integer> answer = new ArrayList<>(); // 목표 수열을 담아둘 리스트
    static Deque<Integer> stack = new ArrayDeque<>(); // 작업용 스택



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //  N 입력 받기
        N = Integer.parseInt(br.readLine());

        // 목표수열 입력받기
        for (int i = 0; i < N; i++) {
            answer.add(Integer.parseInt(br.readLine()));
        }
        // 처음에는 1부터 집어놓고 push할때마다 +1 하는 카운터
        int n = 1; // 집어넣을 수

        // 앞에서부터 목표수열을 찾기 시작
        for (int target : answer) {
            while(n <= target) { // 타겟보다 작으면 타겟까지 계속 push
                stack.push(n);
                sb.append("+\n");
                n++; // push할 때마다 넣는 수 1씩 증가
            }

            if(!stack.isEmpty() && stack.peek() == target) { //nullpointer exception 체크
                stack.pop();
                sb.append("-\n");
            } else { // 맨 위에 있는 값이 target이 아니면 목표 수열을 만들 수 없음
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);

    }


}
