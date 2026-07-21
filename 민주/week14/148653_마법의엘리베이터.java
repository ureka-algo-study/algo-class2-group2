class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        for(int i=storey; i > 0; i=i/10){
            if(i % 10 <= 4){
                answer += i % 10;
            }
            else if(i % 20 >= 6){
                answer += 10 - (i) % 10;
                i += 10;
            }
            else{
                answer += 5;
                int next = (i /10) % 10;
                if(next >= 5){
                    i += 10;
                }
            }
        }
        return answer;
    }
}