package week2;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackCompareDeque {

    // Stack과 ArrayDeque 간단 성능 비교
    // 대략 2- 3배 정도 차이

    static final  int DEFAULT = 10_000_000;

    static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        //==================================================

        long start = System.currentTimeMillis();
        for(int i = 0; i < DEFAULT; i++) {
            arrayDeque.push(i);
            arrayDeque.push(i);
            arrayDeque.peek();
            arrayDeque.pop();
            arrayDeque.pop();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

        //==================================================


        start = System.currentTimeMillis();
        for(int i = 0; i < DEFAULT; i++) {
            stack.push(i);
            stack.push(i);
            stack.peek();
            stack.pop();
            stack.pop();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

    }


}
