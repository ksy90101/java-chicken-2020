package domain.discount;

import domain.menu.PaymentAmount;

import java.util.Arrays;

public enum PaymentWay {
    CARD(1, new PaymentAmount(new CardDiscount())),
    CASH(2, new PaymentAmount(new CashDiscount()));

    private int number;
    private PaymentAmount paymentAmount;

    PaymentWay(int number, PaymentAmount paymentAmount) {
        this.number = number;
        this.paymentAmount = paymentAmount;
    }

    public static PaymentAmount getPaymentAmount(int paymentWayNumber) {
        PaymentWay paymentWay = Arrays.stream(values())
                .filter(payment -> payment.getNumber() == paymentWayNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 결제 방식입니다."));

        return paymentWay.getPaymentAmount();
    }

    public int getNumber() {
        return number;
    }

    public PaymentAmount getPaymentAmount() {
        return paymentAmount;
    }
}
