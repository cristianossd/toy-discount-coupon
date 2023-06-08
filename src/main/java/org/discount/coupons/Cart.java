/*
 * @author Cristiano Santos (cristiano.santos@ufba.br)
 * @since 2023-06-03
 */
package org.discount.coupons;

public class Cart {
    CouponStore store;
    float purchasePrice;
    String promoCode = "";
    float finalPrice;

    public Cart(CouponStore store, float purchasePrice) {
        this.store = store;
        this.purchasePrice = purchasePrice;
    }

    public Cart(CouponStore store, float purchasePrice, String promoCode) {
        this.store = store;
        this.purchasePrice = purchasePrice;
        this.promoCode = promoCode;
    }

    public void process() throws Exception {
        if (this.promoCode.isBlank()) {
            this.finalPrice = this.purchasePrice;
        }

        Coupon coupon = this.store.getCoupon(this.promoCode);
        this.finalPrice = Checkout.applyDiscount(this.purchasePrice, coupon);
    }

    public void updatePurchase(float newPurchasePrice) {
        this.purchasePrice = newPurchasePrice;
    }

    public void updateCoupon(String promoCode) {
        this.promoCode = promoCode;
    }

    public float getFinalPrice() throws Exception {
        this.process();
        return this.finalPrice;
    }
}