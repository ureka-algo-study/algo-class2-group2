package 종수.week1;

class Main {
    public int Solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        //출근 시간은 7시부터 11시 사이에 무조건 해야함.
        //timelog[요일][출근한시간] -> 이때 출근한 시간은 6시부터 23시59분사이
        
        // 원하는 출근 시간 + 10 한게 timelog에 저장된 값보다 커야하는거니까.
        // 시작 요일 계산해서 배열 적용해야함.
        
//        int day = startday;
        int sat = 6 - startday;// 토요일 
        if (sat < 0) sat = 6;
        int sun = 7 - startday;// 일요일
        for (int i = 0; i < schedules.length; i++) {
        	        	
        	int count = 0;
        	for(int j = 0; j < timelogs[i].length; j++){
            	if(j == sat || j == sun) continue;
            	
            	int h = schedules[i] / 100;
            	int m = schedules[i] % 100 + 10;
            	
            	if(m >= 60) {
            		h += 1;
            		m -= 60;
            	}
            	
            	int limit = h * 100 + m;
            	
        		if(limit >= timelogs[i][j]) {
        			count++;
        		}//if
        	}//for
        	if(count == 5) answer++;
        }// for
        return answer;
    }//psvm
    
    public static void main(String[] args) {


        Main obj = new Main();

        int[] schedules = {730, 855, 700, 720};
        
        int[][] timelogs = {
            {710, 700, 650, 735, 700, 931, 912},
            {908, 901, 805, 815, 800, 831, 835},
            {705, 701, 702, 705, 710, 710, 711},
            {707, 731, 859, 913, 934, 931, 905}
        };

        int startday = 1;

        int result = obj.Solution(schedules, timelogs, startday);

        System.out.println(result);
    }
    
    
}
