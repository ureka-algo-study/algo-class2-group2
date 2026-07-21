class Solution {
    public int[] solution(int[] sequence, int k) {
        /*
        배열의 길이가 100만 특정 합을 구함
        배열이 정렬되어 있음
        부분수열을 무조건 만들수있음(답이 있음)
        1 순위 - 길이가 짧은 부분수열 / 2순위 - 인덱스가 앞인 부분수열
        
        ㅇ떠가지 어떡하지
        
        앞에서부터 탐색 -> 길이가 짧은것부터 탐색
        투포인터를 이용하면 각각 최대 100만번만 이동
        */
        
        
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        // 완전탐색
        for(int right = 0; right < sequence.length; right++ ) {
            sum += sequence[right];
            
           while(sum > k) {
               
               sum -= sequence[left];
               left++;
               
           }
            
            if(sum == k) {
                int length = right - left + 1;
                if(length < minLength) {
                    minLength = length;
                    result[0] = left;
                    result[1] = right;
                }
            }
        }
        
        return result;
        
        
    }
}
