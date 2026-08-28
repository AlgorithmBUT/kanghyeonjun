package 프로그래머스.Lv2.n진수게임;

class Solution {

    public String solution(int n, int t, int m, int p) {

        StringBuilder ans = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for (int i=0; i<t*m; i++){
            num.append(numChange(i,n));
        }
        
        System.out.println(num);
        
        for (int i=p-1; i<num.length(); i+=m){
            ans.append(num.charAt(i));
        }
        return ans.toString().substring(0,t);
    }

    // n진수 변환
    static String numChange(int num, int n){

        StringBuilder sb = new StringBuilder();
        
        if (num==0){
            sb.append("0");
        }

        while (num>0){
            int rem = num%n;
            if (rem >=10){
                sb.append(numToAlpha(rem));
            } else{
                sb.append(String.valueOf(num%n));
            }
            num/=n;
        }

        return sb.reverse().toString();
    }

    // 11~15진수 표현
    static char numToAlpha(int rem){
        char[] ch = {'A','B','C','D','E','F'};
        return ch[rem%10];
    }
}
