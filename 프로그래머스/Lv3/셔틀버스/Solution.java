package 프로그래머스.Lv3.셔틀버스;

import java.util.*;

class Solution {

    static int[] tt;

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        tt = new int[timetable.length];

        for (int i=0; i<timetable.length; i++){
            tt[i] = toMinute(timetable[i]);
        }

        Arrays.sort(tt);

        int cur = 0;

        for (int i=0; i<n; i++){
            int departure = toMinute("09:00") + i*t;

            int cnt = 0;

            while (cur<tt.length && tt[cur]<=departure && cnt<m){
                cur++;
                cnt++;
            }

            if (i==n-1){
                if (cnt!=m){
                    answer = toTime(departure);
                } else {
                    answer = toTime(tt[cur-1]-1);
                }
            }
        }
        return answer;
    }
    

    static int toMinute(String time){
        String[] now = time.split(":");
        int h = Integer.parseInt(now[0]);
        int m = Integer.parseInt(now[1]);
        return h*60 + m;
    }

    static String toTime(int time){
        String h = String.valueOf(time/60);
        String m = String.valueOf(time%60);

        if (h.length()==1){
            h = "0"+h;
        }

        if (m.length()==1){
            m = "0"+m;
        }

        return h+":"+m ;
    }
}