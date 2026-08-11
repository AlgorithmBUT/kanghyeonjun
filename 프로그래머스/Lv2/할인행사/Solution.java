package 프로그래머스.Lv2.할인행사;

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wn = new HashMap<>();
        int num = 0;
        for (int i=0; i<want.length; i++){
            wn.put(want[i], number[i]);
            num+=number[i];
        }

        for (int i=0; i<=discount.length-num; i++){
            Map<String, Integer> tmp = new HashMap<>();
            boolean same = true;
            for (int j=i; j<num+i; j++){
                tmp.put(discount[j], tmp.getOrDefault(discount[j], 0)+1);
            }
            
            for (String s : want){
                if(!wn.get(s).equals(tmp.get(s))){
                    same=false;
                    break;
                }
            }
            if (same) answer++;
        }
        return answer;
    }
}
