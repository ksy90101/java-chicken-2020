package domain.discount;

public class AmountDiscount implements Discount {
    private static final int DISCOUNT_AMOUNT = 10;
    private static final int DISCOUNT_MONEY = 10000;

    public static long calculateDiscount(long payment, long chickenMenuCount) {
        return payment - calculateDiscountMoney(chickenMenuCount);
    }

    private static long calculateDiscountMoney(long chickenMenuCount) {
        long amount = chickenMenuCount / DISCOUNT_AMOUNT;
        return amount * DISCOUNT_MONEY;
    }

    @Override
    public long calculateDiscount(long payment) {
        throw new IllegalAccessError("지원하지 않는 메소드입니다.");
    }
}
