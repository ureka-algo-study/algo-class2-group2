package study.week16;

import java.util.ArrayList;
import java.util.List;

public class Solution_12936_줄서는방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        k--;

        List<Integer> list = new ArrayList<>();
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            fact *= i;
        }

        for (int i = 0; i < answer.length; i++) {
            fact = fact / n;
            int idx = (int)(k / fact);
            answer[i] = list.get(idx);
            list.remove(idx);

            k = k % fact;
            n--;
        }

        return answer;
    }
}
