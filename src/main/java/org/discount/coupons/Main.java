package org.discount.coupons;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            CouponStore couponStore = new CouponStore();
            String promoCode = PromoCodeGenerator.generate();
            couponStore.addCoupon(new Coupon(promoCode, 20, 1));

            float firstPurchasePrice = (float) 1280.20;
            Coupon firstCoupon = couponStore.getCoupon(promoCode);
            float firstFinalPrice = Checkout.applyDiscount(firstPurchasePrice, firstCoupon);
            System.out.println("First: final price is " + firstFinalPrice);

            float secondPurchasePrice = (float) 521.11;
            Coupon secondUsedCoupon = couponStore.getCoupon(promoCode);
            float secondFinalPrice = Checkout.applyDiscount(secondPurchasePrice, secondUsedCoupon);
        } catch (Exception e) {
            System.out.println("Unexpected behavior");
            e.printStackTrace();
            System.out.println(e);
        }
    }
}