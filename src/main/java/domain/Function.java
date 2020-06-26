package domain;

import java.util.Arrays;

public enum Function {
	ORDER(1),
	PAYMENT(2),
	EXIT(3);

	private final int number;

	Function(final int number) {
		this.number = number;
	}

	public static Function of(int number){
		return Arrays.stream(Function.values())
			.filter(function -> function.isSameNumber(number)).
			findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 기능을 찾을 수 없습니다. number = " + number));
	}

	private boolean isSameNumber(int number){
		return this.number == number;
	}
}
