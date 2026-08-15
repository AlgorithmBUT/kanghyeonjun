package 프로그래머스.Lv2.게임맵최단거리;

import java.util.*;

class Solution {

    static int [] dy = {0,1,0,-1};
    static int [] dx = {1,0,-1,0};

    public int solution(int[][] maps) {

        Deque<point> dq = new ArrayDeque<>();
        dq.offerFirst(new point (0,0));

        while(dq.size()!=0){
            point cur = dq.pollFirst();

            for (int d=0; d<4; d++){
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                if (check(ny, nx, maps)){
                    dq.offerLast(new point(ny,nx));
                    maps[ny][nx]=maps[cur.y][cur.x]+1;
                }
            }
        }

        return maps[maps.length-1][maps[0].length-1]!=1? maps[maps.length-1][maps[0].length-1]:-1;
    }

    static boolean check(int y, int x, int[][] arr){
        if (y<0 || y>=arr.length || x<0 || x>=arr[0].length || arr[y][x]!=1){
            return false;
        }
        return true;
    }
}

class point {
    int y;
    int x;
    public point(int y, int x){
        this.y=y;
        this.x=x;
    }
}
