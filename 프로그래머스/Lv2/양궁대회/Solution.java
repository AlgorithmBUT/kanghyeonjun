package 프로그래머스.Lv2.양궁대회;

import java.util.*;

class Solution {

    static int[] lionArr = new int[11];
    static int[] apeachArr;
    static int arrow;
    static int[] ans;
    static int dif;

    public int[] solution(int n, int[] info) {
        apeachArr = info;
        arrow = n;

        dfs(0, 0, 0);

        return ans == null ? new int[]{-1} : ans;
    }

    static void dfs(int d, int apeachScore, int curScore) {

        if (d == 11) {

            // 남은 화살 0점에 넣기
            if (arrow > 0) {
                lionArr[10] += arrow;
            }

            for (int i = 0; i < 11; i++) {
                if (lionArr[i] == 0 && apeachArr[i] == 0) {
                    continue;
                }

                if (lionArr[i] > apeachArr[i]) {
                    curScore += (10 - i);
                } else {
                    apeachScore += (10 - i);
                }
            }

            int diff = curScore - apeachScore;

            if (diff > 0) {

                // 더 큰 점수 차이
                if (diff > dif) {
                    dif = diff;
                    ans = Arrays.copyOf(lionArr, 11);
                }

                // 점수 차이가 같으면
                else if (diff == dif) {
                    for (int i = 10; i >= 0; i--) {

                        if (lionArr[i] > ans[i]) {
                            ans = Arrays.copyOf(lionArr, 11);
                            break;
                        }

                        else if (lionArr[i] < ans[i]) {
                            break;
                        }
                    }
                }
            }

            if (arrow > 0) {
                lionArr[10] -= arrow;
            }

            return;
        }

        // 현재 점수를 라이언이 가져가는 경우
        if (apeachArr[d] + 1 <= arrow) {

            lionArr[d] = apeachArr[d] + 1;
            arrow -= lionArr[d];

            dfs(d + 1, apeachScore, curScore);

            arrow += lionArr[d];
            lionArr[d] = 0;
        }

        // 현재 점수를 포기하는 경우
        dfs(d + 1, apeachScore, curScore);
    }
}
