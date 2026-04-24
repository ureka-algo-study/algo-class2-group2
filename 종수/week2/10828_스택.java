package 종수.week2;

import java.util.Scanner;

class Main {
    static int MaxStackSize = 10000;
    static int[] result = new int[MaxStackSize];// 실제 스택 배열
    static int size = 0; //스택 하나의 사이즈를 전역으로 선언

    private static void push(int x) {
        result[size++] = x;
    }// push

    private static int pop() {
        if (size == 0)
            return -1;
        else
            return result[--size];
    }// pop

    private static int size() {
        return size;
    }// size

    private static int empty() {
        return size == 0 ? 1 : 0;
    }// empty

    private static int top() {
        if (size == 0)
            return -1;
        else
            return result[size()-1];
    }// top

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            String stack = sc.nextLine();// 입력 받을 변수
            
            if (stack.startsWith("push")) {
                // System.out.print("push 실행 : ");
                String[] cmd = stack.split(" "); 
                //입력받은걸 공백을 기준으로 자르고 두번째에 나온 문자를 인트로 바꿔서 push 함수에 입력
                push(Integer.parseInt(cmd[1]));
            } else if (stack.equals("pop")) { 
                // 처음에 contain을 쓴 이유는 처음 push를 작성할 때 
                // 해당 문자를 포함하기만 하면 되지 않나라는 생각에 contain 사용\
                //-> 시간초과 나
                // System.out.print("pop 실행 : ");
                System.out.println(pop());
            } else if (stack.equals("size")) {
                // System.out.print("size 실행 : ");
                System.out.println(size());
            } else if (stack.equals("empty")) {
                // System.out.print("empty 실행 : ");
                System.out.println(empty());
            } else if (stack.equals("top")) {
                // System.out.print("top 실행 : ");
                System.out.println(top());
            }

        } // for
        sc.close();

    }
}
