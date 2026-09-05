package 프로그래머스.Lv2.가장큰수;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String[] nums = new String[numbers.length];

        for (int i=0; i<numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (a,b)-> (b+b+b+b).compareTo(a+a+a+a));

        String answer = String.join("",nums);

        if (answer.charAt(0) == '0'){
            return "0";
        }
        
        return answer;
    }
}
