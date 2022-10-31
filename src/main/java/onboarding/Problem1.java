package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!verifyPair(pobi) || !verifyPair(crong)) {
            return -1;
        }
    }

    private static boolean verifyPair(List<Integer> pairList) {
        int leftPage = pairList.get(1);
        int rightPage = pairList.get(0);

        return leftPage - rightPage == 1;
    }

    private static class MaxNum {
        private static int findMaxNumByPage(int num) {
            char[] charArray = String.valueOf(num).toCharArray();

            int plusNum = 0;
            int multiplyNum = 1;

            for (char c : charArray) {
                int charToNum = Character.getNumericValue(c);
                plusNum += charToNum;
                multiplyNum *= charToNum;
            }

            return Math.max(plusNum, multiplyNum);
        }
    }
}