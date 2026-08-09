package 프로그래머스.Lv2.방문길이;

import java.util.*;

class Solution {

    //방향 Map
    static final Map<Character, int[]> dir = new HashMap<>();
    static {
        dir.put('U', new int[]{0, 1});
        dir.put('D', new int[]{0, -1});
        dir.put('L', new int[]{-1, 0});
        dir.put('R', new int[]{1, 0});
    }

    public int solution(String dirs) {

        //전체를 set으로 중복 처리
        Set<Set<List<Integer>>> ans = new HashSet<>();
        
        int curx=0, cury=0;

        for (char c : dirs.toCharArray()){
            int nx = curx + dir.get(c)[0];
            int ny = cury + dir.get(c)[1];

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            //시작점과 도착점을 list로 만들고, 그걸 set으로 만들면 선분
            Set<List<Integer>> line = new HashSet<>();
            line.add(Arrays.asList(curx,cury));
            line.add(Arrays.asList(nx,ny));
            ans.add(line);
            curx=nx;
            cury=ny;
        }
        return ans.size();
    }
}