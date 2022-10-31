package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    private static Map<String, Set<String>> friendsMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void makeFriendsMap(List<List<String>> friends) {
        friendsMap = new HashMap<>();
        String userA, userB;

        for (List<String> friend : friends) {
            userA = friend.get(0);
            userB = friend.get(1);

            addUserToFriendsMap(userA, userB);
            addUserToFriendsMap(userB, userA);
        }
    }

    private static void addUserToFriendsMap(String user, String newFriend) {
        if (!friendsMap.containsKey(user)) {
            friendsMap.put(user, new HashSet<>());
        }
        friendsMap.get(user).add(newFriend);
    }
}
