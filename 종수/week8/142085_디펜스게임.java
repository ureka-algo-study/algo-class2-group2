package 종수.week8;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> round = new PriorityQueue<>(Collections.reverseOrder()); // 라운드 적? // 큰 수부터
        PriorityQueue<Integer> unkillabledemonking = new PriorityQueue<>(); // 무적권 // 작은 수 부터

        //
        int idx = k; // 현재 진행하는 라운드

        if (k >= enemy.length) {
            return enemy.length;
        }

        for (int i = 0; i < k; i++) {
            unkillabledemonking.add(enemy[i]);
        }

        while (idx < enemy.length) {

            round.add(enemy[idx]);
            n -= enemy[idx];

            if (round.peek() > unkillabledemonking.peek()) {
                int temp = round.poll();
                n += temp;
                n -= unkillabledemonking.peek();
                round.add(unkillabledemonking.poll());
                unkillabledemonking.add(temp);
            }

            if (n < 0)
                break;

            idx++;

        }

        answer = idx;

        return answer;
    }
}

// n명의 병사를 가지고 시작
// enemy.length 는 진행할 라운드
// enemy.[i]는 라운드별 등장하는 적
// 한라운드를 적의 숫자와 관계없이 넘길 수 있는 무적권이 k개