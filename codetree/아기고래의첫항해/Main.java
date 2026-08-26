package codetree.아기고래의첫항해;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 위를 기준으로 시계 방향
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int NN;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine().toString());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int d = Integer.parseInt(st.nextToken());

        NN=N;

        int[][] board = new int[N][N];

        int sea = 0;

        for (int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine().toString());

            for (int j=0; j<N; j++){
                board[i][j]=Integer.parseInt(st2.nextToken());

                if (board[i][j]==0){
                    sea++;
                }
            }
        }

        // 문제에서는 1.상 2.하 3.좌 4.우
        // 하지만 dy, dx의 index 기준으로 바꿔줘야 함 (1=상 2=우 3=하 4=좌)
        int [] convert = {0, 2, 3, 1};
        d = convert[d-1];

        board[r][c]=-1;
        sea--;

        sb.append(r+1).append(" ").append(c+1).append("\n");

        while (sea>0){

            // 1. 인접 탐험
            int [] order = {d, (d+3)%4, (d+1)%4, (d+2)%4};
            boolean move = false;

            for (int dd=0; dd<4; dd++){
                int ny = r + dy[order[dd]];
                int nx = c + dx[order[dd]];

                if (check(ny,nx) && board[ny][nx]==0){
                    board[ny][nx]=-1;

                    r=ny;
                    c=nx;
                    d=order[dd];

                    move=true;
                    sea--;

                    sb.append(r+1).append(" ").append(c+1).append("\n");

                    break;
                }
            }

            // 2. 바다 이동
            if (!move){

                // 가장 가까운 미탐험 바다 찾기
                Deque<Point> dq = new ArrayDeque<>();
                int [][] visited = new int[N][N];

                for (int i=0; i<N; i++){
                    Arrays.fill(visited[i], -1);
                }

                dq.offer(new Point(r,c));
                visited[r][c]=0;

                List<Point> moveSea = new ArrayList<>();

                int minDist = Integer.MAX_VALUE;

                while (dq.size()!=0){
                    Point cur = dq.pollFirst();

                    int curDist = visited[cur.y][cur.x];

                    // 이미 최소거리보다 멀면 더 볼 필요 없음
                    if (curDist>minDist){
                        break;
                    }

                    // 아직 탐험하지 않은 바다
                    if (board[cur.y][cur.x]==0){

                        if (minDist==Integer.MAX_VALUE){
                            minDist=curDist;
                        }

                        if (curDist==minDist){
                            moveSea.add(cur);
                        }

                        continue;
                    }

                    for (int dir=0; dir<4; dir++){
                        int ny = cur.y+dy[dir];
                        int nx = cur.x+dx[dir];

                        if (!check(ny,nx)){
                            continue;
                        }

                        if (board[ny][nx]==1){
                            continue;
                        }

                        if (visited[ny][nx]!=-1){
                            continue;
                        }

                        visited[ny][nx]=curDist+1;
                        dq.offerLast(new Point(ny,nx));
                    }
                }

                // 같은 최소거리라면 행이 작은 곳
                // 행도 같다면 열이 작은 곳
                Point nextSea = moveSea.get(0);

                for (Point nextP : moveSea){

                    if (nextP.y<nextSea.y){
                        nextSea=nextP;
                    }

                    else if (nextP.y==nextSea.y &&
                            nextP.x<nextSea.x){

                        nextSea=nextP;
                    }
                }

                // 선택한 바다 기준으로 거리 계산
                Deque<Point> moveDq = new ArrayDeque<>();
                int [][] moveDist = new int[N][N];

                for (int i=0; i<N; i++){
                    Arrays.fill(moveDist[i], -1);
                }

                moveDq.offer(new Point(nextSea.y,nextSea.x));
                moveDist[nextSea.y][nextSea.x]=0;

                while (moveDq.size()!=0){
                    Point cur = moveDq.pollFirst();

                    for (int dir=0; dir<4; dir++){
                        int ny = cur.y+dy[dir];
                        int nx = cur.x+dx[dir];

                        if (!check(ny,nx)){
                            continue;
                        }

                        if (board[ny][nx]==1){
                            continue;
                        }

                        if (moveDist[ny][nx]!=-1){
                            continue;
                        }

                        moveDist[ny][nx]
                                =moveDist[cur.y][cur.x]+1;

                        moveDq.offerLast(new Point(ny,nx));
                    }
                }

                // 좌 -> 하 -> 우 -> 상
                int [] moveOrder = {3, 2, 1, 0};

                while (r!=nextSea.y || c!=nextSea.x){

                    for (int dir : moveOrder){
                        int ny = r+dy[dir];
                        int nx = c+dx[dir];

                        if (!check(ny,nx)){
                            continue;
                        }

                        // 목표까지 거리가 1 감소하는 방향
                        if (moveDist[ny][nx]
                                ==moveDist[r][c]-1){

                            r=ny;
                            c=nx;
                            d=dir;

                            // 실제 이동 중 아직 탐험하지 않은 바다라면
                            if (board[r][c]==0){
                                board[r][c]=-1;
                                sea--;

                                sb.append(r+1).append(" ").append(c+1).append("\n");
                            }

                            break;
                        }
                    }
                }
            }
        }

        System.out.print(sb);
    }

    static boolean check (int y, int x){
        if (y<0 || y>=NN || x<0 || x>=NN){
            return false;
        }
        return true;
    }
}

class Point {
    int y;
    int x;
    public Point(int y, int x){
        this.y=y;
        this.x=x;
    }
}