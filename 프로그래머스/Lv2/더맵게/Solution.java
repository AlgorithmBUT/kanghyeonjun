package 프로그래머스.Lv2.더맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville){
            pq.offer(s);
        }

        while (true){
            int cur = pq.poll();
            if (cur>=K){
                break;
            } else {
                if (pq.size()==0){
                    answer=-1;
                    break;
                } else {
                    pq.offer(cur+(pq.poll()*2));
                    answer++;
                }  
            }
        }
        return answer;
    }
}
