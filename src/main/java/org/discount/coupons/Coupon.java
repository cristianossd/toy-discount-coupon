package org.discount.coupons;

public class Coupon {
    private String code;
    private int discount;
    private int usages = 1;

    public Coupon(String code, int discount) throws Exception {
        this.code = code;
        this.setDiscount(discount);
    }

    public Coupon(String code, int discount, int usages) throws Exception {
        this.code = code;
        this.setDiscount(discount);
        this.setUsages(usages);
    }

    private void setDiscount(int discount) throws Exception {
        if (discount > 100) {
            throw new Exception("Discount value must be less than 100");
        }

        if (discount <= 0) {
            throw new Exception("Discount value must be greater than 0");
        }

        this.discount = discount;
    }

    private void setUsages(int usages) throws Exception {
        if (usages <= 0) {
            throw new Exception("Usages must be greater than 0");
        }

        this.usages = usages;
    }

    public boolean isValid() {
        return this.usages > 0;
    }

    public void consume() throws Exception {
        if (!this.isValid()) {
            throw new Exception("Coupon cannot be used anymore");
        }

        this.usages--;
    }

    public String getCode() {
        return this.code;
    }

    public int getDiscount() {
        return this.discount;
    }

    public int getUsages() {
        return this.usages;
    }
}
