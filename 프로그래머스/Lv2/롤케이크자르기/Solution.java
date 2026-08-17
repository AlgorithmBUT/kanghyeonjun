package 프로그래머스.Lv2.롤케이크자르기;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();

        for (int i : topping){
            right.put(i, right.getOrDefault(i, 0)+1);
        }

        for (int i : topping){
            left.add(i);

            int cnt = right.get(i)-1;

            if (cnt==0){
                right.remove(i);
            } else{
                right.put(i, cnt);
            }

            if (left.size()==right.size()){
                answer++;
            }
        }

        return answer;
    }
}
