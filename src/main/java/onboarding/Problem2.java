package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int len = cryptogram.length();

        if (len <= 2) {
            return confirmShortStr(cryptogram, len);
        }
    }

    private static String confirmShortStr(String str, int len) {
        if (len == 2 && str.charAt(0) == str.charAt(1)) {
            return "";
        }
        return str;
    }
}