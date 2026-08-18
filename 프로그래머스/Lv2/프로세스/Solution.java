package 프로그래머스.Lv2.프로세스;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static Deque<V> dq = new ArrayDeque<>();
    static Deque<Integer> order;
    static int cnt;

    public int solution(int[] priorities, int location) {
        int answer = 0;

        order = new ArrayDeque<>(Arrays.stream(priorities).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        for (int i=0; i<priorities.length; i++){
          dq.offer(new V(i,priorities[i]));
        }

        while (dq.size()!=0){
          V cur = dq.pollFirst();
          if (cur.value==order.peekFirst()){
            cnt++;
            if (cur.idx==location){
              answer=cnt;
            }
            order.pollFirst();
          } else {
            dq.offerLast(cur);
          }
        }
        return answer;
    }
}

class V{
  int idx;
  int value;

  public V(int idx, int value){
    this.idx=idx;
    this.value=value;
  }
}