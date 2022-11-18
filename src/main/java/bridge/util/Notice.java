package bridge.util;

public enum Notice {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D"),
    RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("게임 성공 여부: %s"),
    ATTEMPTS("총 시도한 횟수: %d");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String of() {
        return message;
    }

    public String of(int attempt) {
        return String.format(message, attempt);
    }

    public String of(boolean result) {
        return String.format(message, FinalResult.of(result));
    }
}
