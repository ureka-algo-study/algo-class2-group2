import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] files) {
        class File {
            String full;
            String head;
            String number;
            
            public File(String full, String head, String number) {
                this.full = full;
                this.head = head;
                this.number = number;
            } //constructor
        } //static
        
        ArrayList<File> list = new ArrayList<>();
        
        for(String f : files) {
            int numberStart = 0;
            int numberEnd = 0;
            
            for(int i = 0; i < f.length(); i ++) {
                if(f.charAt(i) >= '0' && f.charAt(i) <= '9') {
                    numberStart = i;
                    break;
                }
            } //for
            
            for(int i = numberStart; i < f.length(); i ++) {
                if(f.charAt(i) < '0' || f.charAt(i) > '9') {
                    numberEnd = i;
                    break;
                }
            } // for
            
            File file = new File(f, f.substring(0,numberStart),f.substring(numberStart,numberEnd));
            list.add(file);
            
        } // for each
        
        // 정렬시작
        
        list.sort((f1,f2) -> 
                  {
                      if(f1.head.toLowerCase().equals(f2.head.toLowerCase())) {
                          return Integer.valueOf(f1.number) - Integer.valueOf(f2.number);
                      } else {
                          return f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
                      }
                  });
        
        return list.stream().map(i -> i.full).toArray(String[]::new);
        
    } //solution
}
