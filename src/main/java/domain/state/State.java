package domain.state;

import java.util.Arrays;

public enum State {
    ORDER(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    EXIT(3, "프로그램 종료");

    private int number;
    private String print;

    State(int number, String print) {
        this.number = number;
        this.print = print;
    }

    public static boolean isContinue(int featNumber){
        return featNumber != 3;
    }

    public static State isCorrectState(int featNumber){
        return Arrays.stream(values())
                .filter(state -> state.number == featNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾을수 없는 기능입니다."));
    }
}
