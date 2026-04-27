package 종수.week2;


// 각 인덱스별로 인덱스 값보다 작아질때 까지 카운트 ++;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[j] < prices[i])
                    break;

            } // for

            answer[i] = count;

        } // for

        return answer;
    }// solution


}// class