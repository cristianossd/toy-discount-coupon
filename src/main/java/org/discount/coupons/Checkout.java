package org.discount.coupons;

public class Checkout {
    public static float applyDiscount(float totalPrice, Coupon coupon) throws Exception {
        if (!coupon.isValid()) {
            throw new Exception("Cannot apply discount from an invalid coupon");
        }

        int discount = coupon.getDiscount();
        float discountRate = discount / 100;
        float finalPrice = totalPrice - (totalPrice * discountRate);

        coupon.consume();
        return finalPrice;
    }
}