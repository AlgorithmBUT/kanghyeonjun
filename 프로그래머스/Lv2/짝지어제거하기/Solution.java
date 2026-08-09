package 프로그래머스.Lv2.짝지어제거하기;

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()){
            if (stack.size()==0){
                stack.offerLast(c);
            } else {
                if (stack.peekLast()==c){
                    stack.pollLast();
                } else{
                    stack.offerLast(c);
                }
            }
        }

        return stack.size()==0? 1:0;
    }
}