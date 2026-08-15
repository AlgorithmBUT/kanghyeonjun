package 재귀;

// 문자열에서 연속된 같은 문자 제거하기

public class practice13 {
  public static void main(String[] args) {
    String str = "aaaaabbbbbcdsfaeffffeedszccxxccxccccc";
    System.out.println(rec(0, str, new StringBuilder(), ' '));
  }

  static String rec(int idx, String str, StringBuilder sb, char cur){
    if (idx==str.length()){
      return sb.toString();
    }
    if (str.charAt(idx)!=cur){
      sb.append(str.charAt(idx));
      cur=str.charAt(idx);
    }

    return rec(idx+1, str, sb, cur);
  }
}
