package org.discount.coupons;

import java.util.Map;
import java.util.HashMap;

public class CouponStore {
    private Map<String, Coupon> store = new HashMap<String, Coupon>();

    public void addCoupon(Coupon coupon) throws Exception {
        String couponCode = coupon.getCode();
        if (this.store.containsKey(couponCode)) {
            throw new Exception("This coupon already was registered");
        }

        this.store.put(couponCode, coupon);
    }

    public Coupon getCoupon(String couponCode) throws Exception {
        if (!this.store.containsKey(couponCode)) {
            throw new Exception("This cope was not registered");
        }

        return this.store.get(couponCode);
    }

    public void removeCoupon(Coupon coupon) {
        this.store.remove(coupon.getCode());
    }

    public void clear() {
        this.store.clear();
    }
}
