package 프로그래머스.Lv1.크레인인형뽑기게임;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int len = board.length; //길이
        int[][] tmp = new int[len][len]; //데이터 다루기 쉽게 돌릴 배열
        int ans =0;
        Deque <Integer> res = new ArrayDeque<>();

        //세로로 되어 있는 00043을 가로로 00043으로 바꾸기
        for (int y=0; y<len; y++){
            for (int x=0; x<len; x++){
                tmp[y][x]=board[x][y];
            }
        }

        //인형뽑기
        for (int num : moves){
            for (int i=0; i<len; i++){
                int cur = tmp[num-1][i];
                if (cur!=0){
                    if (!res.isEmpty()){
                        if (res.peekLast()==cur){
                            res.pollLast();
                            ans+=2;
                        } else{
                            res.offerLast(cur);
                        }
                    } else {
                        res.offerLast(cur);
                    }
                    tmp[num-1][i]=0;
                    break;
                }
            }
        }
        return ans;
    }
}
