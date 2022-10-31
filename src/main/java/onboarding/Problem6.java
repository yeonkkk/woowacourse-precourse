package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static Map<String, Set<String>> makeUserMap(List<List<String>> users) {

        Map<String, Set<String>> userMap = new HashMap<>();
        String email, nickname;

        for (List<String> user : users) {
            email = user.get(0);
            nickname = user.get(1);

            if (nickname.length() == 1) continue;

            userMap.put(email, createNicknameCharSet(nickname));
        }
        return userMap;
    }

    private static Set<String> createNicknameCharSet(String nickname) {
        Set<String> nicknameSet = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            nicknameSet.add(nickname.substring(i, i + 2));
        }

        return nicknameSet;
    }
}
