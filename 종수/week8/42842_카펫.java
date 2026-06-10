package 종수.week8;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i * i <= yellow; i++) {

            if (yellow % i == 0) {
                int n = yellow / i;

                int round;
                if (i == 1) {
                    round = ((n + 2) * 2) + 2;
                } else {
                    round = ((n + 2) * 2) + (i * 2);
                }
                if (round == brown)

                    return answer = new int[] { n + 2, i + 2 };
            }
        }

        return answer;
    }
}
// yellow의 약수가 n x m 의(m<=n) 형태로 yellow가 만들어질때
// ((m+2)*2) + (n*2) = brown 을 찾는 문제