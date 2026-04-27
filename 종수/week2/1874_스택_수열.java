package 종수.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    // 배열이 주어지고. 해당 배열을 만들 수 있는지 판별
    // 만들 수 있다면 만드는 과정을 +(push)와 -(pop)로 구분지어 출력
    // 불가능 하면 NO 출력
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int size = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine()); // 일단 입력을 받고
            //스택에 1부터 값을 차례대로 push를 하다가
            // size와 x 값이 같다 -> pop
            // 그리고 다음 입력
            while(size <= x){
                stack.push(size++);
                sb.append("+\n");
            }
            
            if(stack.peek() == x){
                stack.pop();
                sb.append("-\n");
            } else{ // peek와 x 의 값이 같지 않으면 수열이 불가능한 경우
                System.out.println("NO");
                return;
            }
            
        } 

        System.out.println(sb);

    }//psvm

}//class
