package 종수.week14;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        // 14 16
        int use_stone = 0;
        int next;
        while (storey > 0) {
            use_stone = storey % 10;
            next = (storey / 10) % 10;

            if (use_stone < 5) {
                answer += use_stone;
            } else if (use_stone > 5) {
                answer += 10 - use_stone;
                storey += 10;

            } else {
                answer += 5;

                if (next >= 5) {
                    storey += 10;
                }
            }
            System.out.println(use_stone + " " + storey);
            storey /= 10;
        }
        // answer += storey;
        return answer;
    }
}