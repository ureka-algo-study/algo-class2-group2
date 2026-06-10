class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=Math.sqrt(yellow); i++){
            if(yellow % i == 0){
                if((i + 2) * (yellow/i + 2) == brown + yellow){
                    answer[0] = yellow/i + 2;
                    answer[1] = i + 2;
                }
            }
        }
        return answer;
    }
}