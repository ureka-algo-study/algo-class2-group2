class Solution {
    public int solution(int sticker[]) {
        // 1 3 2 5 4
        // 1 3 3 8 8


        // dp[0] = sticker[0];
        // dp[1] = sticker[1] > sticker[0] ? sticker[1] : sticker[0];
        // dp[2] = sticker[0] + sticker[2] > sticker[1] ?

        // dp[i] 는 두가지 경우 현재를 선택안하고 dp[i-1]의 값을 그대로 가져가기 or dp[i-2] + 현재선택
        // dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i])

        // 첫번째를 선택하는 경우 0번 + 2번 ~ n - 2/ 선택안하는 경우 1번 ~ n-1

        if(sticker.length == 1) {
            return sticker[0];
        }

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        // 첫번째를 반드시 선택하는 경우 0번 + 2번 ~ n - 2
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for(int i = 2; i < sticker.length - 1; i ++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i-2] + sticker[i]);
        }

        // 첫번째를 반드시 선택안하는 경우 1번 ~ n-1
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i = 2; i < sticker.length; i ++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i-2] + sticker[i]);
        }

        return Math.max(dp1[sticker.length - 2],dp2[sticker.length - 1]);







    }
}