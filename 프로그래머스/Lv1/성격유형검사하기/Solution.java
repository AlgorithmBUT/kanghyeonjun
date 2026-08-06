package 프로그래머스.Lv1.성격유형검사하기;

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //R T C F J M A N 각각 점수 0인 map 만들기
        Map <Character, Integer> score = new HashMap<>();
        String tmp = "RTCFJMAN";
        for (char ch : tmp.toCharArray()){
            score.put(ch,0);
        }
        //survey대로 점수 넣기
        for(int i=0; i<survey.length; i++){
            char cc = survey[i].charAt(1);
            score.put(cc, score.get(cc)+(choices[i]-4));
        }

        //성격 찾기
        StringBuilder sb = new StringBuilder();
        if (score.get('R')>=score.get('T')){
            sb.append('R');
        } else {
            sb.append('T');
        }
        if (score.get('C')>=score.get('F')){
            sb.append('C');
        } else {
            sb.append('F');
        }
        if (score.get('J')>=score.get('M')){
            sb.append('J');
        } else {
            sb.append('M');
        }
        if (score.get('A')>=score.get('N')){
            sb.append('A');
        } else {
            sb.append('N');
        }

        for(char ch : tmp.toCharArray()){
            System.out.println(score.get(ch));
        }

        return sb.toString();
    }
}