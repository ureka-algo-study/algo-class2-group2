package 종수.week6;

class Solution {

    public int[] solution(long begin, long end) {

        int size = (int) (end - begin + 1);
        int[] answer = new int[size];

        int idx = 0;

        for (long n = begin; n <= end; n++) {

            // 1은 약수가 없으므로 0
            if (n == 1) {
                answer[idx++] = 0;
                continue;
            }

            // 기본값은 1
            int block = 1;

            // sqrt(n) 까지만 탐색
            for (long i = 2; i * i <= n; i++) {

                // 약수 발견
                if (n % i == 0) {

                    long pair = n / i;

                    // 가장 큰 약수가 10,000,000 이하인지 확인
                    if (pair <= 10000000) {
                        block = (int) pair;
                        break;
                    }

                    // pair가 조건을 만족하지 않으면
                    // 작은 약수라도 저장
                    if (i <= 10000000) {
                        block = (int) i;
                    }
                }
            }

            answer[idx++] = block;
        }

        return answer;
    }
}