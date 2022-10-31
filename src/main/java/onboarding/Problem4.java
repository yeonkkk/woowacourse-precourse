package onboarding;


public class Problem4 {
    public static String solution(String word) {
        String answer = "";
    }

    private static int findPair(char targetChar) {
        if (65 <= targetChar && targetChar <= 90) {
            return 155 - targetChar;
        } else if (97 <= targetChar && targetChar <= 122) {
            return 219 - targetChar;
        }
        return targetChar;
    }
}
