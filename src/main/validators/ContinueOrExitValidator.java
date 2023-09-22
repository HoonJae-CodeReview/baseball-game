package main.validators;

public final class ContinueOrExitValidator {

    private ContinueOrExitValidator() {}

    public static void validateContinueOrExitResponse(String stringValue) {
        if (!isCorrectInputValue(stringValue)) {
            throw new IllegalArgumentException("제시된 항목에서 선택해주세요.");
        }
    }

    private static boolean isCorrectInputValue(String stringValue) {
        return stringValue.equals("1") || stringValue.equals("2");
    }

}
