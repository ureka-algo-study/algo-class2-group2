class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i=n; i>=1; i=(i-1)/3){
            if((i-1)%3 == 0){
                answer = "1" + answer;
            }
            else if((i-1)%3 == 1){
                answer = "2" + answer;
            }
            else if((i-1)%3 == 2){
                answer = "4" + answer;
            }
        }
        return answer;
    }
}