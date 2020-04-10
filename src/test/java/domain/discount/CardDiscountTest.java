package domain.discount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardDiscountTest {

    @Test
    void calculateDiscount() {
        CardDiscount cardDiscount = new CardDiscount();
        assertThat(cardDiscount.calculateDiscount(10000)).isEqualTo(10000);
    }
}