package domain.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashDiscountTest {

    @Test
    void calculateDiscount() {
        Discount cashDiscount = new CashDiscount();
        Assertions.assertThat(cashDiscount.calculateDiscount(10000)).isEqualTo(9500);
    }
}