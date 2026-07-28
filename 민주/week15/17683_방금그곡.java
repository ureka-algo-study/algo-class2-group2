import java.util.*;


class Solution {
    class Song{
        int play;
        String name;
        Song(int play, String name){
            this.play = play;
            this.name = name;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        
        
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
        
        ArrayList<Song> list = new ArrayList<>();
        
        for(int i=0; i<musicinfos.length; i++){
            StringTokenizer token = new StringTokenizer(musicinfos[i], ",");
            String start = token.nextToken();
            String end = token.nextToken();
            String name = token.nextToken();
            String melody = token.nextToken();
            
            StringTokenizer time = new StringTokenizer(start, ":");
            String hour = time.nextToken();
            String min = time.nextToken();
            int startInt = Integer.parseInt(hour) * 60 + Integer.parseInt(min);
            
            time = new StringTokenizer(end, ":");
            hour = time.nextToken();
            min = time.nextToken();
            int endInt = Integer.parseInt(hour) * 60 + Integer.parseInt(min);
            
            int timeInt = endInt-startInt;
            
            melody = melody.replace("C#", "c");
            melody = melody.replace("D#", "d");
            melody = melody.replace("F#", "f");
            melody = melody.replace("G#", "g");
            melody = melody.replace("A#", "a");
            
            
            StringBuilder sb = new StringBuilder();
            for(int t=startInt; t<=endInt; t++){
                sb.append(melody.charAt((t-startInt) % melody.length()) + "");
            }
            String final_melody = sb.toString();
            
            if(final_melody.contains(m)){
                list.add(new Song(timeInt, name));
                continue;
            }
            
            
        } // for i
        
        if(list.size() == 0){
            return  "(None)";
        }
        else{
            String answer = list.stream().sorted((a,b) -> b.play - a.play).toList().get(0).name;
            return answer;
        }
        // String answer = "";
        // return answer;
    }
}