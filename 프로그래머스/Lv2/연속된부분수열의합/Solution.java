package 프로그래머스.Lv2.연속된부분수열의합;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int right = -1;
        int sum = 0;

        int answerStart = 0;
        int answerEnd = sequence.length - 1;

        for (int left = 0; left < sequence.length; left++) {

            while (right + 1 < sequence.length && sum < k) {
                right++;
                sum += sequence[right];
            }

            if (sum == k) {
                if (right - left < answerEnd - answerStart) {
                    answerStart = left;
                    answerEnd = right;
                }
            }

            sum -= sequence[left];
        }

        return new int[]{answerStart, answerEnd};
    }
}
