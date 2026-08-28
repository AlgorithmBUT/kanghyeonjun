package 프로그래머스.Lv3.이중우선순위큐;

import java.util.*;

class Solution {

    static Queue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
    static Queue<Integer> minPq = new PriorityQueue<>();

    public int[] solution(String[] operations) {

        for (String op : operations){
            String[] tmp = op.split(" ");

            if (tmp[0].equals("I")){
                maxPq.offer(Integer.parseInt(tmp[1]));
                minPq.offer(Integer.parseInt(tmp[1]));
            } else {

                if (minPq.size() == 0){
                    continue;
                }

                if (tmp[1].equals("-1")){
                    int min = minPq.poll();
                    maxPq.remove(min);
                } else if (tmp[1].equals("1")){
                    int max = maxPq.poll();
                    minPq.remove(max);
                }
            }
        }

        if (minPq.size() == 0){
            return new int[]{0, 0};
        }

        return new int[]{maxPq.poll(), minPq.poll()};
    }
}
