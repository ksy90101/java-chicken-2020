package domain.discount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountDiscountTest {

    @Test
    void calculateDiscount() {
        AmountDiscount amountDiscount = new AmountDiscount();
        assertThat(amountDiscount.calculateDiscount(100000, 10)).isEqualTo(90000);
    }

    @Test
    void incorrectCalculateDiscount() {
        AmountDiscount amountDiscount = new AmountDiscount();
        assertThatThrownBy(() -> amountDiscount.calculateDiscount(10000))
                .isInstanceOf(IllegalAccessError.class);
    }
}