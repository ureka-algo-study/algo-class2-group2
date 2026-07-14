package 종수.week13;

import java.util.ArrayDeque;
import java.util.Queue;

// 큐가 아니라 투포인터 문제.
// 문제에서 주어진 두 개의 배열을 하나의 배열로 합쳐서
// 두 구간의 합으로 생각하여 문제를 풀어야 했음.


class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();

        long avg = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add((long)queue1[i]);
            q1Sum += queue1[i];
            q2.add((long)queue2[i]);
            q2Sum += queue2[i];
            avg += (queue1[i] + queue2[i]);
        }

        if (avg % 2 != 0)
            return -1;

        avg /= 2;
        long temp;

        long limit = queue1.length * 3;
        while (q1Sum != q2Sum) {
            if (avg < q1Sum) {
                temp = q1.poll();
                q1Sum -= temp;
                q2Sum += temp;
                q2.add(temp);

            }else{
                temp = q2.poll();
                q2Sum -= temp;
                q1Sum += temp;
                q1.add(temp);

            }
            answer++;
            if(answer == limit)
                return -1;
        }
        if (q1Sum == avg) {
            return answer;
        }

        return -1;
    }
}