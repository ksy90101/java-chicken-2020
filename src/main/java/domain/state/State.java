package domain.state;

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

    public int getNumber() {
        return number;
    }

    public String getPrint() {
        return print;
    }
}
