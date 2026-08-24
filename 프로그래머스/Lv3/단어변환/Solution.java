package 프로그래머스.Lv3.단어변환;

import java.util.*;

class Solution {

    static Deque<State> dq = new ArrayDeque<>();
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        addd(words, begin, 1);

        while (true){
            if (dq.size()==0){
                return 0;
            }
            State t = dq.pollFirst();
            if (t.word.equals(target)){
                answer=t.cnt;
                break;
            } else {
                addd( words, t.word, t.cnt + 1);
            }
        }
        return answer;
    }

    // 단어 1개 다른 거 queue에 넣기
    static void addd(String[] words, String begin, int cnt){
        for (int i=0; i<words.length; i++){
            int tmp=0;
            for(int j=0; j<begin.length(); j++){
                if (begin.charAt(j)==words[i].charAt(j)){
                    tmp++;
                }
            }
            if (!visited[i] && tmp==begin.length()-1){
                dq.offerLast(new State(words[i],cnt));
                visited[i]=true;
            }
        }
    }
}

class State{
    String word;
    int cnt;

    public State(String word, int cnt){
        this.word=word;
        this.cnt=cnt;
    }
}
