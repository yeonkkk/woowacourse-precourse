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
}