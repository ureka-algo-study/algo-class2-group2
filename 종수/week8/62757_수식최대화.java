package 종수.week8;

import java.util.*;

class Solution {

    private long answer = 0;

    public long solution(String expression) {

        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(sb.toString()));
                operators.add(c);
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        numbers.add(Long.parseLong(sb.toString()));

        char[] ops = {'+', '-', '*'};
        boolean[] visited = new boolean[3];

        permutation(0, new char[3], ops, visited, numbers, operators);

        return answer;
    }

    private void permutation(int depth, char[] order, char[] ops,
                             boolean[] visited,
                             List<Long> numbers,
                             List<Character> operators) {

        if (depth == 3) {

            List<Long> nums = new ArrayList<>(numbers);
            List<Character> opers = new ArrayList<>(operators);

            for (char op : order) {

                for (int i = 0; i < opers.size();) {

                    if (opers.get(i) == op) {

                        long a = nums.get(i);
                        long b = nums.get(i + 1);

                        long result = calculate(a, b, op);

                        nums.set(i, result);
                        nums.remove(i + 1);
                        opers.remove(i);

                    } else {
                        i++;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(nums.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = ops[i];

                permutation(depth + 1, order, ops, visited, numbers, operators);

                visited[i] = false;
            }
        }
    }

    private long calculate(long a, long b, char op) {

        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return a * b;
        }
    }
}
// 어차피 이 문제를 풀려면 최악의 경우에는 모든 연산을 다 쓰니까
// 그냥 모든 연산에 대해서 순열을 구하고 그 순서에 맞는 조합을 구하면 되겠네

// 아닌가 조합 구하면서 max를 구해야하나?