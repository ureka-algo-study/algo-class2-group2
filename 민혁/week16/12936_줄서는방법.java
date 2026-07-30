import java.util.*;
import java.util.stream.*;
    
class Solution {
    public int[] solution(int n, long k) {
        /*
        k를 잘 분해해서 숫자가 뭐가 나올지 예측이 가능할것같음
        n = 4 일 때 1~ 1~ 1~ 1~ 1~ 1~ 2~ 2~ 2~ 2~ 2~ 2~ 3~ 3~ 3~ 3~ 3~ 3~ 4~ 4~ 4~ 4~ 4~ 4~
        k = 7 이라해보고
        가장 앞자리 반복은 (n-1)!
        7 / (n-1)! = 7 / (4-1)! = 1...1
        두번째앞자리에서 첫번째가 k의 자리 (2~)
        (2~ 2~ 2~ 2~ 2~ 2~) 에서의 패턴도 찾아야함
        2 1 3 4 
        2 1 4 3 
        2 3 1 4
        2 3 4 1
        2 4 1 3
        2 4 3 1
        다시 남은 숫자들이 반복 1~ 1~ 3~ 3~ 4~ 4~
        k = 1
        1 / (n-2)! = 1 / 2! = 1 / 2 = 0...1 0번째 반복에서 1번째가 k의 자리
        */
        
        
        int[] result = new int[n];
        List<Integer> nums = new ArrayList<>();
        List<Integer> whereK = new ArrayList<>();
        k--;
        while(n > 0) {
            long factorial = factorial(n-1);
            int repeat = (int) (k / factorial);
            long remain =  (k % factorial);
            whereK.add(repeat);
            // repeat 번째 반복에서 remain 자리
            k = remain;
            n--;
        }
         // System.out.println(whereK);
        // n = 3 k = 5    2 0 0 -> 두번째, 영번째반복, 영번째반복
        
        for(int i = 1; i <= result.length; i ++) {
            nums.add(i);
        }
            
        // return whereK.stream().mapToInt(i -> i).toArray();
        
        for (int i = 0; i < result.length; i++) {
            int index = whereK.get(i);

            result[i] = nums.remove(index);
        }

        return result;
        
    }
    
    private long factorial(int n) {
            if(n == 0) {
                return 1;
            }
                
            return n * factorial(n-1);
        }
}
