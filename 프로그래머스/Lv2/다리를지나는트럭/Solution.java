package 프로그래머스.Lv2.다리를지나는트럭;

import java.util.*;

class Solution {
    
    static Deque<Integer> dq;

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        dq = new ArrayDeque<>();
        int idx = 0;
        int sum = 0;

        for (int i=0; i<bridge_length; i++){
            dq.offer(0);
        }

        while (idx < truck_weights.length){
            // 하나 제거
            int arrive=dq.pollFirst();
            if (arrive!=0){
                sum-=arrive;
            }

            // 지금 들어가는 것이 무게를 버틴다면
            if (sum+truck_weights[idx]<=weight){
                dq.offer(truck_weights[idx]);
                sum+=truck_weights[idx];
                idx++;
            } 
            // 못 버틴다면
            else {
                dq.offer(0);
            }

            time++;
        }

        // 마지막 트럭이 지나간 시간
        time += bridge_length;

        return time;
    }
}
