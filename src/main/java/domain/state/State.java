package domain.state;

import java.util.Arrays;

public enum State {
    ORDER(1),
    PAYMENT(2),
    EXIT(3);

    private int number;

    State(int number) {
        this.number = number;
    }

    public static boolean isContinue(int featNumber) {
        return featNumber != EXIT.number;
    }

    public static State isCorrectState(int featNumber) {
        return Arrays.stream(values())
                .filter(state -> state.number == featNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾을수 없는 기능입니다."));
    }
}
