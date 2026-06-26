class Solution {
    public int solution(int n) {
        final int module = 1000000007;
        int[] fibo = new int[n + 1];
        fibo[1] = 1;
        fibo[2] = 2;
        for(int i = 1; i < n - 1; i ++) {
            fibo[i + 2] = (fibo[i + 1] + fibo[i] ) % module;
        }
       
        return fibo[n];
    }
}
