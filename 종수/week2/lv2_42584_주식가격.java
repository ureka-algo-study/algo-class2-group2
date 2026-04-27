package 종수.week2;

import java.util.Stack;

class Solution {

    public int[] solution(int[] prices) {// 이해가 안된다...
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }

            stack.push(i);
        }

        // 남은 애들 처리
        while (!stack.isEmpty()) {
            int prev = stack.pop();
            answer[prev] = (n - 1) - prev;
        }

        return answer;
    }// solution

    // 각 인덱스별로 인덱스 값보다 작아질때 까지 카운트 ++;
    // public int[] solution(int[] prices) {// 이거는 시간복잡도가 O(N^2)
    // int[] answer = new int[prices.length];

    // for (int i = 0; i < prices.length; i++) {
    // int count = 0;
    // for (int j = i + 1; j < prices.length; j++) {
    // count++;
    // if (prices[j] < prices[i])
    // break;

    // } // for

    // answer[i] = count;

    // } // for

    // return answer;
    // }// solution

}// class