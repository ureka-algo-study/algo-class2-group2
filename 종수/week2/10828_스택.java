package 종수.week2;

import java.util.Scanner;

class Main {
    static int MaxStackSize = 10000;
    static int[] result = new int[MaxStackSize];// 실제 스택 배열
    static int size = 0;
    
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
            
            if (stack.contains("push")) {
                // System.out.print("push 실행 : ");
                String[] cmd = stack.split(" ");
                push(Integer.parseInt(cmd[1]));
            } else if (stack.contains("pop")) {
                // System.out.print("pop 실행 : ");
                System.out.println(pop());
            } else if (stack.contains("size")) {
                // System.out.print("size 실행 : ");
                System.out.println(size());
            } else if (stack.contains("empty")) {
                // System.out.print("empty 실행 : ");
                System.out.println(empty());
            } else if (stack.contains("top")) {
                // System.out.print("top 실행 : ");
                System.out.println(top());
            }

        } // for
        sc.close();

    }
}
