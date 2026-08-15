package 재귀;

//10진수를 2진수 문자열로 변환

import java.io.*;

public class practice3 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    System.out.println("0b" + rec(num,new StringBuilder()));
  }

  static String rec (int n, StringBuilder sb){
    //종료조건
    if(n==0){
      if(sb.length()==0){
        return "0";
      }
      return sb.reverse().toString();
    }
    sb.append(n%2);
    return rec(n/2, sb);
  }
}
