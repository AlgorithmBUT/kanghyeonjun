package 프로그래머스.Lv1;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 여벌
        List<Integer> rs = new ArrayList<>();
        for (int num : reserve){
            rs.add(num);
        }
        // 도난
        int [] ls = new int[n];
        for (int num : lost){
            if (rs.contains(num)){
                rs.remove(Integer.valueOf(num));
            } else{
                ls[num-1]=1;
            }
        }
        // 체육복 빌리기
        for (int i=0; i<n; i++){
            if (ls[i]==1){
                //앞 사람한테 빌리기
                if (i-1>=0 && rs.contains(i)){
                    ls[i]=0;
                    rs.remove(Integer.valueOf(i));
                } 
                //뒤 사람한테 빌리기
                else if (i+1<n && rs.contains(i+2)){
                    ls[i]=0;
                    rs.remove(Integer.valueOf(i+2));
                } 
                else continue;
            }
        }

        for (int i=0; i<n; i++){
            if (ls[i]==1) answer++;
        }

        return n-answer;
    }
}
