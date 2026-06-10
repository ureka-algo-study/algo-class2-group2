import java.util.*;

class Solution {
    String[] permu;
    String[] arr;
    boolean[] visited;
    ArrayList<Long> nums;
    ArrayList<String> opers;
    long answer;
    
    void permutation(int idx){
        if(idx >= permu.length){
            calc();
            return;
        }
        for(int i=0; i<permu.length; i++){
            if(visited[i]) continue;
            permu[idx] = arr[i];
            visited[i] = true;
            permutation(idx+1);
            visited[i] = false;
        }
    }
    
    void calc(){
        ArrayList<Long> tmpnums = new ArrayList<>(nums);
        ArrayList<String> tmpopers = new ArrayList<>(opers);
        for(int op=0; op<permu.length; op++){
            for(int i=0; i< tmpopers.size(); ){
                if(tmpopers.get(i).equals(permu[op])){
                    Long a = tmpnums.get(i);
                    Long b = tmpnums.get(i+1);
                    Long res;
                    if(tmpopers.get(i).equals("+")){
                        res = a+b;
                    }
                    else if(tmpopers.get(i).equals("-")){
                        res = a-b;
                    }
                    else{
                        res = a*b;
                    }
                    
                    tmpnums.set(i, res);
                    tmpnums.remove(i+1);
                    tmpopers.remove(i);
                }
                else{
                    i++;
                }
            }
        }
        
        answer = Math.max(answer, Math.abs(tmpnums.get(0)));
        
    }
    public long solution(String expression) {
        answer = 0;
        
        String num = "";
        nums = new ArrayList<>();
        opers = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<expression.length();i++){
            if(expression.charAt(i) == '-' 
               || expression.charAt(i) == '*' 
               || expression.charAt(i) == '+'){
                nums.add(Long.parseLong(num) );
                num = "";
                opers.add(expression.charAt(i) + "");
                set.add(expression.charAt(i) + "");
            }
            else{
                num+= expression.charAt(i) + "";
            }
        } // for
        nums.add(Long.parseLong(num) );
        
        permu = new String[set.size()];
        visited = new boolean[set.size()];
        arr = set.toArray(new String[0]);
        permutation(0);
        
        
        return answer;
    }
}