package swea.D3.상호의배틀필드;

import java.util.*;
import java.io.*;


public class Solution {

  static BufferedReader br;
  static StringTokenizer st;
  static char[][] board;

  static int H;
  static int W;
  static int dir; // 방향
  static int y;   // 현재 y좌표
  static int x;   // 현재 x좌표

  static int [] dy = {-1,0,1,0};
  static int [] dx = {0,1,0,-1};

  static StringBuilder sb; 

  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int tc=1; tc<=T; tc++){
      st = new StringTokenizer(br.readLine());

      H = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());

      board = new char [H][W];

      int sY=0, sX=0;

      // board 초기화
      for (int i=0; i<H; i++){
        char[] tmp = br.readLine().toCharArray();

        for (int j=0; j<W; j++){
          board[i][j]=tmp[j];
          if (board[i][j]=='<' || board[i][j]=='>' || board[i][j]=='^' || board[i][j]=='v'){
            sY=i;
            sX=j;

            // 첫 방향 저장
            if (board[i][j]=='^'){
              dir=0;
            } else if (board[i][j]=='>'){
              dir=1;
            } else if (board[i][j]=='v'){
              dir=2;
            } else if (board[i][j]=='<'){
              dir=3;
            }
          }
        }
      }

      // 명령 처리
      y=sY;
      x=sX;

      int N = Integer.parseInt(br.readLine());
      char[] order = br.readLine().toCharArray();
      for (int i=0; i<N; i++){
        if (order[i]=='S'){
          shoot (y, x, dir);
        } else {
          changeDir(order[i]);
          move ();
        }
      }

      sb = new StringBuilder();
      sb.append("#" + tc + " ");
      for (int i=0; i<H; i++){
        for (int j=0; j<W; j++){
          sb.append(board[i][j]);
        }
        sb.append("\n");
      }

      System.out.println(sb);
    }
  }

    static boolean checkArr(int y, int x){
    if (y<0 || y>=H || x<0 || x>=W){
      return false;
    }
    return true;
  }

  static int changeDir(char ch){
    if (ch=='U'){
      return dir=0;
    } else if (ch=='R'){
      return dir=1;
    } else if (ch=='D'){
      return dir=2;
    }
    return dir=3;
  }

  static void move (){
    int ny = y+dy[dir];
    int nx = x+dx[dir];

    if (checkArr(ny,nx) && board[ny][nx]=='.'){
      board[y][x]='.';
      y=ny;
      x=nx;
      board[ny][nx]=
    }
  }

  static void shoot(int y, int x, int dir){
    while (true){
      int ny = y+dy[dir];
      int nx = x+dx[dir];
      if (checkArr(ny,nx)){
        if (board[ny][nx]=='*'){
          board[ny][nx]='.';
          break;
        }
      }
    }
  }
}
