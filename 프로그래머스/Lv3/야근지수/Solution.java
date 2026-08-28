package 프로그래머스.Lv3.야근지수;

import java.util.*;

class Solution {

    static Queue<Integer> work = new PriorityQueue<>(Comparator.reverseOrder());
    
    public long solution(int n, int[] works) {
        long answer = 0;

        for (int w : works){
            work.offer(w);
        }

        for (int i=0; i<n; i++){
            int cur = work.poll();

            if (cur==0){
                break;
            }

            work.offer(cur-1);
        }

        while (work.size()!=0){
            int cur = work.poll();
            answer += cur*cur;
        }
        
        return answer;
    }
}