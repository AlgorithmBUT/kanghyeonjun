package 프로그래머스.Lv2.행렬테두리회전하기;

class Solution {

    static final int[] dy = {0,1,0,-1};
    static final int[] dx = {1,0,-1,0};

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        //행렬 초기화
        int[][] board = new int[rows][columns];
        int num=1;
        for (int y=0; y<rows; y++){
            for (int x=0; x<columns; x++){
                board[y][x] = num++;
            }
        }
        //테두리 회전하기
        for (int i=0; i<queries.length; i++){
            int y1=queries[i][0]-1;
            int x1=queries[i][1]-1;
            int y2=queries[i][2]-1;
            int x2=queries[i][3]-1;
            // 현재 위치(curx, cury), tmp는 현재 위치의 값, d는 방향, min은 최솟값 갱신
            int curx=x1, cury=y1, tmp=board[cury][curx], d=0, min=tmp;
            // 바뀔 위치에 있는 숫자는 temp에 넣고, 다음 위치에는 tmp를 넣고 tmp는 다시 temp로 초기화
            for (int j=0; j<((y2-y1)+(x2-x1))*2; j++){
                int ny=cury+dy[d];
                int nx=curx+dx[d];
                //방향 전환
                if (ny>y2 || ny<y1 || nx>x2 || nx<x1){
                    d=(d+1)%4;
                    ny=cury+dy[d];
                    nx=curx+dx[d];
                }
                int temp=board[ny][nx];
                board[ny][nx]=tmp;
                tmp=temp;
                cury=ny;
                curx=nx;
                min=Math.min(min,temp);
            }
            answer[i]=min;
        }
        return answer;
    }
}
