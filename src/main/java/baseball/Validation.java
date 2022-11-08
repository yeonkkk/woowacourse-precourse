package baseball;


public class Validation {
    private static void verifyNumResponseTypeAndRange(String numResponse) {
        if (!numResponse.matches("^[1-9]*$")) {
            throw new IllegalArgumentException();
        }
    }
}
