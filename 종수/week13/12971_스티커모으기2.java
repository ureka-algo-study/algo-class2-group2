package 종수.week13;

class Solution {
    public int solution(int sticker[]) {

        int n = sticker.length;

        if(n == 1) {
            return sticker[0];
        }

        int a = dp(sticker, 0, n - 2);

        int b = dp(sticker, 1, n - 1);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return Math.max(a, b);
    }

    public int dp(int[] arr, int start, int end) {

        int after = 0;
        int aafter = 0;

        for (int i = end; i >= start; i--) {
            int now = Math.max(after, arr[i] + aafter);

            aafter = after;
            after = now;
        }
        return after;
    }

}