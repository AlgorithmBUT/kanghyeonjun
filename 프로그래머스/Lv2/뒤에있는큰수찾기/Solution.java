package 프로그래머스.Lv2.뒤에있는큰수찾기;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int [numbers.length];

        stack.offerLast(numbers[numbers.length-1]);
        for (int i=numbers.length-2; i>=0; i--){
            while ( stack.size() >0 && stack.peekLast()<=numbers[i]){
                stack.pollLast();
            }

            if(stack.size()==0 || numbers[i]>=stack.peekLast()){
                ans[i]=-1;
            } else {
                ans[i]=stack.peekLast();
            }

            stack.offerLast(numbers[i]);
        }

        ans[numbers.length-1]=-1;
        
        return ans;
    }
}
