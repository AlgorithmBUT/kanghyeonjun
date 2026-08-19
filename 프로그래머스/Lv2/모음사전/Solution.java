package 프로그래머스.Lv2.모음사전;

class Solution {
    
    static char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    static StringBuilder sb = new StringBuilder();
    static String target = "";
    static int cnt = 0;
    static int ans = 0;
    
    public int solution(String word) {
        target = word;
        dfs(0);
        return ans;
    }
    
    static void dfs(int d) {

        if (d==5) {
            return;
        }

        for (int i=0; i<vowel.length; i++) {
            cnt ++;
            sb.append(vowel[i]);

            if (sb.toString().equals(target)) {
                ans=cnt;
            }

            dfs(d+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
