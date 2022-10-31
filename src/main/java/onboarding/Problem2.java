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

    private static class UniqueStr {
        private static int cur;
        private static int next;
        private static StringBuilder preStr;

        private static boolean comparePreCur(String str, int lastIdx) {
            int idx = preStr.length() - 1;

            while (idx >= 0 && preStr.charAt(idx) == str.charAt(cur)) {
                preStr.deleteCharAt(idx);
                cur++;
                next++;
                idx = preStr.length() - 1;

                if (cur > lastIdx) {
                    return false;
                }
            }
            return true;
        }
    }

}