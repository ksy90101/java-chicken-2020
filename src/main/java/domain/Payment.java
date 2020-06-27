package domain;

import java.util.Arrays;

public enum Payment {
	CARD(1),
	CASH(2);

	private final int number;

	Payment(final int number) {
		this.number = number;
	}

	public static Payment of(int number){
		return Arrays.stream(Payment.values())
			.filter(payment -> payment.isSameNumber(number))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 결제 방식이 존재하지 않습니다. number = " + number));
	}

	private boolean isSameNumber(int number){
		return this.number == number;
	}
}
