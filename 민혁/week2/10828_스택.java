package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    스택을 구현하는 문제
    스택이나 리스트 자료구조에 이미 다 구현되어 있지만 연습으로 배열로 구현
    문제에서 명령의 개수가 N(N <= 10000) 이니 배열 생성해서 처리해도 문제X 주어지는 정수는 1보다 크니 배열 상관X
    대신 뒤에서 넣고 뒤에서 꺼내는 구조
    앞에서 넣거나 꺼낼때는 배열의 모든 요소를 뒤로 밀어야하기 때문에 시간복잡도 증가
    그러기 위해 포인터를 이용해 문제를 풀 계획

    시간 복잡도 : O(n)
     */

    static int N;

    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 명령 개수 저장


        int[] myStack = new int[N]; // 스택 배열 구현

        int pointer = 0; // 포인터의 시작은 0을 가리킴

        StringBuilder sb = new StringBuilder(); // 최대 10000개 출력을 위한 스트링빌더

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push" :
                    myStack[pointer++] = Integer.parseInt(st.nextToken()); // 넣고 pointer 증가
                    break;
                case "pop" : //pointer가 배열의 마지막 다음을 가리키고 있으니 -1 하고 시행
                    if(pointer == 0) {
                        sb.append(-1).append('\n');
                    } else {
                        pointer--;
                        sb.append(myStack[pointer]).append('\n');
                        myStack[pointer] = 0;
                    }
                    break;
                case "size" : // 배열이 0부터 시작으니 pointer == size
                    sb.append(pointer).append('\n');
                    break;
                case "empty" :
                    sb.append(pointer == 0 ? 1 : 0).append('\n');
                    break;
                case "top" :
                    if(pointer == 0) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(myStack[pointer - 1]).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);

    }
}
