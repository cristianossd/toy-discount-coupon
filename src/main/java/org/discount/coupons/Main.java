package org.discount.coupons;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            CouponStore couponStore = new CouponStore();
            couponStore.addCoupon(new Coupon("PROMO10", 10, 3));
            couponStore.addCoupon(new Coupon("PROMO15", 15, 2));
            couponStore.addCoupon(new Coupon("PROMO20", 20, 1));

            float firstPurchasePrice = (float) 1280.20;
            String firstGivenCoupon = "PROMO20";
            Coupon firstCoupon = couponStore.getCoupon(firstGivenCoupon);
            float firstFinalPrice = Checkout.applyDiscount(firstPurchasePrice, firstCoupon);
            System.out.println("First: final price is " + firstFinalPrice);

            float secondPurchasePrice = (float) 521.11;
            String secondGivenCoupon = "PROMO20";
            Coupon secondUsedCoupon = couponStore.getCoupon(firstGivenCoupon);
            float secondFinalPrice = Checkout.applyDiscount(secondPurchasePrice, secondUsedCoupon);
        } catch (Exception e) {
            System.out.println("Unexpected behavior");
            e.printStackTrace();
            System.out.println(e);
        }
    }
}