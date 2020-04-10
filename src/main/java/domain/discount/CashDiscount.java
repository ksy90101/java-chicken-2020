package domain.discount;

public class CashDiscount implements Discount {
    private static final double DISCOUNT_RATE = 0.05;

    @Override
    public long calculateDiscount(long payment) {
        return (long) (payment - payment * DISCOUNT_RATE);
    }
}
