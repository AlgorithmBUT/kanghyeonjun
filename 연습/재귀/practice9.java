package 재귀;

// 문자열 뒤집기

import java.io.*;

public class practice9 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    System.out.println(rec(str.length()-1, new StringBuilder(), str));
  }

  static String rec(int len, StringBuilder sb, String str){
    sb.append(str.charAt(len));
    
    if (len==0){
      return sb.toString();
    }
    
    return rec(len-1, sb, str);
  }
}
