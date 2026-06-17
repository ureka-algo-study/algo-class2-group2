package 종수.week9;

import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        int n = order.length;

        Stack<Integer> mainconbelt = new Stack<>();
        Stack<Integer> serveconbelt = new Stack<>();

        for (int i = n; i >= 1; i--) {
            mainconbelt.push(i);
        }

        int idx = 0;

        while (idx < n) {

            // 메인 벨트에서 바로 꺼낼 수 있는 경우
            if (!mainconbelt.isEmpty()
                    && order[idx] == mainconbelt.peek()) {

                mainconbelt.pop();
                answer++;
                idx++;
            }

            // 보조 벨트에서 꺼낼 수 있는 경우
            else if (!serveconbelt.isEmpty()
                    && order[idx] == serveconbelt.peek()) {

                serveconbelt.pop();
                answer++;
                idx++;
            }

            // 메인 벨트에서 보조 벨트로 이동
            else if (!mainconbelt.isEmpty()) {

                serveconbelt.push(mainconbelt.pop());
            }

            // 더 이상 진행 불가능
            else {
                break;
            }
        }

        return answer;
    }
}