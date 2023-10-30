package validator;

public class TryCountValidator {

    public static void validateString(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다. 애플리케이션을 종료합니다.");
        }
    }

    public static void validateEmpty(String tryCount) {
        if(tryCount.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수가 빈 값입니다. 애플리케이션을 종료합니다.");
        }
    }
}
