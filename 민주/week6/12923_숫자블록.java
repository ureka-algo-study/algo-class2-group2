class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end- begin +1)];
        for(long i=begin; i<=end; i++){
            if(i == 1) {
                answer[(int)(i-begin)] = 0;
                continue;
            }
            answer[(int)(i-begin)] = 1;
            for(long j=2; j*j<=i; j++){
                if(i % j == 0){
                    if((int) i/j <= 10000000){
                        answer[(int)(i-begin)] = (int) (i / j);
                    break;
                    }
                    answer[(int)(i-begin)] = (int)j;
                    
                }
            }
        }
        return answer;
    }
}