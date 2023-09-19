package main.validators;

public final class ContinueOrExitValidator {

    private ContinueOrExitValidator() {}

    public static void validateContinueOrExitResponse(String stringValue) {
        if (!stringValue.equals("1") && !stringValue.equals("2")) {
            throw new IllegalArgumentException("제시된 항목에서 선택해주세요.");
        }
    }

}
