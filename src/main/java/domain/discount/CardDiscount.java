package domain.discount;

public class CardDiscount implements Discount {

    @Override
    public long calculateDiscount(long payment) {
        return payment;
    }
}
