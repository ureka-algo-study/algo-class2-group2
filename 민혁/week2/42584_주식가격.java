package week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    /*
    price의 길이는 최대 100,000이니 O(n^2)로는 문제해결 하기 어려울것이라 생각
    (해보니 통과되긴 함 테스트 케이스가 잘못된거같다고 생각 그리고 스택 풀이 아님)

    과거 가격을 기준으로 미래 찾기 - for loop
    현재 가격 기준으로 과거 추적 - stack

    시간복잡도 O(n)
     */

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length]; // 정답을 넣을 배열
        Deque<Integer> stack = new ArrayDeque<>(); //아직 solution 이 결정되자 않은 idx들

        for(int i = 0; i < prices.length; i ++) { // 시간흐름 0초 -> 1초 2초 ...

            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx; // 현재시간과 과거 시간의 차이만큼 생존
            }

            stack.push(i); //스택이 비었거나 현재 가격이 이전가격보다 높다

        }

        while(!stack.isEmpty()) { // 시간이 마지막까지 다 지났을 때 남은 인덱스들은 끝까지 생존한 idx
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1; // 마지막 시간(prices.lenth - 1) - 기준시간(idx)
        }

        return answer;

    }

}

