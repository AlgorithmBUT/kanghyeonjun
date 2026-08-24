package 프로그래머스.Lv2.주식가격;

import java.util.*;

class Solution {

    static Deque<Time> stack= new ArrayDeque<>();
    static int time;

    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        for (int i=0; i<prices.length; i++){
            time++;
            if (stack.size()==0){
                stack.offer(new Time(prices[i],i));
            } else {
                while (stack.size()>0 && stack.peekLast().price>prices[i]){
                    Time t = stack.pollLast();
                    answer[t.idx]=time-t.idx-1;
                }
                stack.offerLast(new Time(prices[i],i));
            }
        }

        if (stack.size()!=0){
            while (stack.size()>0){
                Time t = stack.pollLast();
                    answer[t.idx]=time-t.idx-1;
            }
        }
        return answer;
    }
}

class Time {
    int price;
    int idx;
    public Time(int price,  int idx){
        this.price=price;
        this.idx=idx;
    }
}
