class Solution {
    public int solution(int n, int[] tops) {

        int w = tops[0] == 0 ? 2 : 3;
        int b = 1;

        for(int i = 1; i < tops.length; i ++) {
            int nextW;
            int nextB;

            if(tops[i] == 0) {
                nextW = 2 * w + b;
                nextB = w + b;
            } else {
                nextW = 3 * w + 2 * b;
                nextB = w + b;
            }

            w = nextW % 10007;
            b = nextB % 10007;
        }

        return (w + b) % 10007;

    }
}