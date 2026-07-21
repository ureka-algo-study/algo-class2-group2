class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        answer[0] = sequence.length;
        int sum = 0;
        int l = 0;
        int r = 0;
        
        // for(int i=0; i<sequence.length; i++){
        //     if(sequence[i] == k)
        //         return new int[] {i,i};
        // }
        while(r < sequence.length ) {
            sum += sequence[r++];
            
            while(sum > k){
                sum -= sequence[l++];
            }
            
            if(sum == k){
                if(Math.abs(answer[1] - answer[0]) > r-1 - l){
                    answer[0] = l;
                    answer[1] = r-1;
                }
            }
        }

        
        return answer;
    }
}