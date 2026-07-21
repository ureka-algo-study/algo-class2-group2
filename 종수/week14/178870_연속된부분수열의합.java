package 종수.week14;
class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int left = 0;
        int sum = 0;

        int aleft = 0;
        int aright = sequence.length - 1;
        int minLength = sequence.length;
        
        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];

            while(sum > k && left <= right){
                sum -= sequence[left];
                left++;

            }

            if(sum == k){
                int length = right - left + 1;

                if(length < minLength){
                    minLength = length;
                    aleft = left;
                    aright = right;
                }
            }

        }
        return new int[]{aleft, aright};
    }
}